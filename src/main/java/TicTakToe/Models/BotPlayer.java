package TicTakToe.Models;

import TicTakToe.Strategies.BotPlayerFactory;
import TicTakToe.Strategies.BotPlayerStrategies;

import java.util.List;

public class BotPlayer extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayerStrategies botPlayerStrategies;

    public BotPlayer(int id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        BotPlayerFactory botPlayerFactory = new BotPlayerFactory();
        this.botPlayerStrategies=botPlayerFactory.getBotPlayerStrategies(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        return botPlayerStrategies.makeMove(board);
    }
}
