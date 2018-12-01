/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DaoPagamento;
import dao.IDaoPagamento;
import domain.Pagamento;
import excecao.PagamentoInvalidoException;
import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public class GerenciadorPagamento {

    private /*@ spec_public nullable @*/  IDaoPagamento daoPagamento;

    /*@ assignable daoPagamento;
	  @ ensures daoPagamento != null;
	  @*/
    public GerenciadorPagamento() {

        daoPagamento = DaoPagamento.getInstance();
    }

    /*@		public normal_behavior
    @		requires pagamento != null;
    @		ensures pagamento.validar() == true;
    @	also
    @		public exceptional_behavior
    @		requires pagamento.validar() == false;
    @		signals_only PagamentoInvalidoException;
    @		signals (PagamentoInvalidoException e);
    @*/
    public /*@ pure @*/ void cadastrarPagamento(Pagamento pagamento) throws PagamentoInvalidoException {
        if (pagamento.validar()) {
            this.daoPagamento.adicionarPagamento(pagamento);
        }
        else
            throw new PagamentoInvalidoException("Pagamento não efetuado, verifique seus dados");
        

    }

    /*@ requires pagamento != null;
	  @*/
    public void removerPagamento(Pagamento pagamento) {
        this.daoPagamento.removerPagamento(pagamento);
    }
    
    /*@ requires pagamento != null;
	  @*/
    public void atualizarPagamento(Pagamento pagamento) {
        this.daoPagamento.atualizarPagamento(pagamento);
    }

    /*@ ensures \result != null;
	  @*/
    public ArrayList<Pagamento> listarPagamentos() {
        return this.daoPagamento.listarPagamento();
    }

    /*@ requires 0 <= id;
	  @*/
    public Pagamento getPagamento(long id) {
        return this.daoPagamento.pegarPagamento(id);
    }
}
