package com.example.guig_number.mechanics;

public enum Difficulty {
    EASY(1),
    MEDIUM(4),
    HARD(8),
    IMPOSSIBLE(16);


    private int value;

    private Difficulty(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }







}
