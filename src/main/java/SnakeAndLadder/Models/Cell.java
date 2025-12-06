package SnakeAndLadder.Models;

public class Cell {
    private int index;
    private Snake snake;
    private Ladder ladder;

    public Cell(int index){
        this.index=index;

    }
    public void setSnake(Snake snake){
        this.snake =snake;
    }
    public  void setLadder(Ladder ladder){
        this.ladder =ladder;
    }

    public int getIndex() {
        return index;
    }

    public boolean isSnake() {
       return (snake !=null)? true:false;

    }

    public boolean isLadder() {
        return (ladder !=null)? true:false;
    }
    public  Snake getSnake(){
        return snake;
    }
    public  Ladder getLadder(){
        return ladder;
    }
}
