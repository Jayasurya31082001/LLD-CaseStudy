package TicTakToe.Strategies;

import TicTakToe.Models.BotDifficultyLevel;

public class BotPlayerFactory {
  public static BotPlayerStrategies getBotPlayerStrategies(BotDifficultyLevel botDifficultyLevel){
      if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
          return new EasyBotPlayerStrategy();
      }
      return null;
  }
}
