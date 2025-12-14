package TicTakToe.Strategies;

import TicTakToe.Models.Board;
import TicTakToe.Models.Move;

public interface GameWinningStrategies {
    boolean checkWin(Board board, Move move);
    void undoMoves(Board board,Move move);
}
