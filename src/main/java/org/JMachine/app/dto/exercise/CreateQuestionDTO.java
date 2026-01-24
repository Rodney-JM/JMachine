package org.JMachine.app.dto.exercise;

import org.JMachine.domain.model.exercise.QuestionType;

import java.util.List;

public class CreateQuestionDTO {
    private String number;
    private String text;
    private String correctAnswer;
    private List<String> alternatives;
    private QuestionType type;

    public CreateQuestionDTO(String number, String text, String correctAnswer, List<String> alternatives, QuestionType type) {
        this.number = number;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.alternatives = alternatives;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getAlternatives() {
        return alternatives;
    }

    public QuestionType getType() {
        return type;
    }
}
