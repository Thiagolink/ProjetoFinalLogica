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

/**
 *
 * @author hiarl
 */
public class GerenciadorClientes {

    private IDaoUsuarioCliente daoCliente;

    public GerenciadorClientes() {
        daoCliente = DaoUsuarioCliente.getInstance();
    }

    public void cadastrarCliente(UsuarioCliente cliente) throws ClienteInvalidoException {
        if (cliente.validar()) {
            this.daoCliente.adicionarCliente(cliente);
        }
    }

    public void removerCliente(UsuarioCliente cliente) {
        this.daoCliente.removerCliente(cliente);
    }

    public void atualizarCliente(UsuarioCliente cliente) {
        this.daoCliente.atualizarCliente(cliente);
    }

    public ArrayList<UsuarioCliente> listarClientes() {
        return this.daoCliente.listarCliente();
    }

    public UsuarioCliente getCliente(Long codigo) {
        return this.daoCliente.pegarCliente(codigo);
    }

    public UsuarioCliente getCliente(String login) {
        return this.daoCliente.pegarCliente(login);
    }

    private boolean validarCliente(UsuarioCliente usuario) throws ClienteInvalidoException {
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
