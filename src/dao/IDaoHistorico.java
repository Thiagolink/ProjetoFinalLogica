/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Historico;
import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public interface IDaoHistorico {
	
  //@ public model instance Object[] listhistoricos;
	
  /*@ public invariant (\forall int i; i >= 0 && i < listhistoricos.length - 1; listhistoricos[i] != null);
	@*/
  
	/*@ requires historico != null;
	  @ requires false == (\exists int i; 0 <= i && i < listhistoricos.length; listhistoricos[i].equals(historico));
	  @ assignable listhistoricos;
	  @ ensures (\exists int i; 0 <= i && i < listhistoricos.length; listhistoricos[i].equals(historico));
	  @*/
	public void adicionarHistorico(Historico historico);
	
  /*@ requires historico != null;
    @ assignable listhistoricos;
    @ ensures (\forall int i; i >=0 && i < listhistoricos.length; ((Historico)listhistoricos[i]).getIdHistorico() != historico.getIdDemanda());
    @*/
    public void removerHistorico(Historico historico);
    
  /*@ ensures (\forall int i; i >= 0 && i < \result.size(); ((Historico)\result.get(i)).getIdDemanda() == idDemanda);
    @*/
    public /*@ pure @*/ ArrayList<Historico> pegarHistorico(long idDemanda);
}
