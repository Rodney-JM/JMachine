package org.JMachine.domain.model.student;

import java.util.Objects;
import java.util.UUID;

public class Student {
    private String id;
    private String name;
    private String email;
    private StudentLevel level;

    public Student(String id, String name, String email, StudentLevel level) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("O id não pode ser vazio");
        }
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if(email == null || !email.contains("@")){
            throw new IllegalArgumentException("Email inválido");
        }

        if(level == null){
            throw new IllegalArgumentException("Level não pode ser nulo");
        }

        this.id = id;
        this.name = name;
        this.email = email;
        this.level = level;
    }

    //Factory method
    public static Student create(String name, String email, StudentLevel level){
        String id = UUID.randomUUID().toString();
        return new Student(id, name, email, level);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudentLevel getLevel() {
        return level;
    }

    public void setLevel(StudentLevel level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o ==null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Student{"+
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", level=" + level +
                '}';
    }
}
