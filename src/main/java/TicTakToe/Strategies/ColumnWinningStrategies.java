package TicTakToe.Strategies;

import TicTakToe.Models.Board;
import TicTakToe.Models.Move;
import TicTakToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategies implements GameWinningStrategies{

    private Map<Integer, Map<Symbol,Integer>> columnCount= new HashMap<>();

    @Override
    public boolean checkWin(Board board, Move move) {
        int column = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol,Integer> map = columnCount.computeIfAbsent(column,k->new HashMap<>());

        int count = map.merge(symbol,1,Integer::sum);

        if(count== board.getDimension()){
            return true;
        }
        return false;
    }

    @Override
    public void undoMoves(Board board, Move move) {
        int column = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol,Integer> map = columnCount.computeIfAbsent(column,k->new HashMap<>());

        map.put(symbol,map.get(symbol)-1);

    }
}
