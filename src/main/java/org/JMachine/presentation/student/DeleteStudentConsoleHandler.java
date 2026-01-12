package org.JMachine.presentation.student;

import org.JMachine.app.usecase.student.DeleteStudentUseCase;

import java.util.Scanner;

public class DeleteStudentConsoleHandler {
    private final DeleteStudentUseCase deleteStudentUseCase;

    public DeleteStudentConsoleHandler(DeleteStudentUseCase deleteStudentUseCase){
        this.deleteStudentUseCase = deleteStudentUseCase;
    }

    public void delete(Scanner scan){
        try{
            System.out.println("Digite a seguir o email do estudante que será deletado: ");
            String email = scan.nextLine();

            deleteStudentUseCase.executeByEmail(email);
            System.out.println("Usuário Deletado com sucesso");
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
