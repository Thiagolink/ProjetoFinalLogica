/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Thiago
 */
public interface FabricaNotificacao {
	
	
	/*@
	 @		requires pedido != null;
	 @		ensures \result !=null; 
	 @*/
    public Notificacao criarInicioNoticiarDemanda(Pedido pedido);
    
    /*@
	 @		requires historico != null;
	 @		ensures \result !=null; 
	 @*/
    public Notificacao criarNotificacaoAtualizarDemanda(Historico historico);
}
