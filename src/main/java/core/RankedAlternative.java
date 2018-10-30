package core;

public class RankedAlternative  {

    private Alternative alternative;
    private double criteriaCounted;
    private int rank;

    public RankedAlternative(  Alternative alternative, double criteriaCounted, int rank) {

        this.alternative = alternative;
        this.criteriaCounted = criteriaCounted;
        this.rank = rank;
    }

    public double getCriteriaCounted() {
        return criteriaCounted;
    }

    public void setCriteriaCounted(double criteriaCounted) {
        this.criteriaCounted = criteriaCounted;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }
}
