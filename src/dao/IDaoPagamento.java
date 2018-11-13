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
    public void adicionarPagamento(Pagamento pagamento);
    public void removerPagamento(Pagamento pagamento);
    public void atualizarPagamento(Pagamento pagamento);
    public Pagamento pegarPagamento(long id);
    public ArrayList<Pagamento> listarPagamento();
}
