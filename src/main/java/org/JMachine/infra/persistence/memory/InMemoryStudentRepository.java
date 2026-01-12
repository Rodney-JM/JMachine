package org.JMachine.infra.persistence.memory;

import org.JMachine.domain.model.student.Student;
import org.JMachine.domain.repository.StudentRepository;

import java.util.*;

public class InMemoryStudentRepository implements StudentRepository {
    private final Map<String, Student> students = new HashMap<>();

    @Override
    public void save(Student student){
        students.put(student.getId(), student);
    }

    @Override
    public Optional<Student> findById(String id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public Optional<Student> findByEmail(String email){
        return students.values().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public List<Student> findAll(){
        return new ArrayList<>(students.values());
    }

    @Override
    public void deleteById(String id){
        students.remove(id);
    }

    @Override
    public void deleteByEmail(String email) {
        Optional<Student> deleteStudent = Optional.ofNullable(students.values().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Estudante não encontrado.")));

        students.remove(deleteStudent.get().getId());
    }
}
