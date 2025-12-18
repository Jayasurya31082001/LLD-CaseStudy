package TicTakToe.Models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    private Scanner scanner = new Scanner(System.in);
    public HumanPlayer(int id, String  name, Symbol symbol, PlayerType playerType) {
        super(id, name, symbol, playerType);
    }

@Override
    public Move makeMove(Board board) {
    try {
        System.out.println("Enter the row index:");
        int row = scanner.nextInt();
        System.out.println("Enter the column index:");
        int column = scanner.nextInt();
        return new Move(board.getCells().get(row).get(column), this);
    } catch (ArrayIndexOutOfBoundsException AOE) {
        System.out.println("Please enter the correct index number between 0 to "+(board.getDimension()-1));

    }
    catch (Exception e){
        System.out.println("Please enter the number");
    }
    return null;
}
}
