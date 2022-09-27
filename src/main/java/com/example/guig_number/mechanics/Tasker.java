package com.example.guig_number.mechanics;

import java.util.Random;

public class Tasker {
    //Искомое число
    private int taskNumber;

    //При создании передаем в него наш Mode

    public Tasker(Mode mode){
        Random random=new Random();
        this.taskNumber=random.nextInt(mode.getBound());
    }

    public int generateRnd(Mode mode){
        return (int)(Math.random()*mode.getBound());
    }

    public int showNumberTask(){
        return this.taskNumber;
    }

}