package core;

import java.util.ArrayList;

public class RankedAlternativeCase {

    private ArrayList<RankedAlternative> rankedAlternatives;
    private ArrayList<String> conditions;
    private int criteriaType;

    public RankedAlternativeCase(ArrayList<RankedAlternative> rankedAlternatives, ArrayList<String> conditions, int criteriaType) {
        this.rankedAlternatives = rankedAlternatives;
        this.conditions = conditions;
        this.criteriaType = criteriaType;
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

    public ArrayList<RankedAlternative> getRankedAlternatives() {
        return rankedAlternatives;
    }

    public void setRankedAlternatives(ArrayList<RankedAlternative> rankedAlternatives) {
        this.rankedAlternatives = rankedAlternatives;
    }
}
