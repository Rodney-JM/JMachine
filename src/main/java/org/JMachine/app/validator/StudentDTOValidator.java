package org.JMachine.app.validator;

import org.JMachine.app.dto.student.UpdateStudentDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentDTOValidator {
    public static List<String> validar(UpdateStudentDTO studentDTO){
        List<String> errors = new ArrayList<>();

        if(studentDTO.getEmail() == null || studentDTO.getEmail().isBlank() || !studentDTO.getEmail().contains("@")){
            errors.add("O email do Aluno tem que ser válido");
        }
        if(studentDTO.getName() == null || studentDTO.getName().isBlank()){
            errors.add("O Nome do Aluno tem que ser válido");
        }

        if (studentDTO.getLevel()==null){
            errors.add("O Level atual do estudante tem que ser válido");
        }

        return errors;

    }
}
