/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.fastfood;

import domain.Demanda;
import domain.Pagamento;
import excecao.PagamentoInvalidoException;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class CartaoCredito extends Pagamento {

    private long numeroCartao;
    private int numeroParcelas;
    private String banco;
    private int codigoSeguranca;

    public CartaoCredito() {
    }

    public CartaoCredito(long numeroCartao, int numeroParcelas, String banco, int codigoSeguranca, long idDemanda, String nome) {
        super(idDemanda, nome);
        this.numeroCartao = numeroCartao;
        this.numeroParcelas = numeroParcelas;
        this.banco = banco;
        this.codigoSeguranca = codigoSeguranca;
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
     * @return the numeroParcelas
     */
    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    /**
     * @param numeroParcelas the numeroParcelas to set
     */
    public void setNumeroParcelas(int numeroParcelas) throws PagamentoInvalidoException {
        if (numeroParcelas < 0) {
            throw new PagamentoInvalidoException("Numero invalido.");
        }

        this.numeroParcelas = numeroParcelas;
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

    /**
     * @return the codigoSeguranca
     */
    public int getCodigoSeguranca() {
        return codigoSeguranca;
    }

    /**
     * @param codigoSeguranca the codigoSeguranca to set
     */
    public void setCodigoSeguranca(int codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public void calcularPagamento(ArrayList<Demanda> listaProdutos) {
        for (Demanda produto : listaProdutos) {

            Alimento alimento = (Alimento) produto;
            somaValor(alimento.getPreco());
        }
    }

}
