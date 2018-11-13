/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import excecao.SetorInvalidoException;

/**
 *
 * @author hiarl
 */
public class Setor {
    private long id;
    private String nome;
    private String descricao;

    public Setor() {
    }

    public Setor(long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) throws SetorInvalidoException {
        if(id < 0) throw new SetorInvalidoException("ID invalida.");
        this.id = id;
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
    public void setNome(String nome) throws SetorInvalidoException {
        if(!(nome instanceof String)) throw new SetorInvalidoException("Nome invalida.");
        this.nome = nome;
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
    public void setDescricao(String descricao) throws SetorInvalidoException {
        if(!(descricao instanceof String)) throw new SetorInvalidoException("Descrição invalida.");
        this.descricao = descricao;
    }

    public boolean validarSetor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
