package org.JMachine.app.dto.student;

import org.JMachine.domain.model.student.StudentLevel;

public class CreateStudentDTO {
    private final String name;
    private final String email;
    private final StudentLevel level;

    public CreateStudentDTO(String name, String email, StudentLevel level){
        this.name = name;
        this.email = email;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public StudentLevel getLevel() {
        return level;
    }
}
