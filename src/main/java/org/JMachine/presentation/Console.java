package org.JMachine.presentation;

import org.JMachine.presentation.student.CreateStudentConsoleHandler;
import org.JMachine.presentation.student.ListStudentConsoleHandler;
import org.JMachine.presentation.student.UpdateStudentConsoleHandler;

import java.util.Scanner;

public class Console {

    private final Scanner scan = new Scanner(System.in);
    private final CreateStudentConsoleHandler createStudentConsoleHandler;
    private final ListStudentConsoleHandler listStudentConsoleHandler;
    private final UpdateStudentConsoleHandler updateStudentConsoleHandler;

    public Console(CreateStudentConsoleHandler ch, ListStudentConsoleHandler lh, UpdateStudentConsoleHandler uh){
        this.createStudentConsoleHandler = ch;
        this.listStudentConsoleHandler = lh;
        this.updateStudentConsoleHandler = uh;
    }

    public void start() {
        String options = """
                ======================================
                          JMachine Engine
                ======================================
                Seja bem-vindo à sua plataforma de estudos!

                1 - Cadastrar estudante
                2 - Listar estudantes
                    
                3 - Atualizar estudante
                4 - Deletar estudante
                
                5 - Cadastrar exercício
                6 - Responder exercício

                7 - Analisar desempenho
                8 - Gerar plano de estudos
                9 - Recomendações Inteligentes (IA)

                0 - Sair
                """;

        String answer;

        do {
            System.out.println(options);
            System.out.print("Escolha uma opção: ");
            answer = scan.nextLine();

            switch (answer) {
                case "1":
                    try{
                        createStudentConsoleHandler.register(scan);
                    }catch (Exception e){
                        System.out.println("Erro ao cadastrar: " + e.getMessage());
                    }
                    break;
                case "2":
                    try{
                        listStudentConsoleHandler.showAll();
                    }catch (Exception e){
                        System.out.println("Erro ao mostrar os usuários: " + e.getMessage());
                    }
                    break;
                case "3":
                    try{
                        updateStudentConsoleHandler.update(scan);
                    }catch(Exception e){
                        System.out.println("Erro ao atualizar usuário: " + e.getMessage());
                    }
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("Cadastrar exercício");
                    break;
                case "6":
                    System.out.println("Responder exercício");
                    break;
                case "7":
                    System.out.println("Analisar desempenho");
                    break;
                case "8":
                    System.out.println("Gerar plano de estudos");
                    break;
                case "9":
                    System.out.println("Recomendações inteligentes (IA)");
                    break;
                case "0":
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (!"0".equals(answer));
        scan.close();
    }
}
