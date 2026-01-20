package org.JMachine.app.usecase.exercise;

import org.JMachine.app.dto.exercise.CreateExerciseDTO;
import org.JMachine.domain.model.exercise.Exercise;
import org.JMachine.domain.repository.ExerciseRepository;

public class CreateExerciseUseCase {
    private final ExerciseRepository repository;

    public CreateExerciseUseCase(ExerciseRepository exerciseRepository){ this.repository = exerciseRepository; }

    public CreateExerciseDTO execute(CreateExerciseDTO exerciseDTO){
        Exercise exercise = Exercise.create(exerciseDTO.getTitle(), exerciseDTO.getDescription(), exerciseDTO.getDifficulty(),exerciseDTO.getTopic() ,  exerciseDTO.getQuestions());
        repository.save(exercise);
        return new CreateExerciseDTO(exercise.getTitle(), exercise.getDescription(), exercise.getDifficulty(), exercise.getTopic(), exercise.getQuestions());
    }
}
