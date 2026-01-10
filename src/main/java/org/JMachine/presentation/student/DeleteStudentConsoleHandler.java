package org.JMachine.presentation.student;

import org.JMachine.app.usecase.student.DeleteStudentUseCase;

public class DeleteStudentConsoleHandler {
    private final DeleteStudentUseCase deleteStudentUseCase;

    public DeleteStudentConsoleHandler(DeleteStudentUseCase deleteStudentUseCase){
        this.deleteStudentUseCase = deleteStudentUseCase;
    }

    public void delete(String email){
        try{
            deleteStudentUseCase.execute();
        }
    }
}
