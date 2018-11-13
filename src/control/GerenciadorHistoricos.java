/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DaoHistorico;
import dao.IDaoHistorico;
import domain.Historico;
import excecao.HistoricoInvalidoException;
import java.util.ArrayList;

/**
 *
 * @author hiarl
 */
public class GerenciadorHistoricos {
    private IDaoHistorico daoHistorico;

    public GerenciadorHistoricos() {
        daoHistorico = DaoHistorico.getInstance();
    }

    public void adicionarHistorico(Historico historico) throws HistoricoInvalidoException{
        if(validarHistorico(historico)) {
            this.daoHistorico.adicionarHistorico(historico);
        }
    }

    public void removerHistorico(Historico historico) {
        this.daoHistorico.removerHistorico(historico);
    }

    public ArrayList<Historico> listarHistorico(long idDemanda){
        return this.daoHistorico.pegarHistorico(idDemanda);
    }

        private boolean validarHistorico(Historico historico) throws HistoricoInvalidoException {
        if(historico.getDescricao().equals("")){
            throw new HistoricoInvalidoException("Descrição vazio.");
        }else if(historico.getUsuarioSolicitante().equals("")){
            throw new HistoricoInvalidoException("Login vazio.");
            
        }
        return true;
    }

}
