/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import GUI.GUIInicial;
import control.GerenciadorClientes;
import control.GerenciadorUsuarios;
import domain.Usuario;
import java.util.Scanner;


public class GUILoginEstoque implements GUI.GUILogin {

    private /*@ spec_public nullable @*/ Scanner in = new Scanner(System.in);

    private /*@ spec_public nullable @*/ GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
    private /*@ spec_public nullable @*/ GerenciadorClientes gerenciadorCliente = new GerenciadorClientes();
    private /*@ spec_public nullable @*/ GUIInicial guiInicialServico = new GUIInicialEstoque();
    protected /*@ spec_public nullable @*/ Usuario usuario;
   
    /*@ protected represents senhasistema <- (usuario != null ? usuario.getSenha() : "enull");
      @ protected represents loginsistema <- (usuario != null ? usuario.getLogin(): "enull");
      @*/
    
    @Override
    public boolean autenticar(String login, String senha) {
        Usuario usuarioPadrao = gerenciadorUsuarios.getUsuario(login);
        Usuario usuarioCliente = gerenciadorCliente.getCliente(login);

        if (gerenciadorUsuarios.getUsuario(login) == null && gerenciadorCliente.getCliente(login) == null) {
            System.out.println("Usuario não cadastrado");
            return false;
        } else if (gerenciadorUsuarios.getUsuario(login) != null && usuarioPadrao.getSenha().equals(senha)) {
            usuario = gerenciadorUsuarios.getUsuario(login);
            return true;
        } else if (gerenciadorCliente.getCliente(login) != null && usuarioCliente.getSenha().equals(senha)) {
            usuario = gerenciadorCliente.getCliente(login);
            return true;
        } else {
            System.out.println("Senha incorreta.");
            return false;
        }
    }

    @Override
    public void logar() {
        do {
            System.out.println("---------- Login do Sistema de Estoque----------");
            System.out.println("Usuario:");
            String login = in.next();
            System.out.println("Senha:");
            String senha = in.next();
            if (autenticar(login, senha)) {
                guiInicialServico.acessarInterface(usuario);
            }
        } while (true);
    }

}
