package org.JMachine.app.dto.exercise;

import org.JMachine.domain.model.exercise.ExerciseDifficulty;
import org.JMachine.domain.model.exercise.Question;

import java.util.List;

public class CreateExerciseDTO {
    private final String title;
    private final String description;
    private final ExerciseDifficulty difficulty;
    private final String topic;
    private final List<Question> questions;

    public CreateExerciseDTO(String title, String description, ExerciseDifficulty difficulty, String topic, List<Question> questions){
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.topic = topic;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ExerciseDifficulty getDifficulty() {
        return difficulty;
    }

    public String getTopic() {
        return topic;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
