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

    static DaoDemanda daoDemanda = null;
    private Set<Demanda> demandas;

    public static DaoDemanda getInstance() {
        if (daoDemanda == null) {
            daoDemanda = new DaoDemanda();
        }
        return daoDemanda;
    }

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

    public Demanda pegarDemanda(long id) {
        Iterator<Demanda> it = demandas.iterator();
        while (it.hasNext()) {
            Demanda p = it.next();

            if (p.getIdDemanda() == (id)) {
                return p;
            }
        }

        return null;
    }

    public ArrayList<Demanda> listarDemandas() {
        ArrayList<Demanda> resultList = new ArrayList<>();

        Iterator<Demanda> it = demandas.iterator();
        while (it.hasNext()) {
            resultList.add(it.next());
        }

        return resultList;
    }

}
