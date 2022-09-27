package com.example.guig_number.mechanics;

public class Party {
    private int sumPoints;
    private int numTries;
    private int totalTries;
    private boolean win;

    public Party(int sumPoints, int numTries, int totalTries, boolean win) {
        this.sumPoints = sumPoints;
        this.numTries = numTries;
        this.totalTries = totalTries;
        this.win=win;
    }

    public int getSumPoints() {
        return sumPoints;
    }

    public void setSumPoints(int sumPoints) {
        this.sumPoints = sumPoints;
    }

    public int getNumTries() {
        return numTries;
    }

    public void setNumTries(int numTries) {
        this.numTries = numTries;
    }

    public int getTotalTries() {
        return totalTries;
    }

    public void setTotalTries(int totalTries) {
        this.totalTries = totalTries;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    @Override
    public String toString() {
        return "" +
                "Очков за партию: " + sumPoints +
                ", Число попыток: " + numTries +
                ", Всего попыток: " + totalTries +
                ", Выиграл=" + win;
    }


}
