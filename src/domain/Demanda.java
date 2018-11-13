/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import excecao.PedidoInvalidoException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Thiago
 */
public abstract class Demanda {

    /**
     * @return the count
     */
    public static AtomicInteger getCount() {
        return count;
    }

    /**
     * @param aCount the count to set
     */
    public static void setCount(AtomicInteger aCount) {
        count = aCount;
    }

    private long idDemanda;
    private String nome;
    private double preco;
    private String descricao;
    private Date prazo;
    private static AtomicInteger count = new AtomicInteger(0);

    public Demanda() {
    }

    public Demanda(String nome, double preco, String descricao, Date date) {
        this.idDemanda = count.getAndIncrement();
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        date.setMonth(date.getMonth() + 2);
        this.prazo = date;
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
    public void setIdDemanda(long idDemanda) throws PedidoInvalidoException {
        if (idDemanda < 0) {
            throw new PedidoInvalidoException("Id do demanda Invalido");
        }
        this.idDemanda = idDemanda;
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
    public void setNome(String nome) throws PedidoInvalidoException {
        if (!(nome instanceof String)) {
            throw new PedidoInvalidoException("Nome invalido.");
        }
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) throws PedidoInvalidoException {
        if (preco < 0) {
            throw new PedidoInvalidoException("Preço invalido.");
        }
        this.preco = preco;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) throws PedidoInvalidoException {
        if (!(descricao instanceof String)) {
            throw new PedidoInvalidoException("Descrição invalida.");
        }

        this.descricao = descricao;
    }

    
    
    public abstract boolean validar();

    /**
     * @return the prazo
     */
    public Date getPrazo() {
        return prazo;
    }

    /**
     * @param prazo the prazo to set
     */
    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
}
