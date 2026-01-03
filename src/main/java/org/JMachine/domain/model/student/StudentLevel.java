package org.JMachine.domain.model.student;

public enum StudentLevel {
    BEGGINNER("Iniciante", 1),
    INTERMEDIATE("Intermediário", 2),
    ADVANCED("Avançado", 3);

    private final String displayName;
    private final int order;

    StudentLevel(String displayName, int order) {
        this.displayName = displayName;
        this.order = order;
    }

    public String getDisplayName(){
        return displayName;
    }

    public int getOrder(){
        return order;
    }

    public boolean canProgressTo(StudentLevel nextLevel){
        return nextLevel.order > this.order;
    }

    public StudentLevel next(){
        switch (this){
            case BEGGINNER: return INTERMEDIATE;
            case INTERMEDIATE: return ADVANCED;
            case ADVANCED: return ADVANCED;
            default: return this;
        }
    }
}
