package org.JMachine.app.usecase.student;

import org.JMachine.domain.repository.StudentRepository;

public class DeleteStudentUseCase {
    private final StudentRepository repository;

    public DeleteStudentUseCase(StudentRepository r){
        this.repository = r;
    }

    public void executeById(String id){
        repository.deleteById(id);
    }

    public void executeByEmail(String email) { repository.deleteByEmail(email); }
}
