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
public interface NotaFiscalBuilder {
	
	//@ public nullable model instance String InomeCliente;
	//@ public nullable model instance String InomeEmpresa;
	//@ public nullable model instance long Icodigo;
	//@ public nullable model instance Date IdataFaturamento;
	//@ public nullable model instance List Idemandas;
	//@ public nullable model instance double Ivalor;
	
	/*@
	 @	requires nomeCliente != "";
	 @ 	assignable InomeCliente;
	 @	ensures InomeCliente == nomeCliente;
	 @*/
    void buildCliente(String nomeCliente);
    
    /*@
	 @	requires nomeEmpresa != "";
	 @ 	assignable InomeEmpresa;
	 @	ensures InomeEmpresa == nomeEmpresa;
	 @*/
    void buildEmpresa(String nomeEmpresa);

    /*@
	 @	requires 0 <= codigo;
	 @ 	assignable Icodigo;
	 @	ensures Icodigo == codigo;
	 @*/
    void buildCodigoPedido(long codigo);

    /*@
	 @	requires dataFaturamento != null;
	 @ 	assignable IdataFaturamento;
	 @	ensures IdataFaturamento == dataFaturamento;
	 @*/
    void buildDataFaturamento(Date dataFaturamento);

    /*@
	 @	requires demandas != null;
	 @ 	assignable Idemandas;
	 @	ensures Idemandas == demandas;
	 @*/
    void buildDemandas(List<Demanda> demandas);

    /*@
	 @	requires 0 <= valor;
	 @ 	assignable Ivalor;
	 @	ensures Ivalor == valor;
	 @*/
    void buildValorTotal(double valor);

    public /*@ pure @*/ NotaFiscal getComprovante();
}
