package SnakeAndLadder.Exceptions;

public class IllegalSnakeIndexException extends Exception{
    public IllegalSnakeIndexException(){
        super();
    }
    public IllegalSnakeIndexException(String message){
        super(message);
    }
}
