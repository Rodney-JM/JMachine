package org.JMachine.domain.model.exercise;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Question {
    private final String id;
    private String number;
    private String text;
    private String correctAnswer;
    private List<String> alternatives;
    private QuestionType type;

    public Question(String id, String number, String text, String correctAnswer,
                    List<String> alternatives, QuestionType type
                    ){
        if(id ==null || id.isBlank()){
            throw new IllegalArgumentException("O ID não pode ser vazio");
        }

        if(number == null || number.isBlank()){
            throw new IllegalArgumentException("O número da questão deve ser preenchido devidamente");
        }

        if(text == null || text.isBlank()){
            throw new IllegalArgumentException("O campo de texto não pode estar vazio");
        }

        if(correctAnswer == null || correctAnswer.isBlank()){
            throw new IllegalArgumentException("Se deve inserir a resposta correta da questão");
        }

        this.id = id;
        this.text = text;
        this.number = number;
        this.correctAnswer = correctAnswer;
        this.alternatives = alternatives;
        this.type = type;
    }

    //factory method
    public static Question createOpenEnded(String text, String correctAnswer, String number){
        String id = UUID.randomUUID().toString();
        return new Question(id, text, number,  correctAnswer, null, QuestionType.OPEN_ENDED);
    }

    //factory method for multiple choice questions
    public static Question createMultipleChoice(String text, String correctAnswer, String number, List<String> alternatives){
        String id = UUID.randomUUID().toString();
        return new Question(id, text, number, correctAnswer, alternatives, QuestionType.MULTIPLE_CHOICE);
    }

    public String getId() {
        return id;
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

    //setters
    public void setNumber(String number) {
        if(number == null || number.isBlank()){
            throw new IllegalArgumentException("Para modificar o número, digite um valor válido");
        }
        this.number = number;
    }

    public void setText(String text) {
        if(text == null || text.isBlank()){
            throw new IllegalArgumentException("Para modificar o texto, digite um valor válido");
        }
        this.text = text;
    }

    public void setCorrectAnswer(String correctAnswer) {
        if(correctAnswer == null || correctAnswer.isBlank()){
            throw new IllegalArgumentException("Para modificar a resposta correta, digite um valor válido");
        }
        this.correctAnswer = correctAnswer;
    }

    public void setAlternatives(List<String> alternatives) {
        this.alternatives = alternatives;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", text='" + text + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", alternatives=" + alternatives +
                ", type=" + type +
                '}';
    }
}
