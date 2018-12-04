/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import domain.Demanda;
import excecao.DemandaInvalidoException;
import java.util.Date;


public class Item extends Demanda{
    
    private /*@ spec_public @*/ int quantidadeEmEstoque;
    private /*@ spec_public @*/ boolean disponivel;

    public Item() {
    }
    
    
    /*@
    @	requires 0 <= quantidadeEmEstoque;
    @	requires nome != "";
    @	requires 0 <= preco;
    @	requires descricao != "";
    @   requires date != null;
    @	assignable this.nome;
    @	assignable this.preco;
    @	assignable this.descricao;
    @	assignable this.prazo;
    @ 	ensures this.idDemanda == count.longValue() - 1;
    @	ensures this.nome == nome;
    @   ensures this.preco == preco;
    @   ensures this.descricao == descricao;
    @   ensures this.prazo == date;
    @	ensures this.quantidadeEmEstoque == quantidadeEmEstoque;
    @*/
    public Item(int quantidadeEmEstoque, String nome, double preco, String descricao, Date date) {
        super( nome, preco, descricao, date);
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        if(quantidadeEmEstoque > 0){
        	this.disponivel = true;
        }
    }

    /**
     * @return the quantidadeEmEstoque
     */
    public /*@ pure @*/ int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    /*@		public normal_behavior
    @			requires 0 <= quantidadeEmEstoque;
    @			assignable this.quantidadeEmEstoque;
    @ 			ensures this.quantidadeEmEstoque == quantidadeEmEstoque;
    @	also
    @		public normal_behavior
    @			requires 0 == quantidadeEmEstoque;
    @			assignable this.quantidadeEmEstoque;
    @			assignable this.disponivel;
    @			ensures this.quantidadeEmEstoque == quantidadeEmEstoque;
    @			ensures disponivel == false;
    @	also
    @		public exceptional_behavior
    @		requires quantidadeEmEstoque < 0;
    @		assignable this.quantidadeEmEstoque;
    @		signals_only DemandaInvalidoException;
    @		signals (DemandaInvalidoException e)
    @				quantidadeEmEstoque < 0;
    @*/
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) throws DemandaInvalidoException {
        if(quantidadeEmEstoque < 0) throw new DemandaInvalidoException("Quantidade invalida.");
        else if(quantidadeEmEstoque == 0){
            setDisponivel(false);
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    
    
    /*@		
    @ 	also
    @		public normal_behavior
    @ 			ensures this.disponivel == true;
    @	also
    @		public exceptional_behavior
    @			requires this.disponivel == false;
    @			signals_only UnsupportedOperationException;
    @			signals (UnsupportedOperationException e)
    @					this.disponivel == false;
    @*/
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
    public /*@ pure @*/ boolean isDisponivel() {
        return disponivel;
    }

    /*@
    @			assignable this.disponivel;
    @ 			ensures this.disponivel == disponivel;
    @*/
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    
    
}
