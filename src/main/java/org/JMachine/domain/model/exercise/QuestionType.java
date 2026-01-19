package org.JMachine.domain.model.exercise;

public enum QuestionType {
    MULTIPLE_CHOICE("Múltipla Escolha"),
    OPEN_ENDED("Dissertativa");

    private final String displayName;

    QuestionType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName
    }
}
