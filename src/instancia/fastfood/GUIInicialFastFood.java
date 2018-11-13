/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancia.fastfood;

import GUI.GUIAdministrador;
import GUI.GUICliente;
import GUI.GUIInicial;
import GUI.GUIUsuario;
import domain.Usuario;
import domain.UsuarioPadrao;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class GUIInicialFastFood implements GUIInicial {

    private Scanner in = new Scanner(System.in);

    private GUIAdministrador guiAdministrador = new GUIAdministradorFastFood();
    private GUIUsuario guiUsuario = new GUIUsuarioFastFood();
    private GUICliente guiCliente = new GUIClienteFastFood();

    public void acessarInterface(Usuario usuario) {
        
        int option;

        do {
            if(usuario instanceof UsuarioPadrao){
                 UsuarioPadrao padrao = (UsuarioPadrao) usuario;
                 if(padrao.isAdministrador()){
                     option = 1;
                 }else{
                     option = 2;
                 }
            }else{
                option = 3;
            }
            switch (option) {
                case 1:
                    showMenuGUIUsuarioAdministrador(usuario);
                    break;
                case 2:
                    showMenuGUIUsuarioPadrao(usuario);
                    break;
                case 3:
                    showMenuGUIUsuarioCliente(usuario);
                    break;
                default:
                    break;
            }
        } while (option > 0);
    }

    public void showMenuGUIUsuarioAdministrador(Usuario usuario) {
        int option;

        do {
            System.out.println("---------- Area Admistrador----------");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Cadastrar Tipo de Serviço");
            System.out.println("3 - Remover Usuario");
            System.out.println("4 - Remover Tipo de Serviço");
            System.out.println("5 - Listar Informações");
            System.out.println("6 - Cadastrar Cliente");
            System.out.println("7 - Remover Cliente");
            System.out.println("8 - Analisar Pedido");

            System.out.println("0 - Sair");

            System.out.print("Opcao desejada: ");
            option = in.nextInt();

			//clearConsole();
            switch (option) {
                case 1:
                    guiAdministrador.cadastrarUsuario();
                    break;
                case 2:
                    guiAdministrador.cadastrarProdutos();
                    break;
                case 3:
                    guiAdministrador.removerUsuario();
                    break;
                case 4:
                    guiAdministrador.removerProdutos();
                    break;
                case 5:
                    showMenuGUIInformacoes();
                    break;
                case 6:
                    guiAdministrador.cadastrarCliente();
                    break;
                case 7:
                    guiAdministrador.removerCliente();
                    break;
                case 8:
                    guiAdministrador.analisarPedido(usuario);
                    break;

                default:
                   System.exit(0);
                    break;
            }
        } while (option > 0);
    }

    public void showMenuGUIUsuarioPadrao(Usuario usuario) {
        int option;

        do {
            System.out.println("---------- Area Usuario Padrao----------");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Remover Cliente");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Analisar Pedido");

            System.out.println("0 - Sair");

            System.out.print("Opcao desejada: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    guiUsuario.cadastrarCliente();
                    break;
                case 2:
                    guiUsuario.removerCliente();
                    break;
                case 3:
                    guiUsuario.listarCliente();
                    break;
                case 4:
                    guiUsuario.analisarPedido(usuario);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } while (option > 0);
    }

    public void showMenuGUIUsuarioCliente(Usuario usuario) {
        int option;

        do {
            System.out.println("---------- Area Cliente----------");
            System.out.println("1 - Cadastrar Pedido");
            System.out.println("2 - Listar Minhas Demandas");

            System.out.println("0 - Sair");

            System.out.print("Opcao desejada: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    guiCliente.cadastrarPedido(usuario);
                    break;
                case 2:
                    guiCliente.listarPedidos(usuario);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } while (option > 0);
    }
    
    public void showMenuGUIInformacoes(){
        int option;
        do{
            System.out.println("1 - Listar Usuarios");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Listar Produtos");
            System.out.println("4 - Listar Demandas");
            
            System.out.println("0 - Sair");
            
            System.out.print("Opcao desejada: ");
            option = in.nextInt();
            
            switch (option) {
                case 1:
                    guiAdministrador.listarUsuarios();
                    break;
                case 2:
                    guiAdministrador.listarCliente();
                    break;
                case 3:
                    guiCliente.listarDemandas();
                    break;
                case 4:
                    guiAdministrador.listarPedidos();
                    break;
                default:
                    System.exit(0);
                    break;
            }
            
            
        }while (option > 0);
    }

}
