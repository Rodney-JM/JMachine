package org.JMachine.presentation.exercise;

import org.JMachine.app.dto.exercise.CreateExerciseDTO;
import org.JMachine.app.usecase.exercise.CreateExerciseUseCase;
import org.JMachine.domain.model.exercise.Exercise;
import org.JMachine.domain.model.exercise.ExerciseDifficulty;
import org.JMachine.domain.model.exercise.Question;

import java.util.List;
import java.util.Scanner;

public class CreateExerciseConsoleHandler extends BaseExerciseConsoleHandler {
    private final CreateExerciseUseCase createExerciseUseCase;

    public CreateExerciseConsoleHandler(CreateExerciseUseCase exerciseUseCase){
        this.createExerciseUseCase = exerciseUseCase;
    }

    public void register(Scanner scan){
        try{
            System.out.println("======= CADASTRAR EXERCÍCIO =======");
            System.out.println("Digite o título do exercício a seguir: ");
            String title = scan.nextLine();

            System.out.println("Agora insira o enunciado: ");
            String description = scan.nextLine();

            ExerciseDifficulty difficulty = askLevel(scan);

            if(difficulty ==null){
                System.out.println("Dificuldade inválida, operação cancelada...");
                return;
            }
            System.out.println("Insira o tópico pelo qual o exercício percorre: ");
            String topic = scan.nextLine();

            List<Question> questions = receiveQuestions(scan);

            createExerciseUseCase.execute(new CreateExerciseDTO(title, description, difficulty, topic, questions));
        }catch(IllegalArgumentException e){
            System.out.println("Erro, insira os dados corretamente: " + e);
        }catch (Exception e){
            System.out.println("Erro: " + e);
        }
    }
}
