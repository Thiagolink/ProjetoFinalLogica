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

    private /*@ spec_public @*/  FabricaNotificacao fabricaNotificacao;

    /*@
    @ 	requires fabricaNotificacao != null;
    @	assignable this.fabricaNotificacao;
    @	ensures this.fabricaNotificacao == fabricaNotificacao;
    @*/
    public GerenciadorNotificao(FabricaNotificacao fabricaNotificacao) {
        this.fabricaNotificacao = fabricaNotificacao;
    }
    
    /*@
     @ 		requires pedido != null;
     @*/
    public void NotificarInicio(Pedido pedido) {

        Notificacao notificao = fabricaNotificacao.criarInicioNoticiarDemanda(pedido);

        notificao.enviar();
    }

    /*@
    @ 		requires historico != null;
    @*/
    public void NotificarAtualizacao(Historico historico) {
        Notificacao notificao = fabricaNotificacao.criarNotificacaoAtualizarDemanda(historico);
        notificao.enviar();
    }
}
