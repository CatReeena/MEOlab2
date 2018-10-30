package core;

//criteria value per specific Alternative

public class CriteriaPerAlternative implements Comparable<CriteriaPerAlternative>{

    private double value;
    private Alternative alternative;

    public CriteriaPerAlternative(double value, Alternative alternative) {
        this.value = value;
        this.alternative = alternative;
    }

    public double getValue() {
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
        int result = 0;
        if(this.value - o.value > 0){
            result = 1;
        }
        else if(this.value - o.value < 0){
            result = -1;
        }
        else if(this.value - o.value == 0){
            result = 0;
        }
        return result;
    }
}
