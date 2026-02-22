package org.JMachine.presentation.exercise;

import org.JMachine.domain.model.exercise.ExerciseDifficulty;
import org.JMachine.domain.model.exercise.Question;
import org.JMachine.domain.model.exercise.QuestionType;
import org.JMachine.domain.service.GroqService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class BaseExerciseConsoleHandler {
    private final GroqService groqService;

    public BaseExerciseConsoleHandler(){
        this.groqService = new GroqService();

        if(!groqService.isAvailable()){
            System.out.println("IA não configurada. Configure GROQ API Key");
        }
    }

    protected ExerciseDifficulty askLevel(Scanner scan){
        System.out.println("""
                Digite o número correspondente a dificuldade do exercício:
                1 - Fácil
                2 - Médio
                3 - Difícil
                """);

        return switch (scan.nextLine()){
            case "1" -> ExerciseDifficulty.EASY;
            case "2" -> ExerciseDifficulty.MEDIUM;
            case "3" -> ExerciseDifficulty.HARD;
            default -> null;
        };
    }

    protected List<Question> receiveQuestions(Scanner scan) throws Exception {
        List<Question> questionList = new ArrayList<>();

        String questionsNum;
        try{
            System.out.println("Digite o número de questões que o exercicio possui: ");
            questionsNum = scan.nextLine();
            if(Integer.parseInt(questionsNum)<=0){
                System.out.println("Deve haver somente uma questão");
                return new ArrayList<>();
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error: " + e);
        }
        for(int i = 0; i< Integer.parseInt(questionsNum); i++){
            Question question = createQuestion(scan);

            if(question ==null){
                System.out.println("Questão inválida");
                i--;
                continue;
            }
            questionList.add(question);
        }

        return questionList;
    }

    protected Question createQuestion(Scanner scan) throws Exception {
        System.out.println("===== Crie sua questão =====");
        System.out.println("Digite o número da questão: ");

        String number = scan.nextLine();
        if(number==null || number.isBlank()){
            System.out.println("Digite um número válido...");
            return null;
        }

        System.out.println("Digite o enunciado da questão: ");
        String text = scan.nextLine();

        QuestionType questionType = askQuestionType(scan);
        if(questionType ==null){
            throw new NumberFormatException("Digite um número válido.");
        }

        if(questionType.equals(QuestionType.MULTIPLE_CHOICE)){
             List<String> alternatives = alternatives(scan);
             String correctAnswer = groqService.identifyCorrectAnswer(text, alternatives);

            System.out.println(correctAnswer);
            System.out.println("A resposta da IA está correta? S/N");

            String iaIsCorrect = scan.nextLine();
            if(iaIsCorrect.equalsIgnoreCase("N")){
                System.out.println("Então digite a alternativa correta: ");
                correctAnswer = scan.nextLine();
            }else if(iaIsCorrect.equalsIgnoreCase("S")){
                System.out.println("Obrigado pela resposta, sua questão será criada para futuras consultas");
            }

             return Question.createMultipleChoice(number, text, correctAnswer, alternatives);
        }else if (questionType.equals(QuestionType.OPEN_ENDED)){
            System.out.println("Qual é a resposta correta da questão? ");
            String correctAnswer = scan.nextLine();
            return Question.createOpenEnded(number, text, correctAnswer);
        }
        return null;
    }

    private QuestionType askQuestionType(Scanner scan){
        System.out.println("""
                Digite qual é o tipo de questão:
                
                1 - Múltipla escolha
                2 - Dissertativa
                """);

        return switch (scan.nextLine()){
            case "1" -> QuestionType.MULTIPLE_CHOICE;
            case "2" -> QuestionType.OPEN_ENDED;
            default -> null;
        };
    }

    private List<String> alternatives(Scanner scanner){
        List<String> alternatives = new ArrayList<>();
        System.out.println("Quantas alternativas essa questão possui?");
        String alternativesNum = scanner.nextLine();
        if(alternativesNum==null || alternativesNum.isBlank()){
            throw new NumberFormatException("Digite um número válido");
        }

        for(int i = 0; i< Integer.parseInt(alternativesNum); i++){
            System.out.println("Digite a alternativa a seguir: ");
            String alternative = scanner.nextLine();
            if(alternative.isBlank()){
                System.out.println("Erro, digite uma alternativa válida...");
                --i;
                continue;
            }

            alternatives.add(alternative);
        }

        return alternatives;
    }
}
