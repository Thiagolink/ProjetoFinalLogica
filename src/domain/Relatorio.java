/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public class Relatorio {
    private ArrayList<Setor> listaSetor;
    private ArrayList<Usuario> listaUsuario;
    private ArrayList<UsuarioCliente> listaCliente;
    private ArrayList<Pedido> listaDatas;

    public Relatorio() {
    }

    public Relatorio(ArrayList<Setor> listaSetor, ArrayList<Usuario> listaUsuario, ArrayList<UsuarioCliente> listaCliente, ArrayList<Pedido> listaDatas) {
        this.listaSetor = listaSetor;
        this.listaUsuario = listaUsuario;
        this.listaCliente = listaCliente;
        this.listaDatas = listaDatas;
    }
    
    /**
     * @return the listaSetor
     */
    public ArrayList<Setor> getListaSetor() {
        return listaSetor;
    }

    /**
     * @param listaSetor the listaSetor to set
     */
    public void setListaSetor(ArrayList<Setor> listaSetor) {
        this.listaSetor = listaSetor;
    }

    /**
     * @return the listaUsuario
     */
    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    /**
     * @param listaUsuario the listaUsuario to set
     */
    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    /**
     * @return the listaCliente
     */
    public ArrayList<UsuarioCliente> getListaCliente() {
        return listaCliente;
    }

    /**
     * @param listaCliente the listaCliente to set
     */
    public void setListaCliente(ArrayList<UsuarioCliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    /**
     * @return the listaDatas
     */
    public ArrayList<Pedido> getListaDatas() {
        return listaDatas;
    }

    /**
     * @param listaDatas the listaDatas to set
     */
    public void setListaDatas(ArrayList<Pedido> listaDatas) {
        this.listaDatas = listaDatas;
    }
    
    
    
}
