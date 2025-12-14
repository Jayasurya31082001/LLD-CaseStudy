package TicTakToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private  int dimension;
    private List<List<Cell>> cells ;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cells=new ArrayList<>();
        for(int i =0;i<dimension;i++){
            cells.add(new ArrayList<>());
            for (int j =0;j<dimension;j++){
                cells.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public void displayBoard() {
        for (List<Cell> cellList:cells){
            for (Cell cell:cellList){
                String symbol = cell.getSymbol();

                System.out.print("|"+symbol+"| ");
            }
            System.out.println();
        }
    }
}
