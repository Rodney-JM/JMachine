package org.JMachine.presentation.student;

import org.JMachine.app.dto.student.CreateStudentDTO;
import org.JMachine.app.usecase.student.ListAllStudentsUseCase;
import org.JMachine.domain.model.student.Student;

import java.util.List;

public class ListStudentConsoleHandler {
    private final ListAllStudentsUseCase listAllStudentsUseCase;

    public ListStudentConsoleHandler(ListAllStudentsUseCase allStudentsUseCase){
        this.listAllStudentsUseCase = allStudentsUseCase;
    }

    public void showAll(){
        List<Student> students = listAllStudentsUseCase.execute();

        System.out.println("======================");
        System.out.println("Lista de Estudantes");
        System.out.println("======================");
        for(Student s : students){
            System.out.println(s.getName());
        }
    }
}
