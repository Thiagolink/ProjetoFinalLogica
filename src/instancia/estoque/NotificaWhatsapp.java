/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.estoque;

import domain.Notificacao;

/**
 *
 * @author hiarl
 */
public class NotificaWhatsapp extends Notificacao{
    
    public NotificaWhatsapp(String mensagem) {
            super(mensagem);
    }

    public void enviar() {
            System.out.println("Enviando notificacao por Whatsapp...");
            System.out.println(getMensagem());
    }
}
