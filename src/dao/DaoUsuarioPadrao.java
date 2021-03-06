/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.UsuarioPadrao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author hiarl
 */
public class DaoUsuarioPadrao implements IDaoUsuarioPadrao {

	static  /*@ spec_public nullable @*/ DaoUsuarioPadrao daoUsuario = null;
	private /*@ spec_public nullable @*/ Set<UsuarioPadrao> listusuarios;//@ in listusers;
	
	/*@ private represents listusers <- listusuarios.toArray();
      @*/
	
	/*@ assignable daoUsuario;
	  @ ensures \result != null && daoUsuario != null;
	  @*/ 
	public static DaoUsuarioPadrao getInstance() {
		if (daoUsuario == null) {
			daoUsuario = new DaoUsuarioPadrao();
		}
		return daoUsuario;
	}
	
	/*@ assignable listusuarios;
	  @ ensures listusuarios != null;
	  @*/ 
	public DaoUsuarioPadrao() {
		listusuarios = new HashSet<>();		
	}

	public void adicionarUsuario(UsuarioPadrao usuario) {
		listusuarios.add(usuario);
	}

	@Override
	public void removerUsuario(UsuarioPadrao usuario) {
		Iterator<UsuarioPadrao> it = listusuarios.iterator();
		while (it.hasNext()) {
			UsuarioPadrao u = it.next();

			// Remove o objeto armazenado se o codigo for igual
			if (u.getId() == usuario.getId()) {
				it.remove();
				return;
			}
		}
	}

	@Override
	public void atualizarUsuario(UsuarioPadrao usuario) {
		Iterator<UsuarioPadrao> it = listusuarios.iterator();
		while (it.hasNext()) {
			UsuarioPadrao u = it.next();

			// Atualiza objeto armazenado se o codigo for igual
			if (u.getId() == usuario.getId()) {
				u = usuario;
				return;
			}
		}
	}

	@Override
	public /*@ pure nullable @*/ UsuarioPadrao pegarUsuario(long id) {
		Iterator<UsuarioPadrao> it = listusuarios.iterator();
		while (it.hasNext()) {
			UsuarioPadrao u = it.next();
			if (u.getId() == (id)) {
				return u;
			}
		}

		return null;
	}

	@Override
	public ArrayList<UsuarioPadrao> listarUsuarios() {
		ArrayList<UsuarioPadrao> resultList = new ArrayList<UsuarioPadrao>();

		Iterator<UsuarioPadrao> it = listusuarios.iterator();
		while (it.hasNext()) {
			resultList.add(it.next());
		}

		return resultList;
	}

	@Override
	public /*@ pure nullable @*/UsuarioPadrao pegarUsuario(String login) {
		Iterator<UsuarioPadrao> it = listusuarios.iterator();
		while (it.hasNext()) {
			UsuarioPadrao u = it.next();

			if (u.getLogin().equals(login)) {
				return u;
			}
		}

		return null;
	}

}