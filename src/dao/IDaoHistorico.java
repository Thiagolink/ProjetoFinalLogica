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
    public void adicionarHistorico(Historico historico);
    public void removerHistorico(Historico historico);
    public ArrayList<Historico> pegarHistorico(long idDemanda);
}
