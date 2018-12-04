/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import domain.Demanda;
import domain.NotaFiscal;
import java.util.Date;
import java.util.List;


public class NotaFiscalEstoque extends NotaFiscal{

	
	/*@
    @	
    @	requires empresa != "";
    @	requires nomeCliente != "";
    @	requires 0 <= codigo;
    @   requires dataFaturamento != null;
    @	requires 0 <= valorTotal;
    @	requires demandas != null;
    @	assignable this.empresa;
    @	assignable this.nomeCliente;
    @	assignable this.codigo;
    @	assignable this.dataFaturamento;
    @	assignable this.valorTotal;
    @	assignable this.demandas;
    @ 	ensures this.empresa == empresa;
    @	ensures this.nomeCliente == nomeCliente;
    @   ensures this.codigo == codigo;
    @   ensures this.dataFaturamento == dataFaturamento;
    @   ensures this.valorTotal == valorTotal;
    @	ensures this.demandas == demandas;
    @*/
    public NotaFiscalEstoque(String empresa, String nomeCliente, long codigo, Date dataFaturamento, double valorTotal, List<Demanda> demandas) {
        super(empresa, nomeCliente, codigo, dataFaturamento, valorTotal, demandas);
    }

    

    @Override
    public void imprimir() {
        String nota = "------Nota Fiscal------" + "\n";
        nota += getEmpresa() + "\n";
        nota += "CNPJ: XX.XXX.XXX.XXXX-XX"+"\n";
        nota += "---------------------------" + "\n";
        nota += "ID da Nota:" + getCodigo() + "\n";
        nota += "Nome do Cliente: " + getNomeCliente() + "\n";
        nota += "Data de Faturamento: " + getDataFaturamento() + "\n";

        nota += "Com o seguintes servicos: " + "\n";
        nota += "IdProduto " + "-----" + " Nome" + "-----" + " Preco " + "\n";
        for (Demanda produto : getDemandas()) {
            Item item = (Item) produto;
            nota +=  item.getIdDemanda()+"-----";
            nota +=  item.getNome()+"-----";
            nota +=  item.getPreco()+"\n";
        }    
        nota += "Valor Total: " + getValorTotal() + "\n";
        System.out.println(nota);
    }
    
}
