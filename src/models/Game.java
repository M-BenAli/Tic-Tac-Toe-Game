package models;

public class Game {

    private final static String CROSS = "X";
    private final static String NOUGHT = "O";

    private String theTurn;
    private boolean gameWon;
    private int turnCount;

    public Game() {
        this.turnCount = 0;
        this.theTurn = CROSS;
        this.gameWon = false;
    }

    public void setTheTurn(String theTurn) {
        this.theTurn = theTurn;
    }

    public String getTheTurn() {
        return theTurn;
    }

    public int incrementTurnCount() {
        if (gameWon) {
            this.turnCount = 0;
            this.gameWon = false;
        }
        return turnCount++;
    }

    public int getTurnCount(){
        return this.turnCount;
    }

    public boolean gameIsWon() {
        return gameWon = true;
    }
}


