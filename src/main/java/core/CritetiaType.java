package core;

public enum CritetiaType {

    VALD(0),
    MAXMAX(1),
    HURWITZ(2),
    REGRET(3),
    LAPLAS(4);


    private final int index;

    CritetiaType(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}