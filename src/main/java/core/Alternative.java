package core;

import java.util.ArrayList;

public class Alternative {

    private int serialNumber;
    private String name;
    private ArrayList<Integer> scores;

    public Alternative(int serialNumber, String name, ArrayList<Integer> scores) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
