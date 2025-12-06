package SnakeAndLadder.Exceptions;

public class IllegalMaxPlayerException extends Exception{
    public IllegalMaxPlayerException(){
        super();
    }
    public IllegalMaxPlayerException(String message){
    super(message);
    }

}
