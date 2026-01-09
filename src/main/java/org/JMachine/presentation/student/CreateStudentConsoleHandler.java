package org.JMachine.presentation.student;

import org.JMachine.app.dto.student.CreateStudentDTO;
import org.JMachine.app.usecase.student.CreateStudentUseCase;
import org.JMachine.domain.model.student.StudentLevel;

import java.util.Scanner;

public class CreateStudentConsoleHandler {

    private final CreateStudentUseCase createStudent;

    public CreateStudentConsoleHandler(CreateStudentUseCase createStudent) {
        this.createStudent = createStudent;
    }

    public void register(Scanner scan) {

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
    }

    private StudentLevel askLevel(Scanner scan) {
        System.out.println("""
                Escolha o nível do estudante:
                1 - Iniciante
                2 - Intermediário
                3 - Avançado
                """);

        return switch (scan.nextLine()) {
            case "1" -> StudentLevel.BEGGINNER;
            case "2" -> StudentLevel.INTERMEDIATE;
            case "3" -> StudentLevel.ADVANCED;
            default -> null;
        };
    }
}

