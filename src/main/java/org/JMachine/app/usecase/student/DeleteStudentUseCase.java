package org.JMachine.app.usecase.student;

import org.JMachine.domain.repository.StudentRepository;

public class DeleteStudentUseCase {
    private final StudentRepository repository;

    public DeleteStudentUseCase(StudentRepository r){
        this.repository = r;
    }

    public void execute(String id){
        repository.delete(id);
    }
}
