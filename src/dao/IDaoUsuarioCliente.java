/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.UsuarioCliente;
import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public interface IDaoUsuarioCliente {

  //@ public model instance Object[] users;
	
  /*@ public invariant (\forall int i; i >= 0 && i < users.length - 1; users[i] != null);
    @*/
	 
  /*@ requires usuario != null;
	@ requires false == (\exists int i; 0 <= i && i < users.length; users[i].equals(usuario));
	@ assignable users;
	@ ensures (\exists int i; 0 <= i && i < users.length; users[i].equals(usuario));
	@ ensures_redundantly (\forall int i; i >= 0 && i < \old(users.length) - 1; 
	@   (\exists int j; j >= 0 && j < users.length - 1; \old(users[i]).equals(users[j])));
	@*/
    public void adicionarCliente(UsuarioCliente usuario);
    
  /*@ requires usuario != null;
    @ assignable users;
    @ ensures (\forall int i; i >=0 && i < users.length; ((UsuarioCliente)users[i]).getId() != usuario.getId());
    @ ensures_redundantly (\forall int i; i >= 0 && i < \old(users.length) - 1; 
	@  ((UsuarioCliente)\old(users[i])).getId() != usuario.getId() ==>  (\exists int j; j >= 0 && j < users.length - 1; \old(users[i]).equals(users[j])));
    @*/
    public void removerCliente(UsuarioCliente usuario);
    
    public void atualizarCliente(UsuarioCliente usuario);
    
  /*@ requires id >= 0;
    @ ensures \result == null || \result.getId() == id;
    @*/
    public  /*@ pure nullable @*/ UsuarioCliente pegarCliente(long id);    
    
  /*@ requires login != null && login.length() > 0;
    @ ensures \result == null || \result.getLogin().equals(login);
    @*/
    public  /*@ pure nullable @*/ UsuarioCliente pegarCliente(String login);
    
  /*@ ensures \result.size() == users.length;
    @ ensures_redundantly (\forall int i; i >= 0 && i < \result.size(); 
	@   (\exists int j; j >= 0 && j < users.length; (\result.get(i).equals(users[j]))));
    @*/
    public ArrayList<UsuarioCliente> listarCliente();


}
