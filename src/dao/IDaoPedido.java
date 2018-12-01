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
   
  //@ public model instance Object[] listpedidos;
	
  /*@ public invariant (\forall int i; i >= 0 && i < listpedidos.length - 1; listpedidos[i] != null);
	@*/
		
  /*@ requires demanda != null;
	@ requires false == (\exists int i; 0 <= i && i < listpedidos.length; listpedidos[i].equals(demanda));
	@ assignable listpedidos;
	@ ensures (\exists int i; 0 <= i && i < listpedidos.length; listpedidos[i].equals(demanda));
	@ ensures_redundantly (\forall int i; i >= 0 && i < \old(listpedidos.length) - 1; 
	@   (\exists int j; j >= 0 && j < listpedidos.length - 1; \old(listpedidos[i]).equals(listpedidos[j])));
	@*/	
	public void adicionarPedido(Pedido demanda);
	
  /*@ requires demanda != null;
    @ assignable listpedidos;
    @ ensures (\forall int i; i >=0 && i < listpedidos.length; ((Pedido)listpedidos[i]).getIdUsuarioSolicitante() != demanda.getIdServico());
    @ ensures_redundantly (\forall int i; i >= 0 && i < \old(listpedidos.length) - 1; 
	@  ((Pedido)\old(listpedidos[i])).getIdUsuarioSolicitante() != demanda.getIdServico() ==> (\exists int j; j >= 0 && j < listpedidos.length - 1; \old(listpedidos[i]).equals(listpedidos[j])));
    @*/
    public void removerPedido(Pedido demanda);
    public void atualizarPedido(Pedido demanda);
    
  /*@ requires id >= 0;
    @ ensures \result == null || \result.getIdServico() == id;
    @*/
    public/*@ pure nullable @*/Pedido pegarPedido(long id);
  
  /*@ ensures_redundantly (\forall int i; i >= 0 && i < \result.size(); 
	@   ((Pedido)\result.get(i)).getIdUsuarioSolicitante() == usuario);
    @*/
    public /*@ pure @*/ ArrayList<Pedido> listarPedidosUsuario(long usuario);
  
  /*@ ensures \result.size() == listpedidos.length;
    @ ensures_redundantly (\forall int i; i >= 0 && i < \result.size(); 
	@   (\exists int j; j >= 0 && j < listpedidos.length; (\result.get(i).equals(listpedidos[j]))));
    @*/
    public/*@ pure @*/ ArrayList<Pedido> listarPedidos();
}
