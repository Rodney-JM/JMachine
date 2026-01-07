package org.JMachine.app.usecase.student;

import org.JMachine.app.dto.student.UpdateStudentDTO;
import org.JMachine.app.validator.StudentDTOValidator;
import org.JMachine.domain.model.student.Student;
import org.JMachine.domain.model.student.StudentLevel;
import org.JMachine.domain.repository.StudentRepository;

import java.util.List;

public class UpdateStudentUseCase {
    private final StudentRepository repository;

    public UpdateStudentUseCase(StudentRepository r){
        this.repository = r;
    }

    public Student execute(String id, UpdateStudentDTO studentDTO){
        Student student = repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Aluno não encontrado"));

        List<String> errors = StudentDTOValidator.validar(studentDTO);

        if(!errors.isEmpty()) {
            throw new IllegalArgumentException("Errors: " + String.join(", ", errors));
        }

        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setLevel(studentDTO.getLevel());

        repository.save(student);
        return student;
    }
}
