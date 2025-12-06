package SnakeAndLadder.Models;

import SnakeAndLadder.Exceptions.IllegalLadderIndexException;

public class Ladder {
    private  int baseIndex;
    private  int topIndex;

    public Ladder(int baseIndex, int topIndex) throws IllegalLadderIndexException {
        if(topIndex<baseIndex){
            throw  new IllegalLadderIndexException("Invalid ladder index");
        }
        this.topIndex = topIndex;
        this.baseIndex = baseIndex;
    }

    public int getBaseIndex() {
        return baseIndex;
    }


    public int getTopIndex() {
        return topIndex;
    }


}
