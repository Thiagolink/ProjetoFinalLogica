/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.fastfood;

import domain.Demanda;
import excecao.DemandaInvalidoException;
import java.util.Date;

/**
 * Será usado para fazer um builder.
 * @author Thiago
 */
public class Alimento extends Demanda{
    
    private String fornecedor;
    private String tipoAlimento;

    public Alimento() {
    }

    public Alimento(String fornecedor, String tipoAlimento, String nome, double preco, String descricao, Date date) {
        super(nome, preco, descricao, date);
        this.fornecedor = fornecedor;
        this.tipoAlimento = tipoAlimento;
    }

    


    /**
     * @return the fornecedor
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(String fornecedor) throws DemandaInvalidoException {
        if(!(fornecedor instanceof String)) throw new DemandaInvalidoException("Invalido!");
        this.fornecedor = fornecedor;
    }

    /**
     * @return the tipoAlimento
     */
    public String getTipoAlimento() {
        return tipoAlimento;
    }

    /**
     * @param tipoAlimento the tipoAlimento to set
     */
    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    @Override
    public boolean validar() {
        if("Comida".equals(this.tipoAlimento))
            return true;
        else if("Bebida".equals(this.tipoAlimento))
            return true;
        else if("Sobremesa".equals(this.tipoAlimento))
            return true;
        else
            return false;
    }
    
    
}
