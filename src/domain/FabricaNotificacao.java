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
public interface FabricaNotificacao {
    public Notificacao criarInicioNoticiarDemanda(Pedido demanda);
    public Notificacao criarNotificacaoAtualizarDemanda(Historico historico);
}
