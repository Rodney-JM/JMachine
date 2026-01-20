package org.JMachine.app.usecase.exercise;

import org.JMachine.domain.model.exercise.Exercise;
import org.JMachine.domain.repository.ExerciseRepository;

import java.util.List;

public class ListAllExercisesUseCase {
    private final ExerciseRepository repository;

    public ListAllExercisesUseCase(ExerciseRepository repository){
        this.repository = repository;
    }

    public List<Exercise> execute(){
        return repository.findAll();
    }
}
