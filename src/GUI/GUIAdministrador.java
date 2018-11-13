/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Thiago
 */
public interface GUIAdministrador extends GUIUsuario{
    public void cadastrarUsuario();
    public void cadastrarProdutos();
    public void removerUsuario();
    public void removerProdutos();
    public void listarUsuarios();
    public void listarPedidos();
}
