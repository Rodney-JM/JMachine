package org.JMachine.domain.model.student;

public class Email {
    private final String value;

    public Email(String value){
        if(value == null || !value.contains("@")){
            throw new IllegalArgumentException("Insira um formato de email aceitável por gentileza");
        }

        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
