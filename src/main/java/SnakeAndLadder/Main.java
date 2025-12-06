package SnakeAndLadder;

import SnakeAndLadder.Exceptions.IllegalLadderIndexException;
import SnakeAndLadder.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the board size:");
        int boardSize= sc.nextInt();
        System.out.println("Enter the number of dice:");
        int numberOfDice= sc.nextInt();
        List<Player> players = new ArrayList<>();
       players.add(new Player("hari"));
       players.add(new Player("Anu"));

        List<Ladder> ladders = new ArrayList<>();

        ladders.add(new Ladder(2,4));
        ladders.add(new Ladder(24,86));
        ladders.add(new Ladder(67,88));

        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(54,3));
        snakes.add(new Snake(95,2));
        snakes.add(new Snake(43,38));



        Board board =new Board(boardSize,players,ladders,snakes);
        Dice dice = new Dice(numberOfDice) ;
        Game game  = new Game(board,dice);
        game.startGame();
    }
}
