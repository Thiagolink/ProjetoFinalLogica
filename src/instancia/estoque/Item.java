/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.estoque;

import domain.Demanda;
import excecao.DemandaInvalidoException;
import java.util.Date;

/**
 * Será usado para fazer um builder.
 * @author Thiago
 */
public class Item extends Demanda{
    
    private int quantidadeEmEstoque;
    private boolean disponivel;

    public Item() {
    }

    public Item(int quantidadeEmEstoque, String nome, double preco, String descricao, Date date) {
        super( nome, preco, descricao, date);
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    /**
     * @return the quantidadeEmEstoque
     */
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    /**
     * @param quantidadeEmEstoque the quantidadeEmEstoque to set
     */
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) throws DemandaInvalidoException {
        if(quantidadeEmEstoque < 0) throw new DemandaInvalidoException("Quantidade invalida.");
        else if(quantidadeEmEstoque == 0){
            setDisponivel(false);
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public boolean validar() {
        if(!this.disponivel)
            throw new UnsupportedOperationException("O item acabou em estoque.");
        else
            return true;
    }

    /**
     * @return the disponivel
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * @param disponivel the disponivel to set
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    
    
}
