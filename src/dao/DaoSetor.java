/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Setor;
import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public class DaoSetor implements IDaoSetor{

    static DaoSetor daoSetor = null;

    public static DaoSetor getInstance() {
        if(daoSetor == null){
            daoSetor = new DaoSetor();
        }
        return daoSetor;
    }
        
    
    @Override
    public void adicionarSetor(Setor setor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerSetor(Setor setor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarSetor(Setor setor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Setor pegarSetor(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Setor> listarSetores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
