package SnakeAndLadder.Models;

import java.util.Random;

public class Dice {

    private  int numberOfDice;
    private Random random;
    public Dice(int numberOfDice){
        this.numberOfDice=numberOfDice;
        random= new Random();
    }
    public  int roll(){
        int sum =0;
        for(int i =0;i<numberOfDice;i++){
           sum+=random.nextInt(5)+1;
        }
        return  sum;
    }

}
