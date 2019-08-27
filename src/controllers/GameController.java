package controllers;

import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import models.Game;

import java.util.Random;


public class GameController {

    private Button[][] buttons2D;
    private Game game;
    private Label melding;

    private Button position00;
    private Button position01;
    private Button position02;
    private Button position10;
    private Button position11;
    private Button position12;
    private Button position20;
    private Button position21;
    private Button position22;

    public void initialize() {
        game = new Game();
        setPlayingField();
        computergameProcess();


    }

    //Method for player vs player functionality in the game
    private void playersGameProcess() {
        for (int i = 0; i < buttons2D.length; i++) {
            for (int j = 0; j < buttons2D[i].length; j++) {
                Button button = buttons2D[i][j];
                buttons2D[i][j].setOnMouseClicked(event -> {
                    if (game.getTheTurn() == "X" && button.getId() == null) {
                        game.incrementTurnCount();
                        System.out.println("Turn: " + game.getTurnCount());
                        melding.setText("It's nought's turn!");
                        game.setTheTurn("O");
                        button.setId("buttonClickX");
                        checkWinningConditions("X");
                    } else if (game.getTheTurn() == "O" && button.getId() == null) {
                        game.incrementTurnCount();
                        System.out.println("Turn: " + game.getTurnCount());
                        melding.setText("It's cross's turn!");
                        button.setId("buttonClickO");
                        game.setTheTurn("X");
                        checkWinningConditions("O");
                    }
                });
            }
        }
    }
    //Method for player vs the computer
    private void computergameProcess() {
        for (int g = 0; g < 9; g++) {
            for (int i = 0; i < buttons2D.length; i++) {
                for (int j = 0; j < buttons2D[i].length; j++) {
                    Button button = buttons2D[i][j];
                    buttons2D[i][j].setOnMouseClicked(event -> {
                        if (game.getTheTurn() == "X" && button.getId() == null) {
                            game.incrementTurnCount();
                            System.out.println("Turn: " + game.getTurnCount());
                            melding.setText("It's nought's turn!");
                            game.setTheTurn("O");
                            button.setId("buttonClickX");
                            checkWinningConditions("X");
                            computerPress();
                        }
                    });
                }
            }
        }
    }

    private void computerPress() {
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> {
            Random r = new Random();
            int i = r.nextInt(3);
            int j = r.nextInt(3);
            Button button = buttons2D[i][j];
            while (button.getId() != null) {
                i = r.nextInt(3);
                j = r.nextInt(3);
                button = buttons2D[i][j];
            }

            if (button.getId() == null) {
                melding.setText("It's Cross' turn!");
                button.setId("buttonClickO");
                checkWinningConditions("O");
                game.setTheTurn("X");
            }
        });
        pause.play();
    }


    private void checkWinningConditions(String turnState) {
        switch (turnState) {
            case "X":
                if (buttons2D[0][0].getId() == "buttonClickX" && buttons2D[0][1].getId() == "buttonClickX" &&
                        buttons2D[0][2].getId() == "buttonClickX") {
                    melding.setText("Cross won!");
                    game.gameIsWon();
                    clearField();
                } else if (buttons2D[1][0].getId() == "buttonClickX" && buttons2D[1][1].getId() == "buttonClickX" && buttons2D[1][2].getId() == "buttonClickX") {
                    melding.setText("Cross won!");
                    game.gameIsWon();
                    System.out.println("Cross won!");
                    clearField();
                } else if (buttons2D[2][0].getId() == "buttonClickX" && buttons2D[2][1].getId() == "buttonClickX" && buttons2D[2][2].getId() == "buttonClickX") {
                    melding.setText("Cross won!");
                    game.gameIsWon();
                    System.out.println("Cross won!");
                    clearField();
                } else if (buttons2D[0][0].getId() == "buttonClickX" && buttons2D[1][0].getId() == "buttonClickX" && buttons2D[2][0].getId() == "buttonClickX") {
                    melding.setText("Cross won!");
                    game.gameIsWon();
                    System.out.println("Cross won!");
                    clearField();
                } else if (buttons2D[0][1].getId() == "buttonClickX" && buttons2D[1][1].getId() == "buttonClickX" && buttons2D[2][1].getId() == "buttonClickX") {
                    melding.setText("Cross won!");
                    System.out.println("Cross won!");
                    game.gameIsWon();
                    clearField();
                } else if (buttons2D[0][2].getId() == "buttonClickX" && buttons2D[1][2].getId() == "buttonClickX" && buttons2D[2][2].getId() == "buttonClickX") {
                    melding.setText("Cross won!");
                    System.out.println("Cross won!");
                    game.gameIsWon();
                    clearField();
                } else if (buttons2D[2][2].getId() == "buttonClickX" && buttons2D[1][1].getId() == "buttonClickX" && buttons2D[0][0].getId() == "buttonClickX") {
                    melding.setText("Cross won!");
                    System.out.println("Cross won!");
                    game.gameIsWon();
                    clearField();
                } else if (buttons2D[2][0].getId() == "buttonClickX" && buttons2D[1][1].getId() == "buttonClickX" && buttons2D[0][2].getId() == "buttonClickX") {
                    melding.setText("Cross won!");
                    System.out.println("Cross won!");
                    game.gameIsWon();
                    clearField();
                } else if (checkDraw()) {
                    melding.setText("Draw!");
                    clearField();
                }
                break;

            case "O":
                if (buttons2D[0][0].getId() == "buttonClickO" && buttons2D[0][1].getId() == "buttonClickO" &&
                        buttons2D[0][2].getId() == "buttonClickO") {
                    melding.setText("Nought won!");
                    System.out.println("Nought won!");
                    game.gameIsWon();
                    clearField();
                } else if (buttons2D[1][0].getId() == "buttonClickO" && buttons2D[1][1].getId() == "buttonClickO" && buttons2D[1][2].getId() == "buttonClickO") {
                    melding.setText("Nought won!");
                    System.out.println("Nought won!");
                    game.gameIsWon();
                    clearField();
                } else if (buttons2D[2][0].getId() == "buttonClickO" && buttons2D[2][1].getId() == "buttonClickO" && buttons2D[2][2].getId() == "buttonClickO") {
                    melding.setText("Nought won!");
                    System.out.println("Nought won!");
                    game.gameIsWon();
                    clearField();
                } else if (buttons2D[0][0].getId() == "buttonClickO" && buttons2D[1][0].getId() == "buttonClickO" && buttons2D[2][0].getId() == "buttonClickO") {
                    melding.setText("Nought won!");
                    System.out.println("Nought won!");
                    game.gameIsWon();
                    clearField();
                } else if (buttons2D[0][1].getId() == "buttonClickO" && buttons2D[1][1].getId() == "buttonClickO" && buttons2D[2][1].getId() == "buttonClickO") {
                    melding.setText("Nought won!");
                    System.out.println("Nought won!");
                    game.gameIsWon();
                    clearField();
                } else if (buttons2D[0][2].getId() == "buttonClickO" && buttons2D[1][2].getId() == "buttonClickO" && buttons2D[2][2].getId() == "buttonClickO") {
                    melding.setText("Nought won!");
                    System.out.println("Nought won!");
                    game.gameIsWon();
                    clearField();
                } else if (buttons2D[2][2].getId() == "buttonClickO" && buttons2D[1][1].getId() == "buttonClickO" && buttons2D[0][0].getId() == "buttonClickO") {
                    melding.setText("Nought won!");
                    System.out.println("Nought won!");
                    game.gameIsWon();
                    clearField();
                } else if (buttons2D[2][0].getId() == "buttonClickO" && buttons2D[1][1].getId() == "buttonClickO" && buttons2D[0][2].getId() == "buttonClickO") {
                    melding.setText("Nought won!");
                    System.out.println("Nought won!");
                    game.gameIsWon();
                    clearField();
                } else if (checkDraw()) {
                    melding.setText("Draw!");
                    clearField();
                }
                break;
        }
    }


    private Button[][] setPlayingField() {
        buttons2D = new Button[3][3];

        buttons2D[0][0] = position00;
        buttons2D[0][1] = position01;
        buttons2D[0][2] = position02;
        buttons2D[1][0] = position10;
        buttons2D[1][1] = position11;
        buttons2D[1][2] = position12;
        buttons2D[2][0] = position20;
        buttons2D[2][1] = position21;
        buttons2D[2][2] = position22;

        return buttons2D;
    }

    private void clearField() {
        if (game.gameIsWon()) {
            for (int i = 0; i < buttons2D.length; i++) {
                for (int j = 0; j < buttons2D[0].length; j++) {
                    buttons2D[i][j].setId(null);
                }
            }
        } else if (!game.gameIsWon()) {
            System.out.println("It's a draw!");
        }
    }

    private boolean checkDraw() {
        int counter = 0;

        for (int i = 0; i < buttons2D.length; i++) {
            for (int j = 0; j < buttons2D[i].length; j++) {
                if (buttons2D[i][j].getId() != null) {
                    counter++;
                }
            }
        }
        if (counter >= 9) {
            System.out.println("It's a draw!");
            return true;
        } else {
            return false;
        }
    }

    public void setField(Button position00, Button position01, Button position02, Button position10, Button position11,
                         Button position12, Button position20, Button position21, Button position22) {
        this.position00 = position00;
        this.position01 = position01;
        this.position02 = position02;
        this.position10 = position10;
        this.position11 = position11;
        this.position12 = position12;
        this.position20 = position20;
        this.position21 = position21;
        this.position22 = position22;
    }

    public void setMelding(Label melding) {
        this.melding = melding;
    }
}
