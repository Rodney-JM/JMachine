package org.JMachine.presentation.student;

import org.JMachine.app.dto.student.CreateStudentDTO;
import org.JMachine.app.usecase.student.ListAllStudentsUseCase;

import java.util.List;

public class ListStudentConsoleHandler {
    private final ListAllStudentsUseCase listAllStudentsUseCase;

    public ListStudentConsoleHandler(ListAllStudentsUseCase allStudentsUseCase){
        this.listAllStudentsUseCase = allStudentsUseCase;
    }

    public void showAll(){
        List<CreateStudentDTO> students = listAllStudentsUseCase.execute().stream()
                .map(student -> new CreateStudentDTO(student.getName(), student.getEmail(), student.getLevel()))
                .toList();

        for(CreateStudentDTO s : students){
            System.out.println(s.getName());
        }
    }
}
