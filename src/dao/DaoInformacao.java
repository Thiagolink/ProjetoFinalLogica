/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public class DaoInformacao implements IDaoInformacao{

    static DaoDemanda daoInformacao = null;

    public static DaoDemanda getInstance() {
        if(daoInformacao == null){
            daoInformacao = new DaoDemanda();
        }
        return daoInformacao;
    }
    
    @Override
    public ArrayList<Object> listarGenericInformacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String maisRequisitado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
