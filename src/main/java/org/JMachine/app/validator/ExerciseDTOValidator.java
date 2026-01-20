package org.JMachine.app.validator;

import org.JMachine.app.dto.exercise.UpdateExerciseDTO;

import java.util.ArrayList;
import java.util.List;

public class ExerciseDTOValidator {
    public static List<String> validate(UpdateExerciseDTO updateExerciseDTO){
        List<String> errors = new ArrayList<>();

        if(updateExerciseDTO.getDescription() == null  || updateExerciseDTO.getDescription().isBlank()){
            errors.add("A descrição não pode estar vazia");
        }

        if(updateExerciseDTO.getDifficulty() == null){
            errors.add("Selecione uma dificuldade por gentileza");
        }

        if(updateExerciseDTO.getQuestions().isEmpty()){
            errors.add("É preciso adicionar ao menos uma questão");
        }

        return errors;
    }
}
