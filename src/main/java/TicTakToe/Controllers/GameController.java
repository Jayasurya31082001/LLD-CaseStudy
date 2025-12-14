package TicTakToe.Controllers;

import TicTakToe.Models.Game;
import TicTakToe.Models.Player;
import TicTakToe.Strategies.GameWinningStrategies;

import java.util.List;

public class GameController {
    public Game openNewGame(int size, List<Player> players, List<GameWinningStrategies> gameWinningStrategies){
        return  Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .setGameStrategiesList(gameWinningStrategies)
                .build();

    }

    public void displayBoard(Game game){
        game.displayBoard();
    }
    public void startGame(Game game){
        game.startGame();
    }
}
