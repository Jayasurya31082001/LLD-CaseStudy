package SnakeAndLadder.Models;

import SnakeAndLadder.Exceptions.IllegalMaxPlayerException;

import java.util.List;

public class Board {
    private  int size;
    private List<Ladder> ladders;
    private  List<Snake> snakes;
     private  List<Player> players;
    private   Cell[] cells;


    public Board(int size,List<Player> players,List<Ladder> ladders,List<Snake> snakes) throws IllegalMaxPlayerException {
        if(players.size()< 2 || players.size()>4){
            throw  new IllegalMaxPlayerException();
        }
        this.size = size;
        cells = new Cell[size+1];
        this.ladders = ladders;
        this.snakes = snakes;
        this.players=players;
    }

    public void setBoard(){
        for (int i =0;i<=size;i++){
            cells[i]=new Cell(i);
        }
         for (Ladder ladder:ladders){
             cells[ladder.getBaseIndex()].setLadder(ladder);
         }
         for (Snake snake:snakes){
             cells[snake.getHeadIndex()].setSnake(snake);
         }
    }

    public  int newPosition(int position){
           if(cells[position].isLadder()){
               System.out.println("Yeaa claiming the ladder from "+position+" to "+cells[position].getLadder().getTopIndex());
               return cells[position].getLadder().getTopIndex();
           }
           if(cells[position].isSnake()){
               System.out.println("Oops got snake bite and moving from "+position+" to "+cells[position].getSnake().getTailIndex());
               return cells[position].getSnake().getTailIndex();
           }
           return position;
    }

    public int getSize() {
        return size;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Cell[] getCells() {
        return cells;
    }
}
