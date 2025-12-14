package TicTakToe.Strategies;

import TicTakToe.Models.Board;
import TicTakToe.Models.Cell;
import TicTakToe.Models.CellState;
import TicTakToe.Models.Move;

import java.util.List;

public class EasyBotPlayerStrategy implements  BotPlayerStrategies{
    @Override
    public Move makeMove(Board board) {

        for (List<Cell> cellList: board.getCells()){
            for (Cell cell:cellList){
                if(cell.getCellState().equals(CellState.FREE)){
                    return new Move(cell,null);
                }
            }
        }
        return  null;
    }
}
