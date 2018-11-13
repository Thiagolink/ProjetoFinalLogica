/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.servico;

import domain.Demanda;
import excecao.DemandaInvalidoException;
import java.util.Date;

/**
 * Será usado para fazer um builder.
 * @author Thiago
 */
public class Servico extends Demanda{
    
    private String empresaFornecedora;

    public Servico() {
    }

    public Servico(String empresaFornecedora, String nome, double preco, String descricao, Date date) {
        super(nome, preco, descricao, date);
        this.empresaFornecedora = empresaFornecedora;
    }

    /**
     * @return the empresaFornecedora
     */
    public String getEmpresaFornecedora() {
        return empresaFornecedora;
    }

    /**
     * @param empresaFornecedora the empresaFornecedora to set
     */
    public void setEmpresaFornecedora(String empresaFornecedora) throws DemandaInvalidoException {
        if(!(empresaFornecedora instanceof String)) throw new DemandaInvalidoException("Invalido!");
        this.empresaFornecedora = empresaFornecedora;
    }

    @Override
    public boolean validar() {
        if("America".equals(this.empresaFornecedora))
            return true;
        else if("Coca-Cola".equals(this.empresaFornecedora))
            return true;
        else if("MicroInformatica LTDA".equals(this.empresaFornecedora))
            return true;
        else
            return false;
    }
    
    
}
