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
    public List<Student> findAll(){
        return new ArrayList<>(students.values());
    }

    @Override
    public void delete(String id){
        students.remove(id);
    }
}
