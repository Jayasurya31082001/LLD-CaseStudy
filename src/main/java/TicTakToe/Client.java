package TicTakToe;

import TicTakToe.Controllers.GameController;
import TicTakToe.Models.*;
import TicTakToe.Strategies.ColumnWinningStrategies;
import TicTakToe.Strategies.DiagonalWinningStrategies;
import TicTakToe.Strategies.GameWinningStrategies;
import TicTakToe.Strategies.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTakTOE Game!!!!!!");
        System.out.println("Enter the board size: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(1,"Jayasurya",new Symbol("X"), PlayerType.HUMAN));
        players.add(new BotPlayer(2,"Hari",new Symbol("O"),PlayerType.BOT,BotDifficultyLevel.EASY));

        List<GameWinningStrategies> gameWinningStrategies = new ArrayList<>();
        gameWinningStrategies.add(new RowWinningStrategy());
        gameWinningStrategies.add(new ColumnWinningStrategies());
        gameWinningStrategies.add(new DiagonalWinningStrategies());

        GameController gameController = new GameController();

        Game game = gameController.openNewGame(size,players,gameWinningStrategies);
        gameController.startGame(game);
    }
}
