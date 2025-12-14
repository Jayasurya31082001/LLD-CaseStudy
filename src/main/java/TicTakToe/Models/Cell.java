package TicTakToe.Models;

public class Cell {

    private  int row;
    private  int column;
    private CellState cellState;
    private String symbol;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.cellState=CellState.FREE;
        this.symbol="-";
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public String  getSymbol() {
        return symbol;
    }

    public void setSymbol(String  symbol) {
        this.symbol = symbol;
    }
}
