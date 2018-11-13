/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DaoPedido;
import dao.IDaoPedido;
import domain.Demanda;
import domain.FabricaNotificacao;
import domain.GerarNotaFiscal;
import domain.NotaFiscal;
import domain.NotaFiscalBuilder;
import instancia.estoque.Item;
import domain.Pedido;
import domain.Pagamento;
import domain.Usuario;
import domain.UsuarioCliente;
import excecao.DemandaInvalidoException;
import excecao.PagamentoInvalidoException;
import excecao.PedidoInvalidoException;
import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public class GerenciadorPedidos {

    private IDaoPedido daoPedido;
    private GerenciadorPagamento gerenciadorPagamento;
    private GerenciadorDemanda gerenciadorDemandas;
    private GerenciadorNotificao notificao;
    private GerarNotaFiscal gerarNotaFiscal;

    public GerenciadorPedidos(FabricaNotificacao fabricaNotificacao, NotaFiscalBuilder notaFiscalBuilder) {
        daoPedido = DaoPedido.getInstance();
        gerenciadorPagamento = new GerenciadorPagamento();
        notificao = new GerenciadorNotificao(fabricaNotificacao);
        gerarNotaFiscal = new GerarNotaFiscal(notaFiscalBuilder);
    }

    public void cadastrarPedidos(Pedido pedidos, Pagamento pagamento, Usuario usuario, String empresa) throws PedidoInvalidoException, DemandaInvalidoException, PagamentoInvalidoException {

        this.daoPedido.adicionarPedido(pedidos);
        if(pagamento != null){
        
        gerenciadorPagamento.cadastrarPagamento(pagamento);
        
        }
        notificao.NotificarInicio(pedidos);
        NotaFiscal notaFiscal = gerarNotaFiscal.gerarNotaFiscal(pedidos, (UsuarioCliente) usuario, empresa, pagamento);
        notaFiscal.imprimir();
        
        
        if (pedidos.getListaProdutos().get(0) instanceof Item && pedidos.getListaProdutos() != null) {
            Item item;
            Item itemBanco;
            for (Demanda demanda : pedidos.getListaProdutos()) {
                item = (Item) demanda;
                itemBanco = (Item) gerenciadorDemandas.getDemanda(demanda.getIdDemanda());
                itemBanco.setQuantidadeEmEstoque((itemBanco.getQuantidadeEmEstoque() - item.getQuantidadeEmEstoque()));
                gerenciadorDemandas.atualizarDemanda(itemBanco);
            }
        }
    }

    public void removerPedido(Pedido pedido) {
        this.daoPedido.removerPedido(pedido);
    }

    public ArrayList<Pedido> listarPedidos() {
        return this.daoPedido.listarPedidos();
    }

    public Pedido getPedido(Long codigo) {
        return this.daoPedido.pegarPedido(codigo);
    }

    public ArrayList<Pedido> getListarPedidoUsuario(Long usuario) {
        return this.daoPedido.listarPedidosUsuario(usuario);
    }

    private boolean validarPedido(Pedido pedido) throws PedidoInvalidoException {
        if (pedido.getIdUsuarioSolicitante() < 0) {
            throw new PedidoInvalidoException("Solicitante não encontrado");

        } else if (pedido.getDescricao().equals("")) {
            throw new PedidoInvalidoException("Servico estar vazia");

        } else if (daoPedido.pegarPedido(pedido.getIdServico()) != null) {
            throw new PedidoInvalidoException("ID da demanda invalido, contate o administrador.");

        }
        return true;
    }
}
