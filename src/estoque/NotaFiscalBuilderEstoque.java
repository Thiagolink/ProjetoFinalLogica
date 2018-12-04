/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import domain.Demanda;
import domain.NotaFiscal;
import domain.NotaFiscalBuilder;
import java.util.Date;
import java.util.List;


public class NotaFiscalBuilderEstoque implements NotaFiscalBuilder {

    private /*@ nullable @*/ String nomeEmpresa; 		//@ in InomeEmpresa;
    private /*@ nullable @*/ String nomeCliente; 		//@ in InomeCliente;
    private long codigo;				//@ in Icodigo;
    private /*@ nullable @*/ Date dataFaturamento;		//@ in IdataFaturamento;
    private double valorTotal;			//@ in Ivalor;
    private /*@ nullable @*/ List<Demanda> demandas;		//@ in Idemandas;
    
  /*@   private represents InomeEmpresa <- nomeEmpresa;
    @	private represents InomeCliente <- nomeCliente;
    @	private represents Icodigo <- codigo;
    @	private represents IdataFaturamento <- dataFaturamento;
    @	private represents Ivalor <- valorTotal;
    @	private represents Idemandas <- demandas;
    @*/

    @Override
    public void buildCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public void buildEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    @Override
    public void buildCodigoPedido(long codigo) {
        this.codigo = codigo;
    }

    @Override
    public void buildDataFaturamento(Date dataFaturamento) {
        this.dataFaturamento = dataFaturamento;
    }

    @Override
    public void buildDemandas(List<Demanda> demandas) {
        this.demandas = demandas;
    }

    @Override
    public void buildValorTotal(double valor) {
        this.valorTotal = valor;
    }

    @Override
    public NotaFiscal getComprovante() {
        return new NotaFiscalEstoque(nomeEmpresa, nomeCliente, codigo, dataFaturamento, valorTotal, demandas);
    }

}
