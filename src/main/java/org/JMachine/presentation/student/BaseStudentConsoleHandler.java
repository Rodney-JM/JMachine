package org.JMachine.presentation.student;

import org.JMachine.domain.model.student.StudentLevel;

import java.util.Scanner;

public abstract class BaseStudentConsoleHandler {
    protected StudentLevel askLevel(Scanner scan) {
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
