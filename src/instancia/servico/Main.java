/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.servico;

import GUI.GUILogin;
import control.GerenciadorClientes;
import dao.DaoDemanda;
import dao.DaoPedido;
import dao.DaoUsuarioCliente;
import dao.DaoUsuarioPadrao;
import dao.IDaoDemanda;
import dao.IDaoPedido;
import dao.IDaoUsuarioCliente;
import dao.IDaoUsuarioPadrao;
import domain.Demanda;
import domain.Pedido;
import domain.UsuarioCliente;
import domain.UsuarioPadrao;
import excecao.ClienteInvalidoException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hiarl
 */
public class Main {

    private static GUILogin guiLogin = new GUILoginServico();
    private static GerenciadorClientes gerenciadorCliente = new GerenciadorClientes();

    public static void main(String[] args) throws ClienteInvalidoException {
        popularDao();
        guiLogin.logar();
    }

    public static void popularDao() throws ClienteInvalidoException {
        IDaoUsuarioCliente daoCliente = DaoUsuarioCliente.getInstance();
        IDaoUsuarioPadrao daoUsuarioPadrao = DaoUsuarioPadrao.getInstance();
        IDaoDemanda daoDemanda = DaoDemanda.getInstance();
        IDaoPedido daoPedido = DaoPedido.getInstance();
        /*
        public UsuarioCliente(long id, String nome, String endereco, String telefone, String login, String senha)
         */
        UsuarioPadrao usuarioPadrao1 = new UsuarioPadrao(false, "Thiago", "R. dos Lascados", "84 9 5254-6586", "thiago", "admin");
        UsuarioPadrao usuarioPadrao = new UsuarioPadrao(true, "Hiarley", "R. dos Lascados", "84 9 5236-5656", "admin", "admin");
        UsuarioCliente usuarioCliente = new UsuarioCliente("Joao", "Av. Professor não me reprova pelo amor de Deus", "84 9 9858-5256", "joao", "admin");
        Demanda servico = new Servico("MicroInformatica LTDA", "Impressora", 200, "Conserto de Impressora/Troca de peças/Manutenção", new Date());
        Demanda servico1 = new Servico("MicroInformatica LTDA", "Computador", 100, "Manutenção/Limpesa/Formatação", new Date());
        Demanda servico2 = new Servico("MicroInformatica LTDA", "Roteadores", 50, "Instalação/Configuração/Consertos", new Date());
        daoDemanda.adicionarDemanda(servico);
        daoDemanda.adicionarDemanda(servico1);
        daoDemanda.adicionarDemanda(servico2);
        daoCliente.adicionarCliente(usuarioCliente);
        daoUsuarioPadrao.adicionarUsuario(usuarioPadrao);
        daoUsuarioPadrao.adicionarUsuario(usuarioPadrao1);
        ArrayList<Demanda> listaProdutos = new ArrayList();
        listaProdutos.add(servico);
        Pedido pedido = new Pedido(usuarioCliente.getId(), new Date(), "Problemas", 'I', listaProdutos);
        daoPedido.adicionarPedido(pedido);
        listaProdutos.add(servico1);
        Pedido pedido1 = new Pedido(usuarioCliente.getId(), new Date(), "Problemas1", 'I', listaProdutos);
        daoPedido.adicionarPedido(pedido1);
        listaProdutos.add(servico2);
        Pedido pedido2 = new Pedido(usuarioCliente.getId(), new Date(), "Problemas2", 'I', listaProdutos);
        daoPedido.adicionarPedido(pedido2);
    }
}
