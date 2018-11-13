/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import excecao.HistoricoInvalidoException;
import java.util.Date;

/**
 *
 * @author hiarl
 */
public class Historico {
    private long idDemanda;
    private long idHistorico;
    private Date dataModificaco;
    private String descricao;
    private Usuario usuarioDemandado;

    public Historico() {
    }

    public Historico(long idDemanda, long idHistorico, Date dataModificaco, String descricao, Usuario usuarioSolicitante) {
        this.idDemanda = idDemanda;
        this.idHistorico = idHistorico;
        this.dataModificaco = dataModificaco;
        this.descricao = descricao;
        this.usuarioDemandado = usuarioSolicitante;
    }

    public long getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(long idDemanda) throws HistoricoInvalidoException {
        if(idDemanda < 0) throw new HistoricoInvalidoException("ID invalido.");
        this.idDemanda = idDemanda;
    }
    
    /**
     * @return the idHistorico
     */
    public long getIdHistorico() {
        return idHistorico;
    }

    /**
     * @param idHistorico the idHistorico to set
     */
    public void setIdHistorico(long idHistorico) throws HistoricoInvalidoException {
        if(idHistorico < 0) throw new HistoricoInvalidoException("ID invalido.");
        this.idHistorico = idHistorico;
    }

    /**
     * @return the dataModificaco
     */
    public Date getDataModificaco() {
        return dataModificaco;
    }

    /**
     * @param dataModificaco the dataModificaco to set
     */
    public void setDataModificaco(Date dataModificaco) throws HistoricoInvalidoException {
        if(!(dataModificaco instanceof Date)) throw new HistoricoInvalidoException("Data invalida.");
        this.dataModificaco = dataModificaco;
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
    public void setDescricao(String descricao) throws HistoricoInvalidoException {
        if(!(descricao instanceof String)) throw new HistoricoInvalidoException("Descrição invalida.");
        this.descricao = descricao;
    }

    /**
     * @return the usuarioDemandado
     */
    public Usuario getUsuarioSolicitante() {
        return usuarioDemandado;
    }

    /**
     * @param usuarioSolicitante the usuarioDemandado to set
     */
    public void setUsuarioSolicitante(Usuario usuarioSolicitante) throws HistoricoInvalidoException {
        if(!(usuarioSolicitante instanceof Usuario)) throw new HistoricoInvalidoException("Usuario invalido.");
        this.usuarioDemandado = usuarioSolicitante;
    }
    
}
