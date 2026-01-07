package org.JMachine.presentation;

import java.util.Scanner;

public class Console {

    private final Scanner scan = new Scanner(System.in);
    private final StudentConsoleHandler consoleHandler;

    public Console(StudentConsoleHandler ch){
        this.consoleHandler = ch;
    }

    public void start() {
        String options = """
                ======================================
                          JMachine Engine
                ======================================
                Seja bem-vindo à sua plataforma de estudos!

                1 - Cadastrar estudante
                2 - Listar estudantes

                3 - Cadastrar exercício
                4 - Responder exercício

                5 - Analisar desempenho
                6 - Gerar plano de estudos
                7 - Recomendações Inteligentes (IA)

                0 - Sair
                """;

        String answer;

        do {
            System.out.println(options);
            System.out.print("Escolha uma opção: ");
            answer = scan.nextLine();

            switch (answer) {
                case "1":
                    consoleHandler.register(scan);
                    break;
                case "2":
                    System.out.println("Listar estudantes");
                    break;
                case "3":
                    System.out.println("Cadastrar exercício");
                    break;
                case "4":
                    System.out.println("Responder exercício");
                    break;
                case "5":
                    System.out.println("Analisar desempenho");
                    break;
                case "6":
                    System.out.println("Gerar plano de estudos");
                    break;
                case "7":
                    System.out.println("Recomendações inteligentes (IA)");
                    break;
                case "0":
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (!"0".equals(answer));
    }
}
