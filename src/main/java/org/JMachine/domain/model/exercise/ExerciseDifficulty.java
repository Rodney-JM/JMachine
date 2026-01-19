package org.JMachine.domain.model.exercise;

public enum ExerciseDifficulty {
    EASY("fácil"),
    MEDIUM("médio"),
    HARD("difícil");

    private final String displayName;

    ExerciseDifficulty(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
