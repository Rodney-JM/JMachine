package org.JMachine.presentation;

import org.JMachine.presentation.student.CreateStudentConsoleHandler;
import org.JMachine.presentation.student.ListStudentConsoleHandler;

import java.util.Scanner;

public class Console {

    private final Scanner scan = new Scanner(System.in);
    private final CreateStudentConsoleHandler createStudentConsoleHandler;
    private final ListStudentConsoleHandler listStudentConsoleHandler;

    public Console(CreateStudentConsoleHandler ch, ListStudentConsoleHandler lh){
        this.createStudentConsoleHandler = ch;
        this.listStudentConsoleHandler = lh;
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
                    createStudentConsoleHandler.register(scan);
                    break;
                case "2":
                    listStudentConsoleHandler.showAll();
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
