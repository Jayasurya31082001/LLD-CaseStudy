package TicTakToe.Strategies;

import TicTakToe.Models.Board;
import TicTakToe.Models.Move;
import TicTakToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategies implements GameWinningStrategies{
    private Map<Symbol,Integer>right= new HashMap<>();
    private Map<Symbol,Integer> left= new HashMap<>();

    @Override
    public boolean checkWin(Board board, Move move) {
        int row= move.getCell().getRow();
        int column = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        if(row==column){
          int count = left.merge(symbol,1,Integer::sum);
          if(count== board.getDimension()){
              return true;
          }
        }
        if(row+column==board.getDimension()-1){
            int count = right.merge(symbol,1,Integer::sum);
            if(count== board.getDimension()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void undoMoves(Board board, Move move) {
        int row= move.getCell().getRow();
        int column = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        if(row==column){
            left.put(symbol,left.get(symbol)-1);
            return;
        }
        if(row+column==board.getDimension()-1){
            right.put(symbol,right.get(symbol)-1);
            return;
        }
    }
}
