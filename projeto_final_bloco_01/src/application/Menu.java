package application;

import application.controller.CadastroController;
import application.model.CadastroCliente;
import application.model.CadastroProfissional;
import application.util.Colors;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        CadastroController cadastro = new CadastroController();

        int opcao, tipo, numero;
        String nome, endereco, telefone, crp;

        Scanner ler = new Scanner(System.in);

        CadastroCliente cc1 = new CadastroCliente("ThichiCliente1", "(11)91222-1111", "Rua Jacaré", 1, 1);
        cadastro.cadastrar(cc1);
        CadastroCliente cc2 = new CadastroCliente("ThichiCliente2", "(11)93333-1111", "Rua Jacaré", 2, 1);
        cadastro.cadastrar(cc2);
        CadastroProfissional cp1 = new CadastroProfissional("ThichiProfissional1", "(11)93333-1111", "Rua Jacaré", 3, 1,
                "23354345445");
        cadastro.cadastrar(cp1);
        CadastroProfissional cp2 = new CadastroProfissional("ThichiProfissional2", "(11)93333-1111", "Rua Jacaré", 4, 1,
                "23354345445");
        cadastro.cadastrar(cp2);

        cadastro.listarCadastros();

        try {
            opcao = ler.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Digite Valores Inteiros!");
            ler.nextLine();
            opcao = 0;
        }

        while (true) {
            System.out.println(Colors.TEXT_WHITE + Colors.ANSI_BLACK_BACKGROUND);

            System.out.println("---------------------------------------------------------------------");
            System.out.println("                                                                     ");
            System.out.println("\n\t\t\tTerapia Online - Cuide de sua Mente onde quer que esteja!    ");
            System.out.println("                                                                     ");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("                                                                     ");
            System.out.println("\n\t\t\t1 - Criar Cadastro                                           ");
            System.out.println("\n\t\t\t2 - Atualizar dados da Conta                                 ");
            System.out.println("\n\t\t\t3 - Listar Cadastros                                     ");
            System.out.println("\n\t\t\t4 - Buscar Cadastros por Código                           ");
            System.out.println("\n\t\t\t5 - Apagar Cadastro                                          ");
            System.out.println("\n\t\t\t6 - Sair                                                     ");
            System.out.println("                                                                     ");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Entre com a opção desejada: ");
            System.out.println("                                                                     " + Colors.TEXT_RESET);

            opcao = ler.nextInt();

            if (opcao == 6) {
                System.out.println("\nTerapia Online - Cuide de sua mente onde quer que esteja!");
                System.out.println("\nObrigado pela Consulta!");
                sobre();
                ler.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Criar Cadastro\n");

                    System.out.println("\nDigite o tipo de Cadastro que deseja fazer(1-Cliente ou 2-Profissional): ");
                    tipo = ler.nextInt();

                    System.out.println("\nDigite o seu nome: ");
                    ler.skip("\\R?");
                    nome = ler.nextLine();

                    System.out.println("\nDigite o seu endereço: ");
                    ler.skip("\\R?");
                    endereco = ler.nextLine();

                    System.out.println("\nDigite o seu número de telefone:");
                    telefone = ler.nextLine();

                    switch (tipo) {
                        case 1:
                            cadastro.cadastrar(new CadastroCliente(nome, telefone, endereco, cadastro.gerarNumero(), tipo));

                        case 2:
                            System.out.println("\nDigite o seu número de Cadastro Regional de Psicologia: ");
                            crp = ler.nextLine();
                            cadastro.cadastrar(new CadastroProfissional(nome, telefone, endereco, cadastro.gerarNumero(), tipo, crp));
                    }

                    keyPress();
                    break;
                case 2:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n");

                    System.out.println("\nDigite o número do Cadastro: ");
                    numero = ler.nextInt();

                    var buscaCadastro = cadastro.buscarNaLista(numero);

                    if (buscaCadastro != null) {
                        tipo = buscaCadastro.getTipo();

                        System.out.println("\nDigite o seu nome: ");
                        ler.skip("\\R?");
                        nome = ler.nextLine();

                        System.out.println("\nDigite o seu endereço: ");
                        ler.skip("\\R?");
                        endereco = ler.nextLine();

                        System.out.println("\nDigite o seu número de telefone: ");
                        telefone = ler.nextLine();

                        switch (tipo) {
                            case 1:
                                cadastro.atualizar(new CadastroCliente(nome, telefone, endereco, numero, tipo));
                            case 2:
                                System.out.println("\nDigite o seu número de Cadastro Regional de Psicologia: ");
                                crp = ler.nextLine();
                                cadastro.atualizar(new CadastroProfissional(nome, telefone, endereco, numero, tipo, crp));
                            default:
                                System.out.println("\nTipo de Cadastro Inválido.");
                                keyPress();
                                break;
                        }
                    } else {
                        System.out.println("O Cadastro não foi encontrado.");
                    }

                    keyPress();
                    break;
                case 3:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Listar Cadastros\n");
                    cadastro.listarCadastros();
                    keyPress();
                    break;
                case 4:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Buscar Cadastro por Código\n");

                    System.out.println("\nDigite o número do Cadastro:");
                    numero = ler.nextInt();

                    cadastro.procurarPorCod(numero);

                    keyPress();
                    break;
                case 5:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Apagar Cadastro\n");

                    System.out.println("\nDigite o número do Cadastro: ");
                    numero = ler.nextInt();

                    cadastro.apagar(numero);

                    keyPress();
                    break;
                default:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Opção Inválida!\n");
                    keyPress();
                    break;
            }

        }
    }

    public static void keyPress() {
        try {
            System.out.println(Colors.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }

    public static void sobre() {
        System.out.println("\n---------------------------------------------------------------------");
        System.out.println("Projeto Desenvolvido por: ");
        System.out.println("Thiago dos Passos Lima - thiago.plima99@gmail.com");
        System.out.println("https://github.com/Thichi99");
        System.out.println("---------------------------------------------------------------------");
    }
}
