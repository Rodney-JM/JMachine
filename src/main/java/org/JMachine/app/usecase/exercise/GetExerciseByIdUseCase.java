package org.JMachine.app.usecase.exercise;

import org.JMachine.domain.model.exercise.Exercise;
import org.JMachine.domain.repository.ExerciseRepository;

public class GetExerciseByIdUseCase {
    private final ExerciseRepository repository;

    public GetExerciseByIdUseCase(ExerciseRepository repository){
        this.repository = repository;
    }

    public Exercise execute(String id){
        return repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Usuário não encontrado"));
    }
}
