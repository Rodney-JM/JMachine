package org.JMachine.infra.config;

import org.JMachine.app.usecase.exercise.CreateExerciseUseCase;
import org.JMachine.domain.repository.ExerciseRepository;
import org.JMachine.infra.persistence.memory.InMemoryExerciseRepository;
import org.JMachine.presentation.exercise.CreateExerciseConsoleHandler;

public class ExerciseConfig {
    // Singleton -> simular um banco de dados
    private static final ExerciseRepository repository = new InMemoryExerciseRepository();

    //Injeçoes de dependencia manual
    public static CreateExerciseConsoleHandler exerciseHandler(){
        CreateExerciseUseCase createExerciseUseCase = new CreateExerciseUseCase(repository);

        return new CreateExerciseConsoleHandler(createExerciseUseCase);
    }
}
