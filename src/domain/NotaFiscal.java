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

    //preencher com informações relevantes na nota fiscal
    private String empresa;
    private String nomeCliente;
    private Long codigo;
    private Date dataFaturamento;
    private double valorTotal;
    private List<Demanda> demandas;

    public NotaFiscal(String empresa, String nomeCliente, Long codigo, Date dataFaturamento, double valorTotal, List<Demanda> demandas) {
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
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the codigo
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the dataFaturamento
     */
    public Date getDataFaturamento() {
        return dataFaturamento;
    }

    /**
     * @param dataFaturamento the dataFaturamento to set
     */
    public void setDataFaturamento(Date dataFaturamento) {
        this.dataFaturamento = dataFaturamento;
    }

    /**
     * @return the demandas
     */
    public List<Demanda> getDemandas() {
        return demandas;
    }

    /**
     * @param demandas the demandas to set
     */
    public void setDemandas(List<Demanda> demandas) {
        this.demandas = demandas;
    }

    public abstract void imprimir();

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

}
