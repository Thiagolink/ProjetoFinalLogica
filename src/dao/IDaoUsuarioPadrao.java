/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.UsuarioPadrao;
import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public interface IDaoUsuarioPadrao {
    
    public void adicionarUsuario(UsuarioPadrao usuario);
    public void removerUsuario(UsuarioPadrao usuario);
    public void atualizarUsuario(UsuarioPadrao usuario);
    public UsuarioPadrao pegarUsuario(long id);
    public ArrayList<UsuarioPadrao> listarUsuarios();

    public UsuarioPadrao pegarUsuario(String login);

         
}
