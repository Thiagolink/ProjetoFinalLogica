/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import excecao.PedidoInvalidoException;

/**
 *
 * @author Thiago
 */
public abstract class Demanda {

 

    private /*@ spec_public @*/ long idDemanda;
    private /*@ spec_public @*/ String nome;
    private /*@ spec_public @*/ double preco;
    private /*@ spec_public @*/ String descricao;
    private /*@ spec_public @*/ Date prazo;
    private /*@ spec_public @*/ static AtomicInteger count = new AtomicInteger(0);

    public Demanda() {
    }

    /*@
    @	
    @	requires nome != "";
    @	requires 0 <= preco;
    @	requires descricao != "";
    @   requires date != null;
    @ 	ensures this.idDemanda == count.longValue() - 1;
    @	ensures this.nome == nome;
    @   ensures this.preco == preco;
    @   ensures this.descricao == descricao;
    @   ensures this.prazo == date;
    @*/
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
    public /*@ pure @*/ long getIdDemanda() {
        return idDemanda;
    }

    /*@		public normal_behavior
    @			requires 0 <= idDemanda;
    @			assignable this.idDemanda;
    @ 			ensures this.idDemanda == idDemanda;
    @	also
    @		public exceptional_behavior
    @		requires idDemanda < 0;
    @		assignable this.idDemanda;
    @		signals_only PedidoInvalidoException;
    @		signals (PedidoInvalidoException e)
    @				idDemanda < 0;
    @*/
    public void setIdDemanda(long idDemanda) throws PedidoInvalidoException {
        if (idDemanda < 0) {
            throw new PedidoInvalidoException("Id do demanda Invalido");
        }
        this.idDemanda = idDemanda;
    }

    /**
     * @return the nome
     */
    public /*@ pure @*/ String getNome() {
        return nome;
    }

    /*@		public normal_behavior
    @			requires nome != "";
    @			assignable this.nome;
    @ 			ensures this.nome == nome;
    @	also
    @		public exceptional_behavior
    @		requires !(nome instanceof String);
    @		assignable this.nome;
    @		signals_only PedidoInvalidoException;
    @		signals (PedidoInvalidoException e)
    @				!(nome instanceof String);
    @*/
    public void setNome(String nome) throws PedidoInvalidoException {
        if (!(nome instanceof String)) {
            throw new PedidoInvalidoException("Nome invalido.");
        }
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public /*@ pure @*/ double getPreco() {
        return preco;
    }

    /*@		public normal_behavior
     @			requires 0 <= preco;
     @			assignable this.preco;
     @ 			ensures this.preco == preco;
     @	also
     @		public exceptional_behavior
     @		requires preco < 0;
     @		assignable this.preco;
     @		signals_only PedidoInvalidoException;
     @		signals (PedidoInvalidoException e)
     @				preco < 0;
     @*/
    public void setPreco(double preco) throws PedidoInvalidoException {
        if (preco < 0) {
            throw new PedidoInvalidoException("Preço invalido.");
        }
        this.preco = preco;
    }

    /**
     * @return the descricao
     */
    public /*@ pure @*/ String getDescricao() {
        return descricao;
    }

    /*@		public normal_behavior
    @			requires descricao != "";
    @			assignable this.descricao;
    @ 			ensures this.descricao == descricao;
    @	also
    @		public exceptional_behavior
    @		requires !(descricao instanceof String);
    @		assignable this.descricao;
    @		signals_only PedidoInvalidoException;
    @		signals (PedidoInvalidoException e)
    @				!(descricao instanceof String);
    @*/
    public void setDescricao(String descricao) throws PedidoInvalidoException {
        if (!(descricao instanceof String)) {
            throw new PedidoInvalidoException("Descrição invalida.");
        }

        this.descricao = descricao;
    }

    
    
    public abstract /*@ pure @*/ boolean validar();

    /**
     * @return the prazo
     */
    public /*@ pure @*/ Date getPrazo() {
        return prazo;
    }

    /*@ requires prazo != null;
	@ assignable this.prazo;
	@ ensures this.prazo == prazo;
	@*/
    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
    
    /**
     * @return the count
     */
    public static /*@ pure @*/ AtomicInteger getCount() {
        return count;
    }

    /*@ requires aCount != null;
	@ assignable count;
	@ ensures count == aCount;
	@*/
    public static void setCount(AtomicInteger aCount) {
        count = aCount;
    }
}
