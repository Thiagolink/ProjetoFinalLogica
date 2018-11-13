/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.fastfood;

import control.GerenciadorClientes;
import control.GerenciadorPedidos;
import domain.Pedido;
import domain.FabricaNotificacao;
import domain.Historico;
import instancia.servico.NotificaSMS;
import domain.Notificacao;
import domain.Demanda;
import domain.UsuarioCliente;
import java.util.List;

/**
 *
 * @author hiarl
 */
public class FabricaNotificacaoFastFood implements FabricaNotificacao {

    private GerenciadorClientes gerenciadorCliente = new GerenciadorClientes();
    private GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos(this, new NotaFiscalBuilderFastFood());

    @Override
    public Notificacao criarInicioNoticiarDemanda(Pedido demanda) {
        UsuarioCliente usuariocliente = gerenciadorCliente.getCliente(demanda.getIdUsuarioSolicitante());
        String mensagem = "";
        mensagem += "Olá, ";
        mensagem += usuariocliente.getNome();
        mensagem += "!Um novo Pedido Realizado com o seu Id!!\n";
        mensagem += "Seu ID " + demanda.getIdUsuarioSolicitante() + "\n";
        mensagem += "ID do Pedido: " + demanda.getIdServico() + "\n";
        mensagem += "Data do Pedido: " + demanda.getDataAbertura() + "\n";
        mensagem += "Obeservação: " + demanda.getDescricao() + "\n";

        mensagem += "Com o seguintes itens: " + "\n";

        List<Demanda> listDemanda = demanda.getListaProdutos();
        for (Demanda produto : listDemanda) {

            Alimento alimento = (Alimento) produto;
            mensagem += "-------------------------------" + "\n";
            mensagem += "Nome: " + alimento.getNome()+ "\n";
            mensagem += "IdProduto: " + alimento.getIdDemanda()+ "\n";
            mensagem += "Tipo do Alimento: " + alimento.getTipoAlimento()+ "\n";
            mensagem += "Preco: " + alimento.getPreco()+ "\n";
            mensagem += "Descrição: " + alimento.getDescricao()+ "\n";
            mensagem += "Prazo: " + alimento.getPrazo()+ "\n";
            mensagem += "Fornecedor: " + alimento.getFornecedor()+ "\n";
        }

        return new NotificaEmail(mensagem);

    }

    ;

    @Override
    public Notificacao criarNotificacaoAtualizarDemanda(Historico historico) {
        Pedido demanda = gerenciadorPedidos.getPedido(historico.getIdDemanda());
        UsuarioCliente usuarioCliente = gerenciadorCliente.getCliente(demanda.getIdUsuarioSolicitante());
        String mensagem = "";
        mensagem += "Olá, ";
        mensagem += usuarioCliente.getTelefone();
        mensagem += "!Uma nova atualização foi feita no seu Pedido:\n";
        mensagem += "Na Data: ";
        mensagem += historico.getDataModificaco();
        mensagem += "\nDescricao:\n";
        mensagem += historico.getDescricao();

        return new NotificaSMS(mensagem);
    }

}
