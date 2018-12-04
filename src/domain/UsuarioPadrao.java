/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import excecao.UsuarioInvalidoException;



/**
 *
 * @author hiarl
 */
public class UsuarioPadrao extends Usuario{
    
    private /*@ spec_public @*/ boolean administrador;

    
    /*@
    @
    @	requires nome != "";
    @	requires endereco != "";
    @	requires telefone != "";
    @   requires login != "";
    @	requires senha != "";
    @	assignable this.nome;
    @	assignable this.endereco;
    @	assignable this.telefone;
    @	assignable this.login;
    @	assignable this.senha;
    @ 	ensures this.id == count.longValue() - 1;
    @	ensures this.nome == nome;
    @   ensures this.endereco == endereco;
    @   ensures this.telefone == telefone;
    @   ensures this.login == login;
    @	ensures this.senha == senha;
    @	ensures this.administrador == administrador;
    @*/
    public UsuarioPadrao(boolean administrador, String nome, String endereco, String telefone, String login, String senha) {
        super(nome, endereco, telefone, login, senha);
        this.administrador = administrador;
    }
    
    public /*@ pure @*/ boolean validar() throws UsuarioInvalidoException{
        return true;
    }

    /**
     * @return the administrador
     */
    public /*@ pure @*/ boolean isAdministrador() {
        return administrador;
    }

    /*@
    @			assignable this.administrador;
    @ 			ensures this.administrador == administrador;
    @*/
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
    
    
}
