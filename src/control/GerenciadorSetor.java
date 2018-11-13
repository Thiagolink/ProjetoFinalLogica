/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DaoSetor;
import dao.IDaoSetor;
import domain.Setor;
import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public class GerenciadorSetor {
    private IDaoSetor daoSetor;

    public GerenciadorSetor() {
        daoSetor = DaoSetor.getInstance();
    }

    public void cadastrarSetor(Setor setor){
        if(setor.validarSetor()) {
            this.daoSetor.adicionarSetor(setor);
        }
    }

    public void removerSetor(Setor setor) {
        this.daoSetor.removerSetor(setor);
    }

    public void atualizarSetor(Setor setor){
        this.daoSetor.atualizarSetor(setor);
    }
    
    public ArrayList<Setor> listarSetores(){
        return this.daoSetor.listarSetores();
    }

    public Setor getSetor(Long id) {
        return this.daoSetor.pegarSetor(id);
    }
    
}
