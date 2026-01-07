package org.JMachine.infra.config;

import org.JMachine.app.usecase.student.CreateStudentUseCase;
import org.JMachine.domain.repository.StudentRepository;
import org.JMachine.infra.persistence.memory.InMemoryStudentRepository;
import org.JMachine.presentation.StudentConsoleHandler;

public class StudentConfig {
    public static StudentConsoleHandler studentHandler(){
        StudentRepository repository = new InMemoryStudentRepository();

        CreateStudentUseCase createStudentUseCase = new CreateStudentUseCase(repository);

        return new StudentConsoleHandler(createStudentUseCase);
    }
}
