package core;

import java.util.ArrayList;

public class RankedAlternative  {

    private Alternative alternative;
    private int criteriaCounted;
    private int rank;

    public RankedAlternative(  Alternative alternative, int criteriaCounted, int rank) {

        this.alternative = alternative;
        this.criteriaCounted = criteriaCounted;
        this.rank = rank;
    }

    public int getCriteriaCounted() {
        return criteriaCounted;
    }

    public void setCriteriaCounted(int criteriaCounted) {
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
