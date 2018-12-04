/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Thiago
 */
public abstract class Pagamento {
		
    private /*@ spec_public @*/ long idDemanda;
    private /*@ spec_public @*/ String nome;
    private /*@ spec_public @*/ double valor;

    public Pagamento() {
    }

    /*@
     @	requires 0 <= idDemanda;
     @	requires nome != "";
     @	ensures this.idDemanda == idDemanda;
     @	ensures this.nome == nome;
     @ 	ensures valor == 0; 
     @*/
    public Pagamento(long idDemanda, String nome) {
        this.idDemanda = idDemanda;
        this.nome = nome;
        this.valor = 0;
    }

    /**
     * @return the nome
     */
    public /*@ pure @*/ String getNome() {
        return nome;
    }

    /*@
    @	requires nome != "";
    @	assignable this.nome;
    @ 	ensures this.nome == nome;
    @*/
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public /*@ pure @*/ double getValor() {
        return valor;
    }

    /*@
    @	requires 0 <= valor;
    @	assignable this.valor;
    @ 	ensures this.valor == valor;
    @*/
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the idDemanda
     */
    public /*@ pure @*/ long getIdDemanda() {
        return idDemanda;
    }

    /*@
    @	requires 0 <= idDemanda;
    @	assignable this.idDemanda;
    @ 	ensures this.idDemanda == idDemanda;
    @*/
    public void setIdDemanda(long idDemanda) {
        this.idDemanda = idDemanda;
    }
    
    
    /*@
    @ 	requires 0 <= valor;
    @	assignable this.valor;
    @	ensures this.valor == \old(this.valor) + valor;
    @*/
    public void somaValor(double valor){
        this.valor += valor;
    }
    public abstract void calcularPagamento(ArrayList<Demanda> listaProdutos);
    
    public /*@ pure @*/ abstract boolean validar();
}
