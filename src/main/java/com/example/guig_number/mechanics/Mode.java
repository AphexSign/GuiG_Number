package com.example.guig_number.mechanics;

//Режим игры - Сложность и диапазон
public class Mode {
    private Range range;
    private Difficulty difficult;
    private int tryCount;

    public Mode(Range range, Difficulty difficult){
        this.range=range;
        this.difficult=difficult;
        //Создаем количество попыток на основе сложности и диапозона
        this.tryCount=tryGenerate(range,difficult);
    }

    private int tryGenerate(Range range, Difficulty difficulty){
        //Определяемся с базовым коэффицентом решения по бинарному поиску
        int binarySearchCoeff=0;
        int tmp=0;

        switch (range){
            case TEN:
                binarySearchCoeff=4;
                break;
            case HUNDRED:
                binarySearchCoeff=7;
                break;
            case THOUSAND:
                binarySearchCoeff=10;
                break;
            case TENTHOUSAND:
                binarySearchCoeff=14;
                break;
        }


        switch (difficulty){
            case EASY:                 //Легкая сложность
                tmp=(int)Math.round(binarySearchCoeff*1.2);
                break;
            case MEDIUM:
                tmp=(binarySearchCoeff);
                break;           //Средняя сложность
            case HARD:
                tmp=(int)Math.round(binarySearchCoeff*0.7);
                break;           //Тяжелая сложность
            case IMPOSSIBLE:
                tmp=(int)Math.round(binarySearchCoeff*0.5);
                break;           //Невозможная сложность
        }
        return tmp;

    }

    @Override
    public String toString() {
        return "Режим игры{" +
                "Диапазон=" + range +
                ", Сложность=" + difficult +
                ", Число попыток=" + tryCount +
                '}';
    }

    public int getBound(){
        return this.range.getValue();
    }
    public int getTryCount(){
        return this.tryCount;
    }

    public Range getRange(){
        return this.range;
    }


    public Difficulty getDifficult(){
        return this.difficult;
    }



}

