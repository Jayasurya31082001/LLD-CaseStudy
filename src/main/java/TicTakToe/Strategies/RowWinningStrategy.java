package TicTakToe.Strategies;

import TicTakToe.Models.Board;
import TicTakToe.Models.Move;
import TicTakToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements  GameWinningStrategies{
   private Map<Integer, Map<Symbol,Integer>> rowCount= new HashMap<>();

    @Override
    public boolean checkWin(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol,Integer> map = rowCount.computeIfAbsent(row,k->new HashMap<>());

        int count = map.merge(symbol,1,Integer::sum);

        if(count== board.getDimension()){
            return true;
        }
        return false;
    }

    @Override
    public void undoMoves(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol,Integer> map = rowCount.computeIfAbsent(row,k->new HashMap<>());

        map.put(symbol,map.get(symbol)-1);

    }
}
