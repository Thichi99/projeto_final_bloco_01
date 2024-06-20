package application;

import application.model.Cadastro;
import application.util.Colors;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int opcao;

        Scanner ler = new Scanner(System.in);

        Cadastro c1 = new Cadastro("Thichi", "12321", "Rua thichi", 25, 1);
        c1.visualizar();
        Cadastro p1 = new Cadastro("ThichiFeliz", "54312", "Rua thichiFeliz", 27, 2);
        p1.visualizar();


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
            System.out.println("\n\t\t\t3 - Listar Profissionais                                     ");
            System.out.println("\n\t\t\t4 - Buscar Profissional por Código                           ");
            System.out.println("\n\t\t\t5 - Adicionar Profissionais                                  ");
            System.out.println("\n\t\t\t6 - Apagar Cadastro                                          ");
            System.out.println("\n\t\t\t7 - Sair                                                     ");
            System.out.println("                                                                     ");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Entre com a opção desejada: ");
            System.out.println("                                                                     " + Colors.TEXT_RESET);

            opcao = ler.nextInt();

            if (opcao == 7) {
                System.out.println("\nTerapia Online - Cuide de sua mente onde quer que esteja!");
                System.out.println("\nObrigado pela Consulta!");
                sobre();
                ler.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Criar Cadastro\n");
                    keyPress();
                    break;
                case 2:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n");
                    keyPress();
                    break;
                case 3:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Listar Profissionais\n");
                    keyPress();
                    break;
                case 4:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Buscar Profissional por Código\n");
                    keyPress();
                    break;
                case 5:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Adicionar Profissionais\n");
                    keyPress();
                    break;
                case 6:
                    System.out.println(Colors.TEXT_WHITE_BOLD + "Apagar Cadastro\n");
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
