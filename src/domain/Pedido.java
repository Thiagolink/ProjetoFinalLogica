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

    private long idUsuarioSolicitante;
    private long idPedido;
    private Date dataAbertura;
    private long idUsuarioDemandando;
    private String descricao;
    private char status;
    private ArrayList<Demanda> listaProdutos;
    private static AtomicInteger count = new AtomicInteger();

    public Pedido() {
    }

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
    public long getIdUsuarioSolicitante() {
        return idUsuarioSolicitante;
    }

    /**
     * @param idUsuarioSolicitante the idUsuarioSolicitante to set
     */
    public void setIdUsuarioSolicitante(long idUsuarioSolicitante) {
        this.idUsuarioSolicitante = idUsuarioSolicitante;
    }

    /**
     * @return the idServico
     */
    public long getIdServico() {
        return idPedido;
    }

    /**
     * @param idServico the idServico to set
     */
    public void setIdServico(long idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the dataAbertura
     */
    public Date getDataAbertura() {
        return dataAbertura;
    }

    /**
     * @param dataAbertura the dataAbertura to set
     */
    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    /**
     * @return the idUsuarioServicondo
     */
    public long getIdUsuarioDemandando() {
        return idUsuarioDemandando;
    }

    /**
     * @param idUsuarioServicondo the idUsuarioServicondo to set
     */
    public void setIdUsuarioDemandando(long idUsuarioDemandando) {
        this.idUsuarioDemandando = idUsuarioDemandando;
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
            throw new PedidoInvalidoException("Descrição inválida");
        }
        this.descricao = descricao;
    }

    /**
     * @return the status
     */
    public char getStatus() {

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
    public ArrayList<Demanda> getListaProdutos() {
        return listaProdutos;
    }

    /**
     * @param listaProdutos the listaProdutos to set
     */
    public void setListaProdutos(ArrayList<Demanda> listaProdutos) throws PedidoInvalidoException {

        this.listaProdutos = listaProdutos;
    }

}
