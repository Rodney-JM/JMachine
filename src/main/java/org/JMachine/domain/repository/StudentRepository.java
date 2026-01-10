package org.JMachine.domain.repository;

import org.JMachine.domain.model.student.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void save(Student student);
    Optional<Student> findById(String id);
    Optional<Student> findByEmail(String email);
    List<Student> findAll();
    void deleteById(String id);
    void deleteByEmail(String email);
}
