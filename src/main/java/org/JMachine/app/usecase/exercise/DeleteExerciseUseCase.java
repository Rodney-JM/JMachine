package org.JMachine.app.usecase.exercise;

import org.JMachine.domain.repository.ExerciseRepository;

public class DeleteExerciseUseCase {
    private final ExerciseRepository repository;

    public DeleteExerciseUseCase(ExerciseRepository repository){
        this.repository = repository;
    }

    public void executeById(String id){ repository.deleteById(id); }

    public void executeByTitle(String title) { repository.deleteByTitle(title); }
}
