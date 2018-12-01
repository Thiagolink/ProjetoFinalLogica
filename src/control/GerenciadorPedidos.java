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
import domain.Pedido;
import domain.Pagamento;
import domain.Usuario;
import domain.UsuarioCliente;
import excecao.DemandaInvalidoException;
import excecao.PagamentoInvalidoException;
import excecao.PedidoInvalidoException;
import instancia.estoque.Item;

import java.util.ArrayList;

public class GerenciadorPedidos {

	private /*@ spec_public nullable @*/ IDaoPedido daoPedido;
    private /*@ spec_public nullable @*/ GerenciadorPagamento gerenciadorPagamento;
    private /*@ spec_public nullable @*/ GerenciadorDemanda gerenciadorDemandas;
    private /*@ spec_public nullable @*/ GerenciadorNotificao notificao;
    private /*@ spec_public nullable @*/ GerarNotaFiscal gerarNotaFiscal;

    
    /*@
     @		requires fabricaNotificacao != null;
     @		requires notaFiscalBuilder != null;
     @		assignable this.daoPedido;
     @		ensures daoPedido != null ;
     @		ensures gerenciadorPagamento != null && (gerenciadorPagamento instanceof GerenciadorPagamento);
     @		ensures notificao != null && (notificao instanceof GerenciadorNotificao);
     @		ensures gerarNotaFiscal != null && (gerarNotaFiscal instanceof GerarNotaFiscal);
     @*/
    public GerenciadorPedidos(FabricaNotificacao fabricaNotificacao, NotaFiscalBuilder notaFiscalBuilder) {
        daoPedido = DaoPedido.getInstance();
        gerenciadorPagamento = new GerenciadorPagamento();
        notificao = new GerenciadorNotificao(fabricaNotificacao);
        gerarNotaFiscal = new GerarNotaFiscal(notaFiscalBuilder);
    }

    
    /*@
    @		requires pedidos != null;
    @		requires pagamento != null;
    @		requires usuario != null;
    @		requires empresa != "";
    @*/

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

    /*@
     @ 		requires pedido != null;
     @*/
    public void removerPedido(Pedido pedido) {
        this.daoPedido.removerPedido(pedido);
    }
    /*@ ensures \result != null;
      @*/
    public ArrayList<Pedido> listarPedidos() {
        return this.daoPedido.listarPedidos();
    }
    
    /*@
    @	requires 0 <= codigo;
    @	ensures \result != null; 
    @*/
    public Pedido getPedido(long codigo) {
        return this.daoPedido.pegarPedido(codigo);
    }

    /*@
    @	requires 0 <= usuario;
    @	ensures \result != null; 
    @*/
    public ArrayList<Pedido> getListarPedidoUsuario(long usuario) {
        return this.daoPedido.listarPedidosUsuario(usuario);
    }

    /*@		private normal_behavior
    @		requires pedido != null;
    @		ensures \result == true;
    @	also
    @		private exceptional_behavior
    @		requires pedido.getIdUsuarioSolicitante() < 0 || pedido.getDescricao().equals("") || daoPedido.pegarPedido(pedido.getIdServico()) != null;
    @		signals_only PedidoInvalidoException;
    @		signals (PedidoInvalidoException e);
    @*/
    private /*@ pure @*/ boolean validarPedido(Pedido pedido) throws PedidoInvalidoException {
        if (pedido.getIdUsuarioSolicitante() < 0) {
            throw new PedidoInvalidoException("Solicitante n�o encontrado");

        } else if (pedido.getDescricao().equals("")) {
            throw new PedidoInvalidoException("Servico estar vazia");

        } else if (daoPedido.pegarPedido(pedido.getIdServico()) != null) {
            throw new PedidoInvalidoException("ID da demanda invalido, contate o administrador.");

        }
        return true;
    }
}