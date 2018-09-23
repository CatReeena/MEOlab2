package core;

import java.util.ArrayList;
import java.util.List;

//Alternatives with conditions(in the right order) and criteria type

public class AlternativeCase {

    private ArrayList<Alternative> alternatives;
    private ArrayList<String> conditions;
    private int criteriaType;

    public AlternativeCase(ArrayList<Alternative> alternatives, ArrayList<String> conditions, int criteriaType) {
        this.alternatives = alternatives;
        this.conditions = conditions;
        this.criteriaType = criteriaType;
    }

    public ArrayList<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(ArrayList<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public ArrayList<String> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<String> conditions) {
        this.conditions = conditions;
    }

    public int getCriteriaType() {
        return criteriaType;
    }

    public void setCriteriaType(int criteriaType) {
        this.criteriaType = criteriaType;
    }
}
