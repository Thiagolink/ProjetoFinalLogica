/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DaoUsuarioPadrao;
import dao.IDaoUsuarioPadrao;
import domain.UsuarioPadrao;
import excecao.UsuarioInvalidoException;
import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public class GerenciadorUsuarios {
    private /*@ spec_public nullable @*/ IDaoUsuarioPadrao daoUsuario;
    
    /*@ assignable daoUsuario; 
      @ ensures daoUsuario != null;
      @*/
    public GerenciadorUsuarios() {
        this.daoUsuario = DaoUsuarioPadrao.getInstance();
    }
    /*@ requires usuario != null;
      @*/
    public void cadastrarUsuario(UsuarioPadrao usuario) throws UsuarioInvalidoException{
        if(validarUsuario(usuario)) {
            this.daoUsuario.adicionarUsuario(usuario);
        }
    }

    public void removerUsuario(UsuarioPadrao usuario) {
        this.daoUsuario.removerUsuario(usuario);
    }

    public void atualizarUsuario(UsuarioPadrao usuario){
        this.daoUsuario.atualizarUsuario(usuario);
    }
    /*@ ensures \result != null;
      @*/
    public ArrayList<UsuarioPadrao> listarUsuarios(){
        return this.daoUsuario.listarUsuarios();
    }

    public UsuarioPadrao getUsuario(long id) {
        return this.daoUsuario.pegarUsuario(id);
    }
    
    public /*@ nullable @*/ UsuarioPadrao getUsuario(String login){
        return this.daoUsuario.pegarUsuario(login);
    }
    
  /*@      private normal_behavior
    @              requires usuario.getNome().length()  > 0;
    @		       requires usuario.getSenha().length() > 0;
    @              requires usuario.getLogin().length() > 0;
    @	           requires daoUsuario.pegarUsuario(usuario.getId()) == null;
    @              ensures \result == true;
    @ also
    @      private exceptional_behavior
    @			   requires usuario.getNome().length()  == 0  || 
    @                       usuario.getSenha().length() == 0  || 
    @                       usuario.getLogin().length() == 0  ||
    @                       daoUsuario.pegarUsuario(usuario.getId()) != null ||
    @						daoUsuario.pegarUsuario(usuario.getLogin()) != null; 	
    @              signals_only UsuarioInvalidoException;
    @*/
    private /*@ pure @*/ boolean validarUsuario(UsuarioPadrao usuario) throws UsuarioInvalidoException {
        if(usuario.getNome().equals("")){
            throw new UsuarioInvalidoException("Nome de usuario vazio.");
        }else if(usuario.getLogin().equals("")){
            throw new UsuarioInvalidoException("Login vazio.");
            
        }else if(usuario.getSenha().equals("")){
            throw new UsuarioInvalidoException("Senha vazia");
            
        }else if(this.daoUsuario.pegarUsuario(usuario.getId()) != null){
            throw new UsuarioInvalidoException("ID invalido contate o Administrador");
        }
        return true;
    }
    
}
