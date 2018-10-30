package core;

import java.util.ArrayList;

public class Alternative implements Comparable<Alternative>{

    private int serialNumber;
    private String name;
    private ArrayList<Double> scores;

    public Alternative(int serialNumber, String name, ArrayList<Double> scores) {
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

    public ArrayList<Double> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Double> scores) {
        this.scores = scores;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public int compareTo(Alternative o) {
        return this.serialNumber - o.serialNumber;
    }
}
