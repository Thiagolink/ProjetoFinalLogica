/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Demanda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author hiarl
 */
public class DaoDemanda implements IDaoDemanda {

    static   /*@ spec_public nullable @*/ DaoDemanda daoDemanda = null;
    private /*@  spec_public nullable @*/Set<Demanda> demandas; //@ in listdemandas;

    /*@ private represents listdemandas <- demandas.toArray();
      @*/
    
    /*@ assignable daoDemanda;
	  @ ensures \result != null && daoDemanda != null;
	  @*/
    public static DaoDemanda getInstance() {
        if (daoDemanda == null) {
            daoDemanda = new DaoDemanda();
        }
        return daoDemanda;
    }
    /*@ assignable demandas;
	  @ ensures demandas != null;
	  @*/
    public DaoDemanda() {
        demandas = new HashSet<>();
    }

    public void adicionarDemanda(Demanda demanda) {
        demandas.add(demanda);
    }

    public void removerDemanda(Demanda demanda) {
        Iterator<Demanda> it = demandas.iterator();
        while (it.hasNext()) {
            Demanda p = it.next();

            //Remove o objeto armazenado se o codigo for igual
            if (p.getIdDemanda() == demanda.getIdDemanda()) {
                it.remove();
                return;
            }
        }
    }

    public void atualizarDemanda(Demanda demanda) {
        Iterator<Demanda> it = demandas.iterator();
        while (it.hasNext()) {
            Demanda p = it.next();

            //Atualiza objeto armazenado se o codigo for igual
            if (p.getIdDemanda() == demanda.getIdDemanda()) {
                p = demanda;
                return;
            }
        }
    }

    public /*@ pure nullable @*/ Demanda pegarDemanda(long id) {
        Iterator<Demanda> it = demandas.iterator();
        while (it.hasNext()) {
            Demanda p = it.next();

            if (p.getIdDemanda() == (id)) {
                return p;
            }
        }

        return null;
    }

    public /*@ pure @*/ArrayList<Demanda> listarDemandas() {
        ArrayList<Demanda> resultList = new ArrayList<>();

        Iterator<Demanda> it = demandas.iterator();
        while (it.hasNext()) {
            resultList.add(it.next());
        }

        return resultList;
    }

}
