/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Demanda;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public interface IDaoDemanda {
   
	//@ public model instance Object[] listdemandas;
	
	/*@ public invariant (\forall int i; i >= 0 && i < listdemandas.length - 1; listdemandas[i] != null);
	  @*/
		
	/*@ requires demanda != null;
	  @ requires false == (\exists int i; 0 <= i && i < listdemandas.length; listdemandas[i].equals(demanda));
	  @ assignable listdemandas;
	  @ ensures (\exists int i; 0 <= i && i < listdemandas.length; listdemandas[i].equals(demanda));
	  @ ensures_redundantly (\forall int i; i >= 0 && i < \old(listdemandas.length) - 1; 
	  @   (\exists int j; j >= 0 && j < listdemandas.length - 1; \old(listdemandas[i]).equals(listdemandas[j])));
	  @*/
	public void adicionarDemanda(Demanda demanda);
	
   /*@ requires demanda != null;
     @ assignable listdemandas;
     @ ensures (\forall int i; i >=0 && i < listdemandas.length; ((Demanda)listdemandas[i]).getIdDemanda() != demanda.getIdDemanda());
     @ ensures_redundantly (\forall int i; i >= 0 && i < \old(listdemandas.length) - 1;((Demanda)\old(listdemandas[i])).getIdDemanda() != demanda.getIdDemanda() ==> 
	 @   (\exists int j; j >= 0 && j < listdemandas.length - 1; \old(listdemandas[i]).equals(listdemandas[j])));
     @*/
    public void removerDemanda(Demanda demanda);
    public void atualizarDemanda(Demanda demanda);
    
    /*@ requires id >= 0;
      @ ensures \result == null || \result.getIdDemanda() == id;
      @*/
    public /*@ pure nullable @*/  Demanda pegarDemanda(long id);
    
  /*@ ensures \result.size() == listdemandas.length;
    @ ensures_redundantly (\forall int i; i >= 0 && i < \result.size(); 
	@   (\exists int j; j >= 0 && j < listdemandas.length; (\result.get(i).equals(listdemandas[j]))));
    @*/
    public /*@ pure @*/ ArrayList<Demanda> listarDemandas();

    
}
