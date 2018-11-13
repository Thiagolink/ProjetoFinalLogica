/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.fastfood;

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

    private static GUILogin guiLogin = new GUILoginFastFood();
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
        Demanda alimento = new Alimento("Subway", "Comida", "Baratissimo", 7, "Pão/carne/salada", new Date());
        Demanda alimento1 = new Alimento("Refrigerante", "Bebida", "Guaraná", 0.69, "Refrigerante de 500ml", new Date());
        Demanda alimento2 = new Alimento("Chiquinhos", "Sobremesa", "Milk Shake de Ovo Maltine", 9, "Sorvete, leite, ovomaltine", new Date());
        ArrayList<Demanda> listaProduto = new ArrayList<>();
        listaProduto.add(alimento);
        listaProduto.add(alimento2);
        Pedido pedido = new Pedido(usuarioCliente.getId(), new Date(), "Sem observação", 'I', listaProduto);
        daoPedido.adicionarPedido(pedido);
        daoDemanda.adicionarDemanda(alimento);
        daoDemanda.adicionarDemanda(alimento1);
        daoDemanda.adicionarDemanda(alimento2);
        daoCliente.adicionarCliente(usuarioCliente);
        daoUsuarioPadrao.adicionarUsuario(usuarioPadrao);
        daoUsuarioPadrao.adicionarUsuario(usuarioPadrao1);
        listaProduto.add(alimento);
        Pedido pedido3 = new Pedido(usuarioCliente.getId(), new Date(), "Problemas", 'I', listaProduto);
        daoPedido.adicionarPedido(pedido);
        listaProduto.add(alimento1);
        Pedido pedido1 = new Pedido(usuarioCliente.getId(), new Date(), "Problemas1", 'I', listaProduto);
        daoPedido.adicionarPedido(pedido1);
        listaProduto.add(alimento2);
        Pedido pedido2 = new Pedido(usuarioCliente.getId(), new Date(), "Problemas2", 'I', listaProduto);
        daoPedido.adicionarPedido(pedido2);

    }
}
