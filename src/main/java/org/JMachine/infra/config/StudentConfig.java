package org.JMachine.infra.config;

import org.JMachine.app.usecase.student.CreateStudentUseCase;
import org.JMachine.app.usecase.student.ListAllStudentsUseCase;
import org.JMachine.domain.repository.StudentRepository;
import org.JMachine.infra.persistence.memory.InMemoryStudentRepository;
import org.JMachine.presentation.student.CreateStudentConsoleHandler;
import org.JMachine.presentation.student.ListStudentConsoleHandler;

public class StudentConfig {
    private static final StudentRepository repository = new InMemoryStudentRepository();

    public static CreateStudentConsoleHandler studentHandler(){
        CreateStudentUseCase createStudentUseCase = new CreateStudentUseCase(repository);

        return new CreateStudentConsoleHandler(createStudentUseCase);
    }

    public static ListStudentConsoleHandler listStudentHandler(){
        ListAllStudentsUseCase listAllStudentsUseCase = new ListAllStudentsUseCase(repository);

        return new ListStudentConsoleHandler(listAllStudentsUseCase);
    }
}
