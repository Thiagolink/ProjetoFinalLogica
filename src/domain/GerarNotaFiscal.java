/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Thiago
 */
public class GerarNotaFiscal {
    private NotaFiscalBuilder notaFiscalBuilder;

    public GerarNotaFiscal(NotaFiscalBuilder notaFiscalBuilder) {
        this.notaFiscalBuilder = notaFiscalBuilder;
    }
    
    public NotaFiscal gerarNotaFiscal(Pedido pedido, UsuarioCliente usuario, String empresa, Pagamento pagamento){
        this.notaFiscalBuilder.buildCliente(usuario.getNome());
        this.notaFiscalBuilder.buildEmpresa(empresa);
        this.notaFiscalBuilder.buildCodigoPedido(pedido.getIdServico());
        this.notaFiscalBuilder.buildDataFaturamento(pedido.getDataAbertura());
        this.notaFiscalBuilder.buildDemandas(pedido.getListaProdutos());
        this.notaFiscalBuilder.buildValorTotal(pagamento.getValor());
        
        NotaFiscal notaFiscal = this.notaFiscalBuilder.getComprovante();
        
        return notaFiscal;
        
    }
}
