/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.fastfood;

import domain.Notificacao;

/**
 *
 * @author hiarl
 */
public class NotificaEmail extends Notificacao {

    public NotificaEmail(String mensagem) {
        super(mensagem);
    }

    @Override
    public void enviar() {
        System.out.println("-----------------------------------------------");
        System.out.println("Enviando notificacao por email...");
        System.out.println(getMensagem());
    }
}
