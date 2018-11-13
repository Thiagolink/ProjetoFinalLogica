/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.servico;

import domain.Demanda;
import domain.Pagamento;
import excecao.PagamentoInvalidoException;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class CartaoDebito extends Pagamento {

    private long numeroCartao;
    private String banco;

    public CartaoDebito() {
    }

    public CartaoDebito(long numeroCartao, String banco, long idPagamento, String nome) {
        super(idPagamento, nome);
        this.numeroCartao = numeroCartao;
        this.banco = banco;
    }

    /**
     * @return the numeroCartao
     */
    public long getNumeroCartao() {
        return numeroCartao;
    }

    /**
     * @param numeroCartao the numeroCartao to set
     */
    public void setNumeroCartao(int numeroCartao) throws PagamentoInvalidoException {
        if (numeroCartao < 0) {
            throw new PagamentoInvalidoException("Numero invalido.");
        }

        this.numeroCartao = numeroCartao;
    }

    /**
     * @return the Banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param Banco the Banco to set
     */
    public void setBanco(String banco) throws PagamentoInvalidoException {
        if (!(banco instanceof String)) {
            throw new PagamentoInvalidoException("Invalido!");
        }

        this.banco = banco;
    }

    @Override
    public boolean validar() {
        if (((int) Math.log10(getNumeroCartao()) + 1) == 6) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void calcularPagamento(ArrayList<Demanda> listaProdutos) {
        for (Demanda produto : listaProdutos) {

            Servico servico = (Servico) produto;
            setValor(getValor() + servico.getPreco());

        }
    }

}
