/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.fastfood;

import GUI.GUICliente;
import control.GerenciadorPedidos;
import control.GerenciadorPagamento;
import control.GerenciadorDemanda;
import instancia.servico.CartaoDebito;
import domain.Pedido;
import domain.Demanda;
import domain.Pagamento;
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
public class GUIClienteFastFood implements GUICliente {

    private static Scanner in = new Scanner(System.in);
    private GerenciadorDemanda gerenciadorDemanda = new GerenciadorDemanda();
    private GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos(new FabricaNotificacaoFastFood(), new NotaFiscalBuilderFastFood());
    ArrayList<Demanda> listaProdutos = new ArrayList<>();
    private GerenciadorPagamento gerenciadorPagamento = new GerenciadorPagamento();

    public void cadastrarPedido(Usuario usuario) {

        System.out.println("---------- Cadastrar Pedido----------");
        long idCliente = usuario.getId();
        System.out.println("Quantos alimentos deseja adicionar?");
        int servicos = in.nextInt();
        for (; servicos > 0; servicos--) {

            listarDemandas();
            System.out.print("Digite o Id do alimento escolhido: "+"\n");
            long id = Long.parseLong(in.next());
            listaProdutos.add(gerenciadorDemanda.getDemanda(id));
        }
        in.nextLine();
        System.out.print("Observação: "+"\n");
        String observacao = in.nextLine();
        System.out.println("Numero do Cartao (6 digitos)");
        long numeroCartao = in.nextLong();
        System.out.println("Banco");
        String Banco = in.next();

        Pedido pedido = new Pedido(idCliente, new Date(), observacao, 'I', listaProdutos);
        Pagamento pagamento = new CartaoDebito(numeroCartao, Banco, pedido.getIdServico(), "Cartao de Debito");
        pagamento.calcularPagamento(listaProdutos);
        try {
            gerenciadorPedidos.cadastrarPedidos(pedido, pagamento, usuario, "Fast Food");
        } catch (PedidoInvalidoException | DemandaInvalidoException | PagamentoInvalidoException ex) {
            Logger.getLogger(GUIClienteFastFood.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void listarDemandas() {
        try {
            List<Demanda> listDemanda = gerenciadorDemanda.listarDemandas();
            Alimento alimento;
            for (Demanda produto : listDemanda) {

                alimento = (Alimento) produto;
                System.out.println("----------------------------------");
                System.out.println("Nome: " + alimento.getNome());
                System.out.println("IdProduto: " + alimento.getIdDemanda());
                System.out.println("Tipo do Alimento: " + alimento.getTipoAlimento());
                System.out.println("Preco: " + alimento.getPreco());
                System.out.println("Descricao: " + alimento.getDescricao());
                System.out.println("Prazo: " + alimento.getPrazo());
                System.out.println("Fornecedor: " + alimento.getFornecedor());
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void listarPedidos(Usuario usuario) {
        List<Pedido> listPedido = gerenciadorPedidos.getListarPedidoUsuario(usuario.getId());

        for (Pedido pedido : listPedido) {
            System.out.println("----------------------------------");
            System.out.println("IdUsuarioSolicitante: " + pedido.getIdUsuarioSolicitante());
            System.out.println("IdDemanda: " + pedido.getIdServico());
            System.out.println("Data: " + pedido.getDataAbertura());
            System.out.println("IdUsuarioDemandando: " + pedido.getIdUsuarioDemandando());
            System.out.println("Descricao: " + pedido.getDescricao());
            System.out.println("Status: " + pedido.getStatus());
        }
    }
}
