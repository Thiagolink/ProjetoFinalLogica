/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.servico;

import GUI.GUICliente;
import control.GerenciadorPedidos;
import control.GerenciadorPagamento;
import control.GerenciadorDemanda;
import domain.Pedido;
import domain.Pagamento;
import domain.Demanda;
import domain.Usuario;
import excecao.DemandaInvalidoException;
import excecao.PagamentoInvalidoException;
import excecao.PedidoInvalidoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class GUIClienteServico implements GUICliente {

    private static Scanner in = new Scanner(System.in);
    private GerenciadorDemanda gerenciadorDemanda = new GerenciadorDemanda();
    private GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos(new FabricaNotificacaoServico(), new NotaFiscalBuilderServico());
    ArrayList<Demanda> listaProdutos = new ArrayList<>();
    private GerenciadorPagamento gerenciadorPagamento = new GerenciadorPagamento();

    @Override
    public void cadastrarPedido(Usuario usuario) {

        System.out.println("---------- Cadastrar Pedido----------");
        long idCliente = usuario.getId();
        System.out.println("Descrição: ");
        String descricao = in.nextLine();
        System.out.println("Quantos servicos deseja adicionar?");
        int servicos = in.nextInt();

        for (; servicos > 0; servicos--) {
            listarDemandas();
            System.out.println("Digite o IdServico do servico escolhido: ");
            long id = in.nextLong();
            listaProdutos.add(gerenciadorDemanda.getDemanda(id));
        }
        System.out.println("Numero do Cartao(6 digitos): ");
        long numeroCartao = in.nextLong();

        System.out.println("Banco");
        String Banco = in.next();

        Pedido pedido = new Pedido(idCliente, new Date(), descricao, 'I', listaProdutos);
        Pagamento pagamento = new CartaoDebito(numeroCartao, Banco, pedido.getIdServico(), usuario.getNome());
        pagamento.calcularPagamento(listaProdutos);
        try {
            gerenciadorPedidos.cadastrarPedidos(pedido, pagamento, usuario, "Servico");
        } catch (PedidoInvalidoException ex) {
            Logger.getLogger(GUIClienteServico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DemandaInvalidoException ex) {
            Logger.getLogger(GUIClienteServico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PagamentoInvalidoException ex) {
            Logger.getLogger(GUIClienteServico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void listarDemandas() {
        try {
            List<Demanda> listDemanda = gerenciadorDemanda.listarDemandas();

            for (Demanda produto : listDemanda) {

                Servico servico = (Servico) produto;
                System.out.println("---------------------------------------");
                System.out.println("Nome: " + servico.getNome());
                System.out.println("IdProduto: " + servico.getIdDemanda());
                System.out.println("Empresa Fornecedora: " + servico.getEmpresaFornecedora());
                System.out.println("Preco: " + servico.getPreco());
                System.out.println("Descricao: " + servico.getDescricao());
                System.out.println("Prazo: " + servico.getPrazo());
                System.out.println("---------------------------------------");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void listarPedidos(Usuario usuario) {
        List<Pedido> listPedido = gerenciadorPedidos.getListarPedidoUsuario(usuario.getId());

        for (Pedido pedido : listPedido) {

            System.out.println("---------------------------------------");
            System.out.println("IdUsuarioSolicitante: " + pedido.getIdUsuarioSolicitante());
            System.out.println("IdDemanda: " + pedido.getIdServico());
            System.out.println("Data: " + pedido.getDataAbertura());
            System.out.println("IdUsuarioDemandando: " + pedido.getIdUsuarioDemandando());
            System.out.println("Descricao: " + pedido.getDescricao());
            System.out.println("Status: " + pedido.getStatus());
            System.out.println("---------------------------------------");
        }
    }
}
