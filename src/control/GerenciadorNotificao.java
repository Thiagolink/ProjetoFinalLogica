/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.Pedido;
import domain.FabricaNotificacao;
import domain.Historico;
import domain.Notificacao;

/**
 *
 * @author Thiago
 */
public class GerenciadorNotificao {

    private FabricaNotificacao fabricaNotificacao;

    public GerenciadorNotificao(FabricaNotificacao fabricaNotificacao) {
        this.fabricaNotificacao = fabricaNotificacao;
    }

    public void NotificarInicio(Pedido demanda) {

        Notificacao notificao = fabricaNotificacao.criarInicioNoticiarDemanda(demanda);

        notificao.enviar();
    }

    public void NotificarAtualizacao(Historico historico) {
        Notificacao notificao = fabricaNotificacao.criarNotificacaoAtualizarDemanda(historico);
        notificao.enviar();
    }
}
