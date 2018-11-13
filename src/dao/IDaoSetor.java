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
public interface IDaoSetor {
    public void adicionarSetor(Setor setor);
    public void removerSetor(Setor setor);
    public void atualizarSetor(Setor setor);
    public Setor pegarSetor(long id);
    public ArrayList<Setor> listarSetores();
}
