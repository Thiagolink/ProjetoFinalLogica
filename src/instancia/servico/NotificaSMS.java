/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.servico;

import domain.Notificacao;

/**
 *
 * @author hiarl
 */
public class NotificaSMS extends Notificacao {

    public NotificaSMS(String mensagem) {
        super(mensagem);
    }

    @Override
    public void enviar() {
        System.out.println("----------------------------------"+"\n");
        System.out.println("Enviando notificacao por SMS...");
        System.out.println(getMensagem());
    }
}
