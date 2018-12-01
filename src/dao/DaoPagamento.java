/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Pagamento;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Thiago
 */
public class DaoPagamento implements IDaoPagamento{
    static /*@ spec_public nullable @*/ DaoPagamento daoPagamento = null;
    private /*@ spec_public nullable @*/ Set<Pagamento> pagamentos;//@ in listpagamentos;

  /*@ private represents listpagamentos <- pagamentos.toArray();
    @*/

  /*@ assignable daoPagamento;
	@ ensures \result != null && daoPagamento != null;
	@*/
    public static DaoPagamento getInstance() {
        if(daoPagamento == null){
            daoPagamento = new DaoPagamento();
        }
        return daoPagamento;
    }
    
  /*@ assignable pagamentos;
	@ ensures pagamentos != null;
	@*/
    public DaoPagamento() {
        pagamentos = new HashSet<>();
    }
    
    
    
    @Override
    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    @Override
    public void removerPagamento(Pagamento pagamento) {
        Iterator<Pagamento> it = pagamentos.iterator();
		while(it.hasNext()) {
			Pagamento d = it.next();
			
			//Remove o objeto armazenado se o codigo for igual
			if(d.getIdDemanda() == pagamento.getIdDemanda()) {
				it.remove();
				return;
			}
		}
    }

    @Override
    public void atualizarPagamento(Pagamento pagamento) {
        Iterator<Pagamento> it = pagamentos.iterator();
		while(it.hasNext()) {
			Pagamento p = it.next();
			
			//Atualiza objeto armazenado se o codigo for igual
			if(p.getIdDemanda()== pagamento.getIdDemanda()) {
				p = pagamento;
				return;
                    }    
                }
    }

    @Override
    public /*@ pure nullable @*/Pagamento pegarPagamento(long id) {
        Iterator<Pagamento> it = pagamentos.iterator();
		while(it.hasNext()) {
			Pagamento p = it.next();
			
			if(p.getIdDemanda()== (id)) {
				return p;
			}
		}
		
		return null;
    }

    @Override
    public /*@ pure @*/ArrayList<Pagamento> listarPagamento() {
        ArrayList<Pagamento> resultList = new ArrayList<>();
		
		Iterator<Pagamento> it = pagamentos.iterator();
		while(it.hasNext()) {
			resultList.add(it.next());
		}
		
		return resultList;
    }
}
