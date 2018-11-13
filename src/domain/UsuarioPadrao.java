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
    
    private boolean administrador;

    public UsuarioPadrao(boolean administrador, String nome, String endereco, String telefone, String login, String senha) {
        super(nome, endereco, telefone, login, senha);
        this.administrador = administrador;
    }
    
    public  boolean validar() throws UsuarioInvalidoException{
        return true;
    }

    /**
     * @return the administrador
     */
    public boolean isAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
    
    
}
