/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.estoque;

import GUI.GUIAdministrador;
import control.GerenciadorClientes;
import control.GerenciadorPedidos;
import control.GerenciadorHistoricos;
import control.GerenciadorNotificao;
import control.GerenciadorDemanda;
import control.GerenciadorUsuarios;
import domain.Pedido;
import domain.Historico;
import domain.Usuario;
import domain.UsuarioCliente;
import domain.UsuarioPadrao;
import excecao.DemandaInvalidoException;
import excecao.PedidoInvalidoException;
import excecao.HistoricoInvalidoException;
import instancia.fastfood.GUIUsuarioFastFood;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class GUIAdministradorEstoque implements GUIAdministrador {

    private static Scanner in = new Scanner(System.in);
    private GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
    private GerenciadorDemanda gerenciadorDemanda = new GerenciadorDemanda();
    private GerenciadorClientes gerenciadorCliente = new GerenciadorClientes();
    private GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos(new FabricaNotificacaoEstoque(), new NotaFiscalBuilderEstoque());
    private GerenciadorHistoricos gerenciadorHistoricos = new GerenciadorHistoricos();
    private GerenciadorNotificao gerenciadorNotificacao = new GerenciadorNotificao(new FabricaNotificacaoEstoque());

    @Override
    public void cadastrarUsuario() {
        try {

            System.out.println("---------- Cadastrar Usuario----------");
            System.out.print("Nome: ");
            String nome = in.next();
            System.out.print("Endereço: ");
            String setor = in.next();
            System.out.print("Telefone: ");
            String telefone = in.next();
            System.out.print("Login: ");
            String login = in.next();
            System.out.print("Senha: ");
            String senha = in.next();
            System.out.print("Administrador: ");
            boolean administrador = in.nextBoolean();

            gerenciadorUsuarios.cadastrarUsuario(new UsuarioPadrao(administrador, nome, setor, telefone, login, senha));
        } catch (Exception e) {

        }

    }

    @Override
    public void cadastrarProdutos() {
        System.out.println("Nome do Produto: ");
        String nome = in.nextLine();
        System.out.println("Quantidade em Estoque: ");
        int quantidadeEmEstoque = in.nextInt();
        System.out.println("Preco: ");
        double preco = Double.parseDouble(in.nextLine());
        System.out.println("Descricao: ");
        String descricao = in.nextLine();

        try {
            gerenciadorDemanda.cadastrarDemanda(new Item(quantidadeEmEstoque, nome, preco, descricao, new Date()));
        } catch (PedidoInvalidoException ex) {
            Logger.getLogger(GUIAdministradorEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DemandaInvalidoException ex) {
            Logger.getLogger(GUIAdministradorEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void removerUsuario() {
        try {
            System.out.println("---------- Remover Usuario----------");
            System.out.print("Id: ");
            long id = Long.parseLong(in.nextLine());
            gerenciadorUsuarios.removerUsuario(gerenciadorUsuarios.getUsuario(id));
        } catch (Exception e) {

        }
    }

    @Override
    public void removerProdutos() {
        System.out.println("Digite o id do Produto: ");
        long id = in.nextLong();
        gerenciadorDemanda.removerDemanda(gerenciadorDemanda.getDemanda(id));
    }

    @Override
    public void listarUsuarios() {
        try {
            ArrayList<UsuarioPadrao> listUsuario = gerenciadorUsuarios.listarUsuarios();
            Iterator<UsuarioPadrao> it = listUsuario.iterator();

            while (it.hasNext()) {
                UsuarioPadrao usuarioPadrao = it.next();
                System.out.println("---------------------------------------");

                System.out.println("Administrador" + usuarioPadrao.isAdministrador());
                System.out.println("Id: " + usuarioPadrao.getId());
                System.out.println("Nome: " + usuarioPadrao.getNome());
                System.out.println("Endereço: " + usuarioPadrao.getEndereco());
                System.out.println("Telefone: " + usuarioPadrao.getTelefone());
                System.out.println("Login: " + usuarioPadrao.getLogin());
                System.out.println("Senha: " + usuarioPadrao.getSenha());
            }
        } catch (Exception e) {
        }

    }

    @Override
    public void cadastrarCliente() {
        try {

            System.out.println("---------- Cadastrar Cliente----------");
            System.out.println("Nome: ");
            String nome = in.next();
            System.out.println("Endereço: ");
            String setor = in.next();
            System.out.println("Telefone: ");
            String telefone = in.next();
            System.out.println("Login: ");
            String login = in.next();
            System.out.println("Senha: ");
            String senha = in.next();

            gerenciadorCliente.cadastrarCliente(new UsuarioCliente(nome, setor, telefone, login, senha));
        } catch (Exception e) {

        }
    }

    @Override
    public void removerCliente() {
        try {
            System.out.println("---------- Remover Cliente----------");
            System.out.print("Id: ");
            long id = Long.parseLong(in.nextLine());
            gerenciadorCliente.removerCliente(gerenciadorCliente.getCliente(id));
        } catch (Exception e) {

        }
    }

    @Override
    public void listarCliente() {
        ArrayList<UsuarioCliente> listUsuario = gerenciadorCliente.listarClientes();
        Iterator<UsuarioCliente> it = listUsuario.iterator();

        while (it.hasNext()) {
            UsuarioCliente usuarioCliente = it.next();
            System.out.println("---------------------------------------");
            System.out.println("ID:" + usuarioCliente.getId());
            System.out.println("Nome: " + usuarioCliente.getNome());
            System.out.println("Endereço: " + usuarioCliente.getEndereco());
            System.out.println("Telefone: " + usuarioCliente.getTelefone());
            System.out.println("Login: " + usuarioCliente.getLogin());
            System.out.println("Senha: " + usuarioCliente.getSenha());
        }
    }

    @Override
    public void analisarPedido(Usuario usuario) {
        listarPedidos();
        System.out.println("Digite o Id do Pedido: ");
        long idDemanda = Long.parseLong(in.next());
        Pedido pedido = gerenciadorPedidos.getPedido(idDemanda);
        pedido.setIdUsuarioDemandando(usuario.getId());
        in.nextLine();

        System.out.println("Descreva o historico: ");
        String descricao = in.nextLine();
        System.out.println("Status: ");
        char status = in.next().charAt(0);
        try {
            pedido.setStatus(status);
        } catch (PedidoInvalidoException ex) {
            Logger.getLogger(GUIUsuarioFastFood.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            gerenciadorHistoricos.adicionarHistorico(new Historico(idDemanda, pedido.getIdUsuarioDemandando(), new Date(), descricao, usuario));
            gerenciadorNotificacao.NotificarAtualizacao(new Historico(idDemanda, pedido.getIdUsuarioDemandando(), new Date(), descricao, usuario));
        } catch (HistoricoInvalidoException ex) {
            Logger.getLogger(GUIUsuarioEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void listarPedidos() {

        List<Pedido> listPedido = gerenciadorPedidos.listarPedidos();

        for (Pedido demanda : listPedido) {
            System.out.println("---------------------------------------");

            System.out.println("IdUsuarioSolicitante: " + demanda.getIdUsuarioSolicitante());
            System.out.println("IdDemanda: " + demanda.getIdServico());
            System.out.println("Data: " + demanda.getDataAbertura());
            System.out.println("IdUsuarioDemandando: " + demanda.getIdUsuarioDemandando());
            System.out.println("Descricao: " + demanda.getDescricao());
            System.out.println("Status: " + demanda.getStatus());
        }
    }

}
