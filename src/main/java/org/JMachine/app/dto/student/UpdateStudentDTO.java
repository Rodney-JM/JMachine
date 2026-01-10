package org.JMachine.app.dto.student;

import org.JMachine.domain.model.student.StudentLevel;

public class UpdateStudentDTO {
    private final String name;
    private final StudentLevel level;

    public UpdateStudentDTO(String name, StudentLevel level){
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public StudentLevel getLevel() {
        return level;
    }
}
