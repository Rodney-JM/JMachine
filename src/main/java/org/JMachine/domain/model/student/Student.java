package org.JMachine.domain.model.student;

import java.util.Objects;
import java.util.UUID;

public class Student {
    private final String id;
    private Name name;
    private Email email;
    private StudentLevel level;

    public Student(String id, String name, String email, StudentLevel level) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("O id não pode ser vazio");
        }
        if(level == null){
            throw new IllegalArgumentException("Level não pode ser nulo");
        }

        this.id = id;
        this.name = new Name(name);
        this.email = new Email(email);
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

    public String getName(){
        return this.name.getValue();
    }

    public void setName(String name) {
        this.name = new Name(name);
    }

    public String getEmail(){
        return this.email.getValue();
    }

    public void setEmail(String email) {
        this.email = new Email(email);
    }

    public StudentLevel getLevel() {
        return level;
    }

    public void setLevel(StudentLevel level) {
        if(level == null){
            throw new IllegalArgumentException("o level é incompatível");
        }

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
                ", name='" + name.getValue() + '\'' +
                ", email='" + email.getValue() + '\'' +
                ", level=" + level +
                '}';
    }
}
