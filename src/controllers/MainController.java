package controllers;

import helpers.StateManager;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import models.Game;
import views.AboutView;

public class MainController {

    private MenuItem afsluitItem;
    private BorderPane startPane;
    private BorderPane borderPane;
    private Label melding;
    private Button startButton;
    private Button overButton;

    public void initialize() {
        AboutView aboutView = new AboutView();

        StateManager.initialize(this);
        melding.setText("Start het spel!");

        afsluitItem.setOnAction(event -> {
            System.exit(0);
        });

        overButton.setOnAction(event -> {
            System.out.println("Over aangeroepen!");
            aboutView.show();
        });

        startButton.setOnAction(event -> {
            System.out.println("Game gestart aangeroepen!");
            melding.setText("Game aangeroepen!");
            startPane.setTop(null);
            startPane.setCenter(null);
            startPane.setMinSize(0, 0);
            borderPane.setTop(null);
            borderPane.setMinSize(0, 0);
            StateManager.schakelScherm(StateManager.VIEW_GAME_SCHERM);
        });

    }

    public void setAfsluitItem(MenuItem afsluitItem){
        this.afsluitItem = afsluitItem;
    }

    public void setStartButton(Button startButton){this.startButton = startButton;}

    public void setOverButton(Button overButton){this.overButton = overButton;}

    public void setBorderPane(BorderPane borderPane){this.borderPane = borderPane;}

    public void setMelding(Label melding){this.melding = melding;}

    public void setStartPane(BorderPane startPane){this.startPane = startPane;}

    public void schakelScherm(Parent root){borderPane.setCenter(root);}

}
