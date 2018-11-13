/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.estoque;

import control.GerenciadorClientes;
import control.GerenciadorPedidos;
import domain.Pedido;
import domain.FabricaNotificacao;
import domain.Historico;
import domain.Notificacao;
import domain.Demanda;
import domain.UsuarioCliente;
import java.util.List;

/**
 *
 * @author hiarl
 */
public class FabricaNotificacaoEstoque implements FabricaNotificacao {

    private GerenciadorClientes gerenciadorCliente = new GerenciadorClientes();
    private GerenciadorPedidos gerenciadorServico = new GerenciadorPedidos(this, new NotaFiscalBuilderEstoque());

    @Override
    public Notificacao criarInicioNoticiarDemanda(Pedido pedido) {
        UsuarioCliente usuariocliente = gerenciadorCliente.getCliente(pedido.getIdUsuarioSolicitante());
        String mensagem = "";
        mensagem += "Olá, ";
        mensagem += usuariocliente.getTelefone();
        mensagem += "!Um novo Pedido Realizado com o seu Id!!\n";
        mensagem += "ID do Usuario: " + pedido.getIdUsuarioSolicitante() + "\n";
        mensagem += "ID do Pedido: " + pedido.getIdServico() + "\n";
        mensagem += "Data do pedido: " + pedido.getDataAbertura() + "\n";
        mensagem += "descricao: " + pedido.getDescricao() + "\n";
        mensagem += "status: " + pedido.getStatus() + "\n";
        mensagem += "Com o seguintes Itens: " + "\n";

        List<Demanda> listDemanda = pedido.getListaProdutos();
        for (Demanda produto : listDemanda) {

            Item item = (Item) produto;
            mensagem += "-------------------------------" + "\n";
            mensagem += "Nome" + item.getNome() + "\n";
            mensagem += "ID Produto: " + item.getIdDemanda() + "\n";
            mensagem += "Quantidade: " + item.getQuantidadeEmEstoque() + "\n";
            mensagem += "Preco: " + item.getPreco() + "\n";
            mensagem += "Descricao: " + item.getDescricao() + "\n";
            mensagem += "Prazo: " + item.getPrazo() + "\n";
        }

        return new NotificaWhatsapp(mensagem);

    }

    ;

    @Override
    public Notificacao criarNotificacaoAtualizarDemanda(Historico historico) {
        Pedido demanda = gerenciadorServico.getPedido(historico.getIdDemanda());
        UsuarioCliente usuarioCliente = gerenciadorCliente.getCliente(demanda.getIdUsuarioSolicitante());
        String mensagem = "";
        mensagem += "Olá, ";
        mensagem += usuarioCliente.getTelefone();
        mensagem += "!Uma nova atualização foi feita no seu Pedido:\n";
        mensagem += "Na Data: ";
        mensagem += historico.getDataModificaco();
        mensagem += "\nDescricao:\n";
        mensagem += historico.getDescricao();

        return new NotificaWhatsapp(mensagem);
    }

}
