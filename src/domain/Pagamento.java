/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public abstract class Pagamento {
    private long idDemanda;
    private String nome;
    private double valor;

    public Pagamento() {
    }

    public Pagamento(long idDemanda, String nome) {
        this.idDemanda = idDemanda;
        this.nome = nome;
        this.valor = 0;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the idDemanda
     */
    public long getIdDemanda() {
        return idDemanda;
    }

    /**
     * @param idDemanda the idDemanda to set
     */
    public void setIdDemanda(long idDemanda) {
        this.idDemanda = idDemanda;
    }
    public void somaValor(double valor){
        this.valor += valor;
    }
    public abstract void calcularPagamento(ArrayList<Demanda> listaProdutos);
    
    public abstract boolean validar();
}
