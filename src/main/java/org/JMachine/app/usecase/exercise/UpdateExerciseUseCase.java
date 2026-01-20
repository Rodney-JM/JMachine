package org.JMachine.app.usecase.exercise;

import org.JMachine.app.dto.exercise.UpdateExerciseDTO;
import org.JMachine.app.validator.ExerciseDTOValidator;
import org.JMachine.domain.model.exercise.Exercise;
import org.JMachine.domain.repository.ExerciseRepository;

import java.util.List;

public class UpdateExerciseUseCase {
    private final ExerciseRepository repository;

    public UpdateExerciseUseCase(ExerciseRepository repository){
        this.repository = repository;
    }

    public UpdateExerciseDTO execute(String title, UpdateExerciseDTO exerciseDTO){
        Exercise exercise = repository.findByTitle(title)
                .orElseThrow(()-> new IllegalArgumentException("Exercício não encontrado..."));

        List<String> errors = ExerciseDTOValidator.validate(exerciseDTO);

        if(!errors.isEmpty()){
            throw new IllegalArgumentException("Errors: " + String.join(", ", errors));
        }

        exercise.setTitle(exerciseDTO.getTitle());
        exercise.setDescription(exerciseDTO.getDescription());
        exercise.setDifficulty(exerciseDTO.getDifficulty());
        exercise.setTopic(exerciseDTO.getTopic());
        exercise.setQuestions(exerciseDTO.getQuestions());

        repository.save(exercise);

        return new UpdateExerciseDTO(exerciseDTO.getTitle(), exerciseDTO.getDescription(), exerciseDTO.getDifficulty(), exerciseDTO.getTopic(), exerciseDTO.getQuestions());
    }
}
