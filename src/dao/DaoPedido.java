 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Pedido;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author hiarl
 */
public class DaoPedido implements IDaoPedido{
    
    static DaoPedido daoServico = null;
    private Set<Pedido> pedidos;

    public static DaoPedido getInstance() {
        if(daoServico == null){
            daoServico = new DaoPedido();
        }
        return daoServico;
    }

    public DaoPedido() {
        pedidos = new HashSet<>();
    }
    
    
    
    @Override
    public void adicionarPedido(Pedido demanda) {
        pedidos.add(demanda);
    }

    @Override
    public void removerPedido(Pedido demanda) {
        Iterator<Pedido> it = pedidos.iterator();
		while(it.hasNext()) {
			Pedido d = it.next();
			
			//Remove o objeto armazenado se o codigo for igual
			if(d.getIdServico() == demanda.getIdServico()) {
				it.remove();
				return;
			}
		}
    }

    @Override
    public void atualizarPedido(Pedido demanda) {
        Iterator<Pedido> it = pedidos.iterator();
		while(it.hasNext()) {
			Pedido d = it.next();
			
			//Atualiza objeto armazenado se o codigo for igual
			if(d.getIdServico() == demanda.getIdServico()) {
				d = demanda;
				return;
                    }    
                }
    }

    @Override
    public Pedido pegarPedido(long id) {
        Iterator<Pedido> it = pedidos.iterator();
		while(it.hasNext()) {
			Pedido d = it.next();
			
			if(d.getIdServico() == (id)) {
				return d;
			}
		}
		
		return null;
    }
    
    @Override
    public ArrayList<Pedido> listarPedidosUsuario(long usuario) {
        ArrayList<Pedido> resultList = new ArrayList<>();
		
		Iterator<Pedido> it = pedidos.iterator();
		while(it.hasNext()) {
                        Pedido d = it.next();
                        if(d.getIdUsuarioSolicitante()== (usuario))
                            resultList.add(d);
		}
        
		
		return resultList;
    }

    @Override
    public ArrayList<Pedido> listarPedidos() {
        ArrayList<Pedido> resultList = new ArrayList<>();
		
		Iterator<Pedido> it = pedidos.iterator();
		while(it.hasNext()) {
			resultList.add(it.next());
		}
		
		return resultList;
    }

    
}
