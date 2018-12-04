/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import excecao.ClienteInvalidoException;

/**
 *
 * @author hiarl
 */
public class UsuarioCliente extends Usuario {

    public UsuarioCliente() {
    }
    
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
    @*/
    public UsuarioCliente(String nome, String endereco, String telefone, String login, String senha) {
        super(nome, endereco, telefone, login, senha);
    }

    public /*@ pure @*/ boolean validar() throws ClienteInvalidoException {
        return true;
    }

}
