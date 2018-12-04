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
    private /*@ spec_public @*/ long idDemanda;
    private /*@ spec_public @*/ long idHistorico;
    private /*@ spec_public @*/ Date dataModificaco;
    private /*@ spec_public nullable @*/ String descricao;
    private /*@ spec_public @*/ Usuario usuarioDemandado;

    public Historico() {
    }

    /*@
    @  ensures this.idDemanda == idDemanda;
    @  ensures this.idHistorico == idHistorico;
    @  ensures this.descricao == descricao;
    @  ensures this.dataModificaco == dataModificaco;
    @  ensures this.usuarioDemandado == usuarioDemandado;
    @*/
    public Historico(long idDemanda, long idHistorico, Date dataModificaco, String descricao, Usuario usuarioSolicitante) {
        this.idDemanda = idDemanda;
        this.idHistorico = idHistorico;
        this.dataModificaco = dataModificaco;
        this.descricao = descricao;
        this.usuarioDemandado = usuarioSolicitante;
    }

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
    @		signals_only HistoricoInvalidoException;
    @		signals (HistoricoInvalidoException e)
    @				idDemanda < 0;
    @*/
    public void setIdDemanda(long idDemanda) throws HistoricoInvalidoException {
        if(idDemanda < 0) throw new HistoricoInvalidoException("ID invalido.");
        this.idDemanda = idDemanda;
    }
    
    /**
     * @return the idHistorico
     */
    public /*@ pure @*/ long getIdHistorico() {
        return idHistorico;
    }

    /*@		public normal_behavior
    @			requires 0 <= idHistorico;
    @			assignable this.idHistorico;
    @ 			ensures this.idHistorico == idHistorico;
    @	also
    @		public exceptional_behavior
    @		requires idHistorico < 0;
    @		assignable this.idHistorico;
    @		signals_only HistoricoInvalidoException;
    @		signals (HistoricoInvalidoException e)
    @				idHistorico < 0;
    @*/
    public void setIdHistorico(long idHistorico) throws HistoricoInvalidoException {
        if(idHistorico < 0) throw new HistoricoInvalidoException("ID invalido.");
        this.idHistorico = idHistorico;
    }

    /**
     * @return the dataModificaco
     */
    public /*@ pure @*/ Date getDataModificaco() {
        return dataModificaco;
    }

    /*@		public normal_behavior
    @			requires dataModificaco != null;
    @			assignable this.dataModificaco;
    @ 			ensures this.dataModificaco == dataModificaco;
    @	also
    @		public exceptional_behavior
    @		requires !(dataModificaco instanceof Date);
    @		assignable this.dataModificaco;
    @		signals_only HistoricoInvalidoException;
    @		signals (HistoricoInvalidoException e)
    @				!(dataModificaco instanceof Date);
    @*/
    public void setDataModificaco(Date dataModificaco) throws HistoricoInvalidoException {
        if(!(dataModificaco instanceof Date)) throw new HistoricoInvalidoException("Data invalida.");
        this.dataModificaco = dataModificaco;
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
    @		signals_only HistoricoInvalidoException;
    @		signals (HistoricoInvalidoException e)
    @				!(descricao instanceof String);
    @*/
    public void setDescricao(String descricao) throws HistoricoInvalidoException {
        if(!(descricao instanceof String)) throw new HistoricoInvalidoException("Descrição invalida.");
        this.descricao = descricao;
    }

    /**
     * @return the usuarioDemandado
     */
    public /*@ pure @*/ Usuario getUsuarioSolicitante() {
        return usuarioDemandado;
    }

    /*@		public normal_behavior
    @			requires usuarioSolicitante != null;
    @			assignable this.usuarioDemandado;
    @ 			ensures this.usuarioDemandado == usuarioSolicitante;
    @	also
    @		public exceptional_behavior
    @		requires !(usuarioSolicitante instanceof Usuario);
    @		assignable this.usuarioDemandado;
    @		signals_only HistoricoInvalidoException;
    @		signals (HistoricoInvalidoException e)
    @				!(usuarioSolicitante instanceof Usuario);
    @*/
    public void setUsuarioSolicitante(Usuario usuarioSolicitante) throws HistoricoInvalidoException {
        if(!(usuarioSolicitante instanceof Usuario)) throw new HistoricoInvalidoException("Usuario invalido.");
        this.usuarioDemandado = usuarioSolicitante;
    }
    
}
