package org.JMachine.domain.model.exercise;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Exercise {
    private final String id;
    private String title;
    private String description;
    private ExerciseDifficulty difficulty;
    private String topic;
    List<Question> questions;

    public Exercise(String id, String title, String description, ExerciseDifficulty difficulty,
                    String topic, List<Question> questions){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID não pode ser vazio");
        }

        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Título não pode ser vazio");
        }

        if(difficulty == null){
            throw new IllegalArgumentException("Dificuldade não pode ser nula");
        }

        if(questions == null || questions.isEmpty()){
            throw new IllegalArgumentException("Exercício precisa ter pelo menos uma questão");
        }

        this.id = id;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.topic = topic;
        this.questions = questions;
    }

    //Factory method
    public static Exercise create(String title, String description,
                                  ExerciseDifficulty difficulty, String topic, List<Question> questions){
        String id = UUID.randomUUID().toString();
        return new Exercise(id, title, description, difficulty, topic, questions);
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    }

    public void removeQuestion(String id){
        this.questions.removeIf(q -> q.getId().equals(id));
    }

    public int getTotalQuestions(){
        return questions.size();
    }

    public Question getQuestionById(String questionId){
        return questions.stream()
                .filter(q -> q.getId().equals(questionId))
                .findFirst()
                .orElse(null);
    }

    public ExerciseDifficulty getDifficulty() {
        return difficulty;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDifficulty(ExerciseDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("O título não pode estar vazio");
        }
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(id, exercise.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", difficulty=" + difficulty +
                ", topic='" + topic + '\'' +
                ", questions=" + questions +
                '}';
    }
}
