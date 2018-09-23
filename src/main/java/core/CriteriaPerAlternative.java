package core;

//criteria value per specific Alternative

public class CriteriaPerAlternative implements Comparable<CriteriaPerAlternative>{

    private int value;
    private Alternative alternative;

    public CriteriaPerAlternative(int value, Alternative alternative) {
        this.value = value;
        this.alternative = alternative;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    @Override
    public int compareTo(CriteriaPerAlternative o) {
        return this.value - o.value;
    }
}
