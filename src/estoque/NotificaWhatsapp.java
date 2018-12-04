/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import domain.Notificacao;


public class NotificaWhatsapp extends Notificacao{
    
	
	/*@
    @	requires mensagem != "";
    @	assignable this.mensagem;
    @	ensures this.mensagem == mensagem; 
    @*/
    public NotificaWhatsapp(String mensagem) {
            super(mensagem);
    }

    public /*@ pure @*/ void enviar() {
            System.out.println("Enviando notificacao por Whatsapp...");
            System.out.println(getMensagem());
    }
}
