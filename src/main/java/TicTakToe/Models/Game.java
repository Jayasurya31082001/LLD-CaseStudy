package TicTakToe.Models;


import TicTakToe.Strategies.GameWinningStrategies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private  List<GameWinningStrategies> gameStrategiesList;
    private Player winner;
    private  int nextPlayeIndex;
    private  GameState gameState;
    private  List<Move> moves;
    private Scanner scanner = new Scanner(System.in);

    private Game(int size,List<Player> players, List<GameWinningStrategies> gameStrategiesList) {
        this.board= new Board(size);
        this.players = players;
        this.gameStrategiesList = gameStrategiesList;
        this.winner=null;
        this.nextPlayeIndex=0;
        this.gameState=GameState.INPROGRESS;
        this.moves= new ArrayList<>();

    }


    public static Builder getBuilder(){
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<GameWinningStrategies> getGameStrategiesList() {
        return gameStrategiesList;
    }

    public void setGameStrategiesList(List<GameWinningStrategies> gameStrategiesList) {
        this.gameStrategiesList = gameStrategiesList;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayeIndex() {
        return nextPlayeIndex;
    }

    public void setNextPlayeIndex(int nextPlayeIndex) {
        this.nextPlayeIndex = nextPlayeIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void displayBoard() {
        board.displayBoard();
    }

    public void startGame() {
        while(GameState.INPROGRESS.equals(gameState)) {


            Player currentPlayer = players.get(nextPlayeIndex);
            System.out.println(currentPlayer.getName()+ " it's your turn");
            displayBoard();
            Move move = currentPlayer.makeMove(board);
            if (!validateMove(move)) {
                System.out.println("Invalid move");
                continue;
            }
            int row = move.getCell().getRow();
            int column = move.getCell().getColumn();
            move.getCell().setCellState(CellState.BLOCKED);
            if(currentPlayer.getPlayerType().equals(PlayerType.BOT)){
                move.setPlayer(currentPlayer);
            }
            move.getCell().setSymbol(currentPlayer.getSymbol().getSymbol());
            moves.add(move);

            if(validateWin(move)){
                setWinner(currentPlayer);
                setGameState(GameState.WIN);
                System.out.println(currentPlayer.getName()+ " won the game!!!!!!");
                return;
            }
            nextPlayeIndex++;
            nextPlayeIndex%= players.size();
             displayBoard();
            if(checkDraw()){
                gameState=GameState.DRAW;
                System.out.println("Drew the match, No moves left!");
                return;
            }
            while (true) {
                System.out.println("(U)ndo (C)ontinue");
                String ch = scanner.nextLine();

                if (ch.equalsIgnoreCase("U")) {
                    undo();
                    break;
                } else if (ch.equalsIgnoreCase("C")) {
                    break;
                }
            }

        }


    }
    public boolean checkDraw(){
        return moves.size() == board.getDimension() * board.getDimension();


    }
    public void undo(){
        if(moves.isEmpty()){
            System.out.println("There is no move yet");
            return;
        }
        Move move = moves.get(moves.size()-1);
        moves.remove(moves.size()-1);
        move.getCell().setCellState(CellState.FREE);
        move.getCell().setSymbol("-");
        undoMoves(move);
       nextPlayeIndex= (nextPlayeIndex-1 + players.size())% players.size();
    }
    public void  undoMoves(Move move){
        for (GameWinningStrategies gameWinningStrategies:gameStrategiesList){
            gameWinningStrategies.undoMoves(board,move);
        }
    }
    public  boolean validateWin(Move move){
         boolean winFlag = false;
        for (GameWinningStrategies gameWinningStrategy:gameStrategiesList){
            winFlag|=gameWinningStrategy.checkWin(board,move);
        }
        return winFlag;
    }
    public boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();
        if(row<0||row> board.getDimension()-1||column<0||column> board.getDimension()-1){
            return false;
        }
        return board.getCells().get(row).get(column).getCellState().equals(CellState.FREE);
    }




    public  static class Builder{
        private List<Player> players;
        private  List<GameWinningStrategies> gameStrategiesList;
        private int size;

        public Builder() {

        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setGameStrategiesList(List<GameWinningStrategies> gameStrategiesList) {
            this.gameStrategiesList = gameStrategiesList;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }
        public Game build(){
            validation();
            return new Game(size,players,gameStrategiesList);
        }

        public  void validation(){
            HashSet<String> symbols = new HashSet<>();
            for (Player player:players){
                if(symbols.contains(player.getSymbol().getSymbol())){
                    throw  new RuntimeException("Duplicate player symbol exception for player: "+player.getSymbol().getSymbol());
                }
            }

            if(size-1!=players.size()){
                throw  new RuntimeException("Player size mismatching exception");
            }
        }
    }
}
