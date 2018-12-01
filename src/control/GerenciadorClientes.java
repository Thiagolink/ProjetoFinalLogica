/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DaoUsuarioCliente;
import dao.IDaoUsuarioCliente;
import domain.UsuarioCliente;
import excecao.ClienteInvalidoException;
import java.util.ArrayList;


public class GerenciadorClientes {

    private /*@ spec_public nullable @*/  IDaoUsuarioCliente daoCliente;
    
    /*@ assignable daoCliente;
      @ ensures daoCliente != null;
      @*/
    public GerenciadorClientes() {
        daoCliente = DaoUsuarioCliente.getInstance();
    }
    /*@ requires cliente != null;
      @*/
    public void cadastrarCliente(UsuarioCliente cliente) throws ClienteInvalidoException {
        if (validarCliente(cliente)) {
            this.daoCliente.adicionarCliente(cliente);
        }
    }
  
  /*@ requires cliente != null;
    @*/
    public void removerCliente(UsuarioCliente cliente) {
        this.daoCliente.removerCliente(cliente);
    }

    /*@ requires cliente != null;
    @*/
    public void atualizarCliente(UsuarioCliente cliente) {
        this.daoCliente.atualizarCliente(cliente);
    }
    /*@ ensures \result != null;
      @*/
    public ArrayList<UsuarioCliente> listarClientes() {
        return this.daoCliente.listarCliente();
    }

    /*@ requires 0 <= codigo;
    @
    @*/
    public UsuarioCliente getCliente(long codigo) {
        return this.daoCliente.pegarCliente(codigo);
    }
    
    /*@ requires login != "";
    @*/
    public /*@ nullable @*/ UsuarioCliente getCliente(String login) {
        return this.daoCliente.pegarCliente(login);
    }
 
  /*@      private normal_behavior
    @              requires usuario.getNome().length()  > 0;
    @		       requires usuario.getSenha().length() > 0;
    @              requires usuario.getLogin().length() > 0;
    @	           requires daoCliente.pegarCliente(usuario.getId()) == null;
    @              ensures \result == true;
    @ also
    @      private exceptional_behavior
    @			   requires usuario.getNome().length()  == 0  || 
    @                       usuario.getSenha().length() == 0  || 
    @                       usuario.getLogin().length() == 0  ||
    @                       daoCliente.pegarCliente(usuario.getId()) != null ||
    @						daoCliente.pegarCliente(usuario.getLogin()) != null; 	
    @              signals_only ClienteInvalidoException;
    @*/
    private /*@ pure @*/boolean validarCliente(UsuarioCliente usuario) throws ClienteInvalidoException {
        if (usuario.getNome().equals("")) {
            throw new ClienteInvalidoException("Nome de usuario vazio.");
        } else if (usuario.getLogin().equals("")) {
            throw new ClienteInvalidoException("Login vazio.");

        } else if (usuario.getSenha().equals("")) {
            throw new ClienteInvalidoException("Senha vazia");

        } else if (this.daoCliente.pegarCliente(usuario.getId()) != null) {
            throw new ClienteInvalidoException("ID invalido contate o Administrador");
        }
        return true;
    }
}
