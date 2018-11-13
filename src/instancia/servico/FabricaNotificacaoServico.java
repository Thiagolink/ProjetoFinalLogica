/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.servico;

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
public class FabricaNotificacaoServico implements FabricaNotificacao{
    
    
    
    private GerenciadorClientes gerenciadorCliente = new GerenciadorClientes();
    private GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos(this, new NotaFiscalBuilderServico());
    
    @Override
    public Notificacao criarInicioNoticiarDemanda(Pedido pedido){
        UsuarioCliente usuariocliente = gerenciadorCliente.getCliente(pedido.getIdUsuarioSolicitante());
        String mensagem = "";
        mensagem+="Olá, ";
        mensagem+=usuariocliente.getTelefone();
        mensagem+="!Um novo Pedido Realizado com o seu Id!!\n";
        mensagem+="idUsuarioSolicitante: " + pedido.getIdUsuarioSolicitante() + "\n";
        mensagem+="idDemanda: " + pedido.getIdServico() +"\n";
        mensagem+="dataAbertura: " + pedido.getDataAbertura() + "\n";
        mensagem+="idUsuarioDemandado: " + pedido.getIdUsuarioDemandando() + "\n";
        mensagem+="descricao: " + pedido.getDescricao()+"\n";
        mensagem+="status: " + pedido.getStatus() + "\n";
        mensagem+="Com o seguintes servicos: " + "\n";
        
        List<Demanda> listDemanda = pedido.getListaProdutos();
        for(Demanda produto : listDemanda){
            
            Servico servico = (Servico) produto;
            mensagem+="-------------------------------"+"\n";
            mensagem+="Nome" + servico.getNome()+"\n";
            mensagem+="IdProduto: " + servico.getIdDemanda()+"\n";
            mensagem+="Empresa Fornecedora: " + servico.getEmpresaFornecedora()+"\n";
            mensagem+="Preco: " + servico.getPreco()+"\n";
            mensagem+="Descricao: " + servico.getDescricao()+"\n";
            mensagem+="Prazo: " + servico.getPrazo()+"\n";
        }
        
        return new NotificaSMS(mensagem);

            
        };

    @Override
    public Notificacao criarNotificacaoAtualizarDemanda(Historico historico) {
        Pedido pedido = gerenciadorPedidos.getPedido(historico.getIdDemanda());
        UsuarioCliente usuarioCliente = gerenciadorCliente.getCliente(pedido.getIdUsuarioSolicitante());
        String mensagem = "";
        mensagem+="Olá, ";
        mensagem+=usuarioCliente.getTelefone();         
        mensagem+="!Uma nova atualização foi feita no seu Pedido:\n";
        mensagem+="Na Data: ";
        mensagem+=historico.getDataModificaco();
        mensagem+="\nDescricao:\n";
        mensagem+=historico.getDescricao();
        
                  
        return new NotificaSMS(mensagem);
    }
        
    }


