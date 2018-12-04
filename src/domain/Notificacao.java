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
    private /*@ spec_public @*/ String mensagem;
    
    
    public Notificacao() {
    }

    /*@
     @	requires mensagem != "";
     @	ensures this.mensagem == mensagem; 
     @*/
    public Notificacao(String mensagem) {
        this.mensagem = mensagem;
    }
    
    

    /**
     * @return the mensagem
     */
    public /*@ pure @*/ String getMensagem() {
        return mensagem;
    }

    /*@
    @	requires mensagem != "";
    @	assignable this.mensagem;
    @ 	ensures this.mensagem == mensagem;
    @*/
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public /*@ pure @*/ abstract void enviar();
}
