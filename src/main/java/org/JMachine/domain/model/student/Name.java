package org.JMachine.domain.model.student;

public class Name {
    private final String value;

    public Name(String value){
        if(value== null || value.isBlank()){
            throw new IllegalArgumentException("Por favor, insira um nome válido");
        }

        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
