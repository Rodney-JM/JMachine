package org.JMachine;

import org.JMachine.app.CreateStudentUseCase;
import org.JMachine.domain.model.student.Student;
import org.JMachine.domain.model.student.StudentLevel;
import org.JMachine.domain.repository.StudentRepository;
import org.JMachine.infra.persistence.memory.InMemoryStudentRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new InMemoryStudentRepository();

        CreateStudentUseCase createStudentUseCase = new CreateStudentUseCase(repository);

        Student student = createStudentUseCase.execute(
                "João da Silva",
                "joao@email.com",
                StudentLevel.BEGGINNER
        );

        System.out.println("Aluno Criado: " + student);
    }
}