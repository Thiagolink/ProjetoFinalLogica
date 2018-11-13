/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.estoque;

import GUI.GUICliente;
import control.GerenciadorPedidos;
import control.GerenciadorPagamento;
import control.GerenciadorDemanda;
import domain.Pedido;
import domain.Pagamento;
import domain.Demanda;
import domain.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class GUIClienteEstoque implements GUICliente {

    private static Scanner in = new Scanner(System.in);
    private GerenciadorDemanda gerenciadorDemanda = new GerenciadorDemanda();
    private GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos(new FabricaNotificacaoEstoque(), new NotaFiscalBuilderEstoque());
    ArrayList<Demanda> listaProdutos = new ArrayList<>();
    private GerenciadorPagamento gerenciadorPagamento = new GerenciadorPagamento();

    public void cadastrarPedido(Usuario usuario) {

        try {

            System.out.println("---------- Cadastrar Pedido----------");
            long idCliente = usuario.getId();

            System.out.println("Quantos Itens deseja adicionar?");
            int servicos = in.nextInt();
            Item item;
            for (; servicos > 0; servicos--) {
                listarDemandas();
                System.out.println("Digite o IdServico do servico escolhido: ");
                long id = in.nextLong();
                System.out.println("Digite a quantidade: ");
                int quantidade = in.nextInt();
                item = (Item) gerenciadorDemanda.getDemanda(id);
                if (item.getQuantidadeEmEstoque() < quantidade) {
                    System.out.println("Quantidade indisponivel");
                } else {
                    item.setQuantidadeEmEstoque(quantidade);
                    listaProdutos.add(item);
                }
                
                        
            }
            System.out.println("Descrição: ");
            String descricao = in.nextLine();
            Pedido pedido = new Pedido(idCliente, new Date(), descricao, 'P', listaProdutos);
            Pagamento pagamento = new BoletoBancario(new Date(), pedido.getIdServico(), "Cartao de Debito");
            pagamento.calcularPagamento(listaProdutos);

            gerenciadorPedidos.cadastrarPedidos(pedido, pagamento, usuario, "Estoque");

        } catch (Exception e) {

        }

    }

    @Override
    public void listarDemandas() {
        try {
            List<Demanda> listDemanda = gerenciadorDemanda.listarDemandas();
            Item item;
            for (Demanda produto : listDemanda) {

                item = (Item) produto;
                System.out.println("----------------------------------");
                System.out.println("Nome:" + item.getNome());
                System.out.println("ID do Produto: " + item.getIdDemanda());
                System.out.println("Quantidade: " + item.getQuantidadeEmEstoque());
                System.out.println("Preco: " + item.getPreco());
                System.out.println("Descricao: " + item.getDescricao());
                System.out.println("Prazo: " + item.getPrazo());
                System.out.println("----------------------------------");
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

            System.out.println("----------------------------------");
        }
    }
}
