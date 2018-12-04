/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import excecao.UsuarioInvalidoException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author hiarl
 */
public abstract class Usuario {

    private /*@ spec_public @*/ long id;
    private /*@ spec_public @*/ String nome;
    private /*@ spec_public @*/ String endereco;
    private /*@ spec_public @*/ String telefone;
    private /*@ spec_public @*/ String login;
    private /*@ spec_public @*/ String senha;
    private static /*@ spec_public @*/ AtomicInteger count = new AtomicInteger(0); 
    
    
    /*@
    @	
    @	requires nome != "";
    @	requires endereco != "";
    @	requires telefone != "";
    @   requires login != "";
    @	requires senha != "";
    @ 	ensures this.id == count.longValue() - 1;
    @	ensures this.nome == nome;
    @   ensures this.endereco == endereco;
    @   ensures this.telefone == telefone;
    @   ensures this.login == login;
    @	ensures this.senha == senha;
    @*/
    public Usuario(String nome, String endereco, String telefone, String login, String senha) {
        this.id = count.getAndIncrement();
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }

    /**
     * @return the id
     */
    public /*@ pure @*/ long getId() {
        return id;
    }

    /*@		public normal_behavior
    @			requires 0 <= id;
    @			assignable this.id;
    @ 			ensures this.id == id;
    @	also
    @		public exceptional_behavior
    @		requires id < 0;
    @		assignable this.id;
    @		signals_only UsuarioInvalidoException;
    @		signals (UsuarioInvalidoException e)
    @				id < 0;
    @*/
    public void setId(long id) throws UsuarioInvalidoException {
        if(id < 0) throw new UsuarioInvalidoException("id inválido");        
        this.id = id;
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
    @		signals_only UsuarioInvalidoException;
    @		signals (UsuarioInvalidoException e)
    @				!(nome instanceof String);
    @*/
    public void setNome(String nome) throws UsuarioInvalidoException {
        if(!(nome instanceof String)) throw new UsuarioInvalidoException("Nome inválido");
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public /*@ pure @*/ String getEndereco() {
        return endereco;
    }

    /*@		public normal_behavior
    @			requires endereco != "";
    @			assignable this.endereco;
    @ 			ensures this.endereco == endereco;
    @	also
    @		public exceptional_behavior
    @		requires !(endereco instanceof String);
    @		assignable this.endereco;
    @		signals_only UsuarioInvalidoException;
    @		signals (UsuarioInvalidoException e)
    @				!(endereco instanceof String);
    @*/
    public void setEndereco(String endereco) throws UsuarioInvalidoException {
        if(!(endereco instanceof String)) throw new UsuarioInvalidoException("Endereço inválido");
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public /*@ pure @*/ String getTelefone() {
        return telefone;
    }

    /*@		public normal_behavior
    @			requires telefone != "";
    @			assignable this.telefone;
    @ 			ensures this.nome == telefone;
    @	also
    @		public exceptional_behavior
    @		requires !(telefone instanceof String);
    @		assignable this.telefone;
    @		signals_only UsuarioInvalidoException;
    @		signals (UsuarioInvalidoException e)
    @				!(telefone instanceof String);
    @*/
    public void setTelefone(String telefone) throws UsuarioInvalidoException {
        if(!(telefone instanceof String)) throw new UsuarioInvalidoException("Telefone inválido");        
        this.telefone = telefone;
    }

    /**
     * @return the login
     */
    public /*@ pure @*/ String getLogin() {
        return login;
    }

    /*@		public normal_behavior
    @			requires login != "";
    @			assignable this.login;
    @ 			ensures this.login == login;
    @	also
    @		public exceptional_behavior
    @		requires !(login instanceof String);
    @		assignable this.login;
    @		signals_only UsuarioInvalidoException;
    @		signals (UsuarioInvalidoException e)
    @				!(login instanceof String);
    @*/
    public void setLogin(String login) throws UsuarioInvalidoException {
        if(!(login instanceof String)) throw new UsuarioInvalidoException("Login inválido");
        this.login = login;
    }

    /**
     * @return the senha
     */
    public /*@ pure @*/ String getSenha() {
        return senha;
    }

    /*@		public normal_behavior
    @			requires senha != "";
    @			assignable this.senha;
    @ 			ensures this.senha == senha;
    @	also
    @		public exceptional_behavior
    @		requires !(senha instanceof String);
    @		assignable this.senha;
    @		signals_only UsuarioInvalidoException;
    @		signals (UsuarioInvalidoException e)
    @				!(senha instanceof String);
    @*/
    public void setSenha(String senha) throws UsuarioInvalidoException {
        if(!(senha instanceof String)) throw new UsuarioInvalidoException("Senha inválido");
        this.senha = senha;
    }
    
    

}
