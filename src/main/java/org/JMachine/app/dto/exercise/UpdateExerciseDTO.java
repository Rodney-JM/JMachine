package org.JMachine.app.dto.exercise;

import org.JMachine.domain.model.exercise.ExerciseDifficulty;
import org.JMachine.domain.model.exercise.Question;

import java.util.List;

public class UpdateExerciseDTO {
    private final String title;
    private final String description;
    private final ExerciseDifficulty difficulty;
    private final String topic;
    private final List<Question> questions;

    public UpdateExerciseDTO(String title, String description, ExerciseDifficulty difficulty, String topic, List<Question> questions) {
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.topic = topic;
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getTopic() {
        return topic;
    }

    public ExerciseDifficulty getDifficulty() {
        return difficulty;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
