/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author hiarl
 */
public interface GUILogin {
    //@ public nullable model instance String senhasistema;
	//@ public nullable model instance String loginsistema;
	
	/*@ requires login != null && login.length() > 0;
	  @ requires senha != null && senha.length() > 0;
	  @ ensures \result <==> (login.equals(loginsistema) && senha.equals(senhasistema));
	  @*/
	public boolean autenticar(String login, String senha);
    public void logar();
    
}
