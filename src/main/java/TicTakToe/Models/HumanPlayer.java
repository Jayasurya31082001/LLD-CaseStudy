package TicTakToe.Models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    private Scanner scanner = new Scanner(System.in);
    public HumanPlayer(int id, String  name, Symbol symbol, PlayerType playerType) {
        super(id, name, symbol, playerType);
    }

@Override
    public Move makeMove(Board board) {
        System.out.println("Enter the row index:");
        int row = scanner.nextInt();
        System.out.println("Enter the column index:");
        int column = scanner.nextInt();
        return new Move(board.getCells().get(row).get(column),this);
    }
}
