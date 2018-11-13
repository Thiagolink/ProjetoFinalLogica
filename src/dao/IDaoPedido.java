/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Pedido;
import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public interface IDaoPedido {
    public void adicionarPedido(Pedido demanda);
    public void removerPedido(Pedido demanda);
    public void atualizarPedido(Pedido demanda);
    public Pedido pegarPedido(long id);
    public ArrayList<Pedido> listarPedidosUsuario(long usuario);
    public ArrayList<Pedido> listarPedidos();
}
