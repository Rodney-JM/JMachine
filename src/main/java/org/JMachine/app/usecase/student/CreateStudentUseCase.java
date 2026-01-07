package org.JMachine.app.usecase.student;

import org.JMachine.app.dto.student.CreateStudentDTO;
import org.JMachine.domain.model.student.Student;
import org.JMachine.domain.model.student.StudentLevel;
import org.JMachine.domain.repository.StudentRepository;

public class CreateStudentUseCase {
    private final StudentRepository repository;

    public CreateStudentUseCase(StudentRepository r){
        this.repository = r;
    }

    public CreateStudentDTO execute(CreateStudentDTO createStudentDTO){
        Student student = Student.create(createStudentDTO.getName(), createStudentDTO.getEmail(), createStudentDTO.getLevel());
        repository.save(student);
        return new CreateStudentDTO(student.getName(), student.getEmail(), student.getLevel());
    }
}
