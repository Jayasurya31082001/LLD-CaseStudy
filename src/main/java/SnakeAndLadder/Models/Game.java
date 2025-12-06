package SnakeAndLadder.Models;

import SnakeAndLadder.Exceptions.IllegalMaxPlayerException;

import java.util.List;

public class Game {
    private Board board;
    private Dice dice;
    private  int currentPlayerIndex;

    public  Game(Board board,Dice dice) throws IllegalMaxPlayerException {
        this.board=board;
        this.dice=dice;
        this.currentPlayerIndex=0;
    }

    public  void startGame(){
        board.setBoard();
        while (true){
             Player currentPlayer = board.getPlayers().get(currentPlayerIndex);
            int number =dice.roll()+currentPlayer.getCurrentPosition();
            if(number>board.getSize()){
                currentPlayerIndex= (currentPlayerIndex+1)%board.getPlayers().size();
                continue;
            }
           int newPosition =  board.newPosition(number);
            currentPlayer.setCurrentPosition(newPosition);
            if (newPosition==board.getSize()){
                System.out.println(currentPlayer.getName()+" won the match!");
                break;
            }

            System.out.println(currentPlayer.getName()+" moving to "+newPosition);
            currentPlayerIndex= (currentPlayerIndex+1)%board.getPlayers().size();
        }
    }


}
