/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author hiarl
 */
public abstract class Notificacao {
    private String mensagem;
    
    
    public Notificacao() {
    }

    public Notificacao(String mensagem) {
        this.mensagem = mensagem;
    }
    
    

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public abstract void enviar();
}
