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

    private long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String login;
    private String senha;
    private static AtomicInteger count = new AtomicInteger(0); 

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
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) throws UsuarioInvalidoException {
        if(id < 0) throw new UsuarioInvalidoException("id inválido");        
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
    public void setNome(String nome) throws UsuarioInvalidoException {
        if(!(nome instanceof String)) throw new UsuarioInvalidoException("Nome inválido");
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) throws UsuarioInvalidoException {
        if(!(endereco instanceof String)) throw new UsuarioInvalidoException("Endereço inválido");
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) throws UsuarioInvalidoException {
        if(!(telefone instanceof String)) throw new UsuarioInvalidoException("Telefone inválido");        
        this.telefone = telefone;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) throws UsuarioInvalidoException {
        if(!(login instanceof String)) throw new UsuarioInvalidoException("Login inválido");
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) throws UsuarioInvalidoException {
        if(!(senha instanceof String)) throw new UsuarioInvalidoException("Senha inválido");
        this.senha = senha;
    }
    
    

}
