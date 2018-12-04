/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import excecao.PedidoInvalidoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author hiarl
 */
public class Pedido {

    private /*@ spec_public @*/ long idUsuarioSolicitante;
    private /*@ spec_public @*/ long idPedido;
    private /*@ spec_public @*/ Date dataAbertura;
    private /*@ spec_public @*/ long idUsuarioDemandando;
    private /*@ spec_public @*/ String descricao;
    private /*@ spec_public @*/ char status;
    private /*@ spec_public @*/ ArrayList<Demanda> listaProdutos;
    private static /*@ spec_public @*/ AtomicInteger count = new AtomicInteger();

    public Pedido() {
    }

    //Descobrir como comparar char
    
    /*@
    @	
    @	requires  0 <= idUsuarioSolicitante ;
    @	requires dataAbertura != null;
    @ 	requires  0 <= idUsuarioDemandando;
    @	requires descricao != "";
    @   requires listaProdutos != null;
    @	ensures this.idUsuarioSolicitante == idUsuarioSolicitante;
    @ 	ensures this.idPedido == count.longValue() - 1;
    @	ensures this.dataAbertura == dataAbertura;
    @   ensures this.idUsuarioDemandando == idUsuarioDemandando;
    @   ensures this.descricao == descricao;
    @   ensures this.status == status;
    @	ensures this.listaProdutos == listaProdutos;
    @*/
    public Pedido(long idUsuarioSolicitante, Date dataAbertura,
             String descricao, char status,
            ArrayList<Demanda> listaProdutos) {

        this.idUsuarioSolicitante = idUsuarioSolicitante;
        this.idPedido = count.getAndIncrement();
        this.dataAbertura = dataAbertura;
        this.descricao = descricao;
        this.status = status;
        this.listaProdutos = listaProdutos;
    }

    /**
     * @return the idUsuarioSolicitante
     */
    public /*@ pure @*/ long getIdUsuarioSolicitante() {
        return idUsuarioSolicitante;
    }

    /*@
    @	requires 0 <= idUsuarioSolicitante;
    @	assignable this.idUsuarioSolicitante;
    @ 	ensures this.idUsuarioSolicitante == idUsuarioSolicitante;
    @*/
    public void setIdUsuarioSolicitante(long idUsuarioSolicitante) {
        this.idUsuarioSolicitante = idUsuarioSolicitante;
    }

    /**
     * return the idServico
     */
    public /*@ pure @*/ long getIdServico() {
        return idPedido;
    }

    /*@
    @	requires 0 <= idPedido;
    @	assignable this.idPedido;
    @ 	ensures this.idPedido == idPedido;
    @*/
    public void setIdServico(long idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the dataAbertura
     */
    public /*@ pure @*/ Date getDataAbertura() {
        return dataAbertura;
    }

    /*@
    @	requires dataAbertura != null;
    @	assignable this.dataAbertura;
    @ 	ensures this.dataAbertura == dataAbertura;
    @*/
    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    /**
     * @return the idUsuarioServicondo
     */
    public /*@ pure @*/ long getIdUsuarioDemandando() {
        return idUsuarioDemandando;
    }

    /*@
    @	requires 0 <= idUsuarioDemandando;
    @	assignable this.idUsuarioDemandando;
    @ 	ensures this.idUsuarioDemandando == idUsuarioDemandando;
    @*/
    public void setIdUsuarioDemandando(long idUsuarioDemandando) {
        this.idUsuarioDemandando = idUsuarioDemandando;
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
            throw new PedidoInvalidoException("Descrição inválida");
        }
        this.descricao = descricao;
    }

    /**
     * @return the status
     */
    public /*@ pure @*/ char getStatus() {

        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status) throws PedidoInvalidoException {
        if (Character.isDigit(status)) {
            throw new PedidoInvalidoException("Status inválido");
        }
        this.status = status;
    }

    /**
     * @return the listaProdutos
     */
    public /*@ pure @*/ ArrayList<Demanda> getListaProdutos() {
        return listaProdutos;
    }

    /*@
    @	requires listaProdutos != null;
    @	assignable this.listaProdutos;
    @ 	ensures this.listaProdutos == listaProdutos;
    @*/
    public void setListaProdutos(ArrayList<Demanda> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

}
