package org.JMachine.presentation.student;

import org.JMachine.app.dto.student.UpdateStudentDTO;
import org.JMachine.app.usecase.student.UpdateStudentUseCase;
import org.JMachine.domain.model.student.StudentLevel;

import java.util.Scanner;

public class UpdateStudentConsoleHandler extends BaseStudentConsoleHandler{
    private final UpdateStudentUseCase updateStudentUseCase;

    public UpdateStudentConsoleHandler(UpdateStudentUseCase updateStudentUseCase){
        this.updateStudentUseCase = updateStudentUseCase;
    }

    public void update(Scanner scan){
        try{
            System.out.println("Digite o email do estudante: ");
            String email = scan.nextLine();

            System.out.println("Digite o novo nome do Usuário agora: ");
            String name = scan.nextLine();

            StudentLevel level = askLevel(scan);

            updateStudentUseCase.execute(email, new UpdateStudentDTO(name, level));
            System.out.println("Usuário atualizado com sucesso");
        }catch (IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
