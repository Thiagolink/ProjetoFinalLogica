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

    //preencher com as partes que vão fazer parte do builder
    void buildCliente(String nomeCliente);
    
    void buildEmpresa(String nomeEmpresa);

    void buildCodigoPedido(Long codigo);

    void buildDataFaturamento(Date dataFaturamento);

    void buildDemandas(List<Demanda> demandas);

    void buildValorTotal(double valor);

    NotaFiscal getComprovante();
}
