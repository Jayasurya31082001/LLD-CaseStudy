package SnakeAndLadder.Models;

import SnakeAndLadder.Exceptions.IllegalSnakeIndexException;

public class Snake {
    private int headIndex;
    private  int tailIndex;


    public Snake(int headIndex, int tailIndex) throws IllegalSnakeIndexException {
        if(headIndex<tailIndex){
            throw  new IllegalSnakeIndexException("Invalid snake index");
        }
        this.headIndex = headIndex;
        this.tailIndex = tailIndex;
    }

    public int getHeadIndex() {
        return headIndex;
    }

    public int getTailIndex() {
        return tailIndex;
    }
}
