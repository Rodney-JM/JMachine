package org.JMachine;

import org.JMachine.infra.config.ExerciseConfig;
import org.JMachine.infra.config.StudentConfig;
import org.JMachine.presentation.Console;
import org.JMachine.presentation.exercise.CreateExerciseConsoleHandler;
import org.JMachine.presentation.student.CreateStudentConsoleHandler;
import org.JMachine.presentation.student.DeleteStudentConsoleHandler;
import org.JMachine.presentation.student.ListStudentConsoleHandler;
import org.JMachine.presentation.student.UpdateStudentConsoleHandler;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CreateStudentConsoleHandler createHandler = StudentConfig.studentHandler();
        ListStudentConsoleHandler listHandler = StudentConfig.listStudentHandler();
        UpdateStudentConsoleHandler updateHandler = StudentConfig.updateStudentHandler();
        DeleteStudentConsoleHandler deleteHandler = StudentConfig.deleteStudentHandler();

        CreateExerciseConsoleHandler createExerciseHandler = ExerciseConfig.exerciseHandler();

        Console console = new Console(createHandler, listHandler, updateHandler, deleteHandler, createExerciseHandler);

        console.start();
    }
}