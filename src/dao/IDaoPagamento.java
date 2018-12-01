/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Pagamento;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public interface IDaoPagamento {
	
	//@ public model instance Object[] listpagamentos;
	
	/*@ public invariant (\forall int i; i >= 0 && i < listpagamentos.length - 1; listpagamentos[i] != null);
	@*/
			
  /*@ requires pagamento != null;
	@ requires false == (\exists int i; 0 <= i && i < listpagamentos.length; listpagamentos[i].equals(pagamento));
	@ assignable listpagamentos;
	@ ensures (\exists int i; 0 <= i && i < listpagamentos.length; listpagamentos[i].equals(pagamento));
	@ ensures_redundantly (\forall int i; i >= 0 && i < \old(listpagamentos.length) - 1; 
	@   (\exists int j; j >= 0 && j < listpagamentos.length - 1; \old(listpagamentos[i]).equals(listpagamentos[j])));
	@*/	
	public void adicionarPagamento(Pagamento pagamento);
	
  /*@ requires pagamento != null;
    @ assignable listpagamentos;
    @ ensures (\forall int i; i >=0 && i < listpagamentos.length; ((Pagamento)listpagamentos[i]).getIdDemanda() != pagamento.getIdDemanda());
    @ ensures_redundantly (\forall int i; i >= 0 && i < \old(listpagamentos.length) - 1; 
	@  ((Pagamento)\old(listpagamentos[i])).getIdDemanda() != pagamento.getIdDemanda() ==> (\exists int j; j >= 0 && j < listpagamentos.length - 1; \old(listpagamentos[i]).equals(listpagamentos[j])));
    @*/
    public void removerPagamento(Pagamento pagamento);
    public void atualizarPagamento(Pagamento pagamento);
    
  /*@ requires id >= 0;
    @ ensures \result == null || \result.getIdDemanda() == id;
    @*/
    public /*@ pure nullable @*/  Pagamento pegarPagamento(long id);
    
  /*@ ensures \result.size() == listpagamentos.length;
    @ ensures_redundantly (\forall int i; i >= 0 && i < \result.size(); 
	@   (\exists int j; j >= 0 && j < listpagamentos.length; (\result.get(i).equals(listpagamentos[j]))));
    @*/
    public /*@ pure @*/ ArrayList<Pagamento> listarPagamento();
}
