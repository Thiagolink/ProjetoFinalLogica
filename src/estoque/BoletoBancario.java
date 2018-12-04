/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import domain.Demanda;
import domain.Pagamento;
import excecao.PagamentoInvalidoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class BoletoBancario extends Pagamento{
    private /*@ spec_public @*/ Date vencimentoBoleto; 	
    private /*@ spec_public @*/ int linhaDigitavel;    	
    private /*@ spec_public @*/ int codigoBanco;		
    private /*@ spec_public @*/ Random rand = new Random();		
    private /*@ spec_public @*/ Date date;						
    
    
    
    public BoletoBancario() {
    }

    
    /*@
     @	requires nome != "";
     @	requires 0 <= idDemanda;
     @	requires nome != "";
     @	requires vencimentoBoleto != null;
     @	assignable this.idDemanda;
     @	assignable this.nome; 
     @*/
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
    public /*@ pure @*/ Date getVencimentoBoleto() {
        return vencimentoBoleto;
    }

    /*@		public normal_behavior
    @			requires vencimentoBoleto != null;
    @			assignable this.vencimentoBoleto;
    @ 			ensures this.vencimentoBoleto == vencimentoBoleto;
    @	also
    @		public exceptional_behavior
    @		requires !(vencimentoBoleto instanceof Date);
    @		assignable this.vencimentoBoleto;
    @		signals_only PagamentoInvalidoException;
    @		signals (PagamentoInvalidoException e)
    @				!(vencimentoBoleto instanceof Date);
    @*/
    public void setVencimentoBoleto(Date vencimentoBoleto) throws PagamentoInvalidoException {
        if(!(vencimentoBoleto instanceof Date)) throw new PagamentoInvalidoException("Invalido!");

        this.vencimentoBoleto = vencimentoBoleto;
    }

    /**
     * @return the linhaDigitavel
     */
    public /*@ pure @*/ int getLinhaDigitavel() {
        return linhaDigitavel;
    }

    /*@		public normal_behavior
    @			requires 0 <= linhaDigitavel;
    @			assignable this.linhaDigitavel;
    @ 			ensures this.linhaDigitavel == linhaDigitavel;
    @	also
    @		public exceptional_behavior
    @		requires linhaDigitavel < 0;
    @		assignable this.linhaDigitavel;
    @		signals_only PagamentoInvalidoException;
    @		signals (PagamentoInvalidoException e)
    @				linhaDigitavel < 0;
    @*/
    public void setLinhaDigitavel(int linhaDigitavel) throws PagamentoInvalidoException {
        if(linhaDigitavel<0) throw new PagamentoInvalidoException("Invalido!");
        
        this.linhaDigitavel = linhaDigitavel;
    }

    /**
     * @return the codigoBanco
     */
    public /*@ pure @*/ int getCodigoBanco() {
        return codigoBanco;
    }

    /*@		public normal_behavior
    @			requires 0 <= codigoBanco;
    @			assignable this.codigoBanco;
    @ 			ensures this.codigoBanco == codigoBanco;
    @	also
    @		public exceptional_behavior
    @		requires codigoBanco < 0;
    @		assignable this.codigoBanco;
    @		signals_only PagamentoInvalidoException;
    @		signals (PagamentoInvalidoException e)
    @				codigoBanco < 0;
    @*/
    public void setCodigoBanco(int codigoBanco) throws PagamentoInvalidoException {
        if(codigoBanco < 0) throw new PagamentoInvalidoException("Invalido!");
        
        this.codigoBanco = codigoBanco;
    }

    @Override
    public /*@ pure @*/ boolean validar() {
        System.out.println("Seu boleto bancário foi gerado com sucesso.");
        return true;
    }

    @Override
    public void calcularPagamento(ArrayList<Demanda> listaProdutos) {
        for (Demanda produto : listaProdutos) {

                Item item = (Item) produto;
                setValor(getValor()+ item.getPreco());
               
        }   
    }
    
    
}
