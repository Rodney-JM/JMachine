package org.JMachine.infra.config;

import org.JMachine.app.usecase.student.CreateStudentUseCase;
import org.JMachine.app.usecase.student.DeleteStudentUseCase;
import org.JMachine.app.usecase.student.ListAllStudentsUseCase;
import org.JMachine.app.usecase.student.UpdateStudentUseCase;
import org.JMachine.domain.repository.StudentRepository;
import org.JMachine.infra.persistence.memory.InMemoryStudentRepository;
import org.JMachine.presentation.student.CreateStudentConsoleHandler;
import org.JMachine.presentation.student.DeleteStudentConsoleHandler;
import org.JMachine.presentation.student.ListStudentConsoleHandler;
import org.JMachine.presentation.student.UpdateStudentConsoleHandler;

public class StudentConfig {
    //Singleton -> simular um banco de dados
    private static final StudentRepository repository = new InMemoryStudentRepository();

    //Injeções de depedência feitas de forma manual
    public static CreateStudentConsoleHandler studentHandler(){
        CreateStudentUseCase createStudentUseCase = new CreateStudentUseCase(repository);

        return new CreateStudentConsoleHandler(createStudentUseCase);
    }

    public static ListStudentConsoleHandler listStudentHandler(){
        ListAllStudentsUseCase listAllStudentsUseCase = new ListAllStudentsUseCase(repository);

        return new ListStudentConsoleHandler(listAllStudentsUseCase);
    }

    public static UpdateStudentConsoleHandler updateStudentHandler(){
        UpdateStudentUseCase updateStudentUseCase = new UpdateStudentUseCase(repository);
        return new UpdateStudentConsoleHandler(updateStudentUseCase);
    }

    public static DeleteStudentConsoleHandler deleteStudentHandler(){
        DeleteStudentUseCase deleteStudentUseCase = new DeleteStudentUseCase(repository);
        return new DeleteStudentConsoleHandler(deleteStudentUseCase);
    }
}
