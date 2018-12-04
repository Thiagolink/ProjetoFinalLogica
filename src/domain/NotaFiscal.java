/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Thiago
 */
public abstract class NotaFiscal {

    private /*@ spec_public @*/ String empresa;
    private /*@ spec_public @*/ String nomeCliente;
    private /*@ spec_public @*/ long codigo;
    private /*@ spec_public @*/ Date dataFaturamento;
    private /*@ spec_public @*/ double valorTotal;
    private /*@ spec_public @*/ List<Demanda> demandas;
    
    /*@
    @	
    @	requires empresa != "";
    @	requires nomeCliente != "";
    @	requires 0 <= codigo;
    @   requires dataFaturamento != null;
    @	requires 0 <= valorTotal;
    @	requires demandas != null;
    @ 	ensures this.empresa == empresa;
    @	ensures this.nomeCliente == nomeCliente;
    @   ensures this.codigo == codigo;
    @   ensures this.dataFaturamento == dataFaturamento;
    @   ensures this.valorTotal == valorTotal;
    @	ensures this.demandas == demandas;
    @*/
    
    public NotaFiscal(String empresa, String nomeCliente, long codigo, Date dataFaturamento, double valorTotal, List<Demanda> demandas) {
        this.empresa = empresa;
        this.nomeCliente = nomeCliente;
        this.codigo = codigo;
        this.dataFaturamento = dataFaturamento;
        this.valorTotal = valorTotal;
        this.demandas = demandas;
    }

    

    /**
     * @return the empresa
     */
    public /*@ pure @*/ String getEmpresa() {
        return empresa;
    }

    /*@
    @	requires empresa != "";
    @	assignable this.empresa;
    @ 	ensures this.empresa == empresa;
    @*/
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the nomeCliente
     */
    public /*@ pure @*/ String getNomeCliente() {
        return nomeCliente;
    }

    /*@
    @	requires nomeCliente != "";
    @	assignable this.nomeCliente;
    @ 	ensures this.nomeCliente == nomeCliente;
    @*/
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the codigo
     */
    public /*@ pure @*/ long getCodigo() {
        return codigo;
    }

    /*@
    @	requires 0 <= codigo;
    @	assignable this.codigo;
    @ 	ensures this.codigo == codigo;
    @*/
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the dataFaturamento
     */
    public /*@ pure @*/ Date getDataFaturamento() {
        return dataFaturamento;
    }

    /*@
    @	requires dataFaturamento != null;
    @	assignable this.dataFaturamento;
    @ 	ensures this.dataFaturamento == dataFaturamento;
    @*/
    public void setDataFaturamento(Date dataFaturamento) {
        this.dataFaturamento = dataFaturamento;
    }

    /**
     * @return the demandas
     */
    public /*@ pure @*/ List<Demanda> getDemandas() {
        return demandas;
    }

    /*@
    @	requires demandas != null;
    @	assignable this.demandas;
    @ 	ensures this.demandas == demandas;
    @*/
    public void setDemandas(List<Demanda> demandas) {
        this.demandas = demandas;
    }

    public /*@ pure @*/ abstract void imprimir();

    /**
     * @return the valorTotal
     */
    public /*@ pure @*/ double getValorTotal() {
        return valorTotal;
    }

    /*@
    @	requires 0 <= valorTotal;
    @	assignable this.valorTotal;
    @ 	ensures this.valorTotal == valorTotal;
    @*/
    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

}
