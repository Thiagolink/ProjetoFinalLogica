/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.estoque;

import domain.Demanda;
import domain.Pagamento;
import excecao.PagamentoInvalidoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Thiago
 */
public class BoletoBancario extends Pagamento{
    private Date vencimentoBoleto;
    private int linhaDigitavel;
    private int codigoBanco;
    Random rand = new Random();
    Date date;
    
    public BoletoBancario() {
    }

    public BoletoBancario(Date vencimentoBoleto, long idDemanda, String nome) {
        super(idDemanda, nome);
        date = vencimentoBoleto;
        date.setMonth(vencimentoBoleto.getMonth() + 1);
        this.vencimentoBoleto = date;
        this.linhaDigitavel = rand.nextInt() % 1000;
        this.codigoBanco = rand.nextInt() % 50;
    }  

    /**
     * @return the vencimentoBoleto
     */
    public Date getVencimentoBoleto() {
        return vencimentoBoleto;
    }

    /**
     * @param vencimentoBoleto the vencimentoBoleto to set
     */
    public void setVencimentoBoleto(Date vencimentoBoleto) throws PagamentoInvalidoException {
        if(!(vencimentoBoleto instanceof Date)) throw new PagamentoInvalidoException("Invalido!");

        this.vencimentoBoleto = vencimentoBoleto;
    }

    /**
     * @return the linhaDigitavel
     */
    public int getLinhaDigitavel() {
        return linhaDigitavel;
    }

    /**
     * @param linhaDigitavel the linhaDigitavel to set
     */
    public void setLinhaDigitavel(int linhaDigitavel) throws PagamentoInvalidoException {
        if(linhaDigitavel<0) throw new PagamentoInvalidoException("Invalido!");
        
        this.linhaDigitavel = linhaDigitavel;
    }

    /**
     * @return the codigoBanco
     */
    public int getCodigoBanco() {
        return codigoBanco;
    }

    /**
     * @param codigoBanco the codigoBanco to set
     */
    public void setCodigoBanco(int codigoBanco) throws PagamentoInvalidoException {
        if(codigoBanco < 0) throw new PagamentoInvalidoException("Invalido!");
        
        this.codigoBanco = codigoBanco;
    }

    @Override
    public boolean validar() {
        System.out.println("Seu boleto bancário foi gerado com sucesso.");
        return true;
    }

    @Override
    public void calcularPagamento(ArrayList<Demanda> listaProdutos) {
        for (Demanda produto : listaProdutos) {

                Item item = (Item) produto;
                setValor(getValor()+ item.getPreco());
               
        }    }
    
    
}
