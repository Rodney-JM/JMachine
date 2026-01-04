package org.JMachine.app;

import org.JMachine.domain.model.student.Student;
import org.JMachine.domain.model.student.StudentLevel;
import org.JMachine.domain.repository.StudentRepository;

public class CreateStudentUseCase {
    private final StudentRepository repository;

    public CreateStudentUseCase(StudentRepository r){
        this.repository = r;
    }

    public Student execute(String name, String email, StudentLevel level){
        Student student = Student.create(name, email, level);
        repository.save(student);
        return student;
    }
}
