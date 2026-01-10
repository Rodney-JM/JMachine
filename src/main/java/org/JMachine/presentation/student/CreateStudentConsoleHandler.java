package org.JMachine.presentation.student;

import org.JMachine.app.dto.student.CreateStudentDTO;
import org.JMachine.app.usecase.student.CreateStudentUseCase;
import org.JMachine.domain.model.student.StudentLevel;

import java.util.Scanner;

public class CreateStudentConsoleHandler extends BaseStudentConsoleHandler {

    private final CreateStudentUseCase createStudent;

    public CreateStudentConsoleHandler(CreateStudentUseCase createStudent) {
        this.createStudent = createStudent;
    }

    public void register(Scanner scan) {

        try {
            System.out.print("Nome do estudante: ");
            String name = scan.nextLine();

            System.out.print("Email do estudante: ");
            String email = scan.nextLine();

            StudentLevel level = askLevel(scan);
            if (level == null) {
                System.out.println("Nível inválido.");
                return;
            }

            CreateStudentDTO input =
                    new CreateStudentDTO(name, email, level);

            CreateStudentDTO result =
                    createStudent.execute(input);

            System.out.println(
                    "Estudante criado com sucesso: " + result.getName()
            );
        }catch (IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}

