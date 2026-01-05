package org.JMachine.app.usecase.student;

import org.JMachine.domain.model.student.Student;
import org.JMachine.domain.repository.StudentRepository;

import java.util.List;

public class ListAllStudentsUseCase {
    private final StudentRepository repository;

    public ListAllStudentsUseCase(StudentRepository r){
        this.repository = r;
    }

    public List<Student> execute(){
        return repository.findAll();
    }
}
