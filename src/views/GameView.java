package views;

import controllers.GameController;
import controllers.MainController;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class GameView {

    private static final int WIDTH = 550;
    private static final int HEIGHT = 480;

    private Parent root;
    private BorderPane borderPane;
    private GridPane playingField;

    MainController mainController;
    private GameController controller;
    String style = getClass().getResource("/styles/allbtn.css").toExternalForm();

    private Label melding;
    private Button[][] buttons2D;
    Button position00;
    Button position01;
    Button position02;
    Button position10;
    Button position11;
    Button position12;
    Button position20;
    Button position21;
    Button position22;

    public GameView(GameController controller) {
        this.controller = controller;
        mainController = new MainController();

        root = createRoot();
        setupController();
    }

    private Parent createRoot() {
        playingField = createVisualGame();
        borderPane = createBorderPane();

        return new VBox(borderPane, playingField);
    }

    private BorderPane createBorderPane(){
        borderPane = new BorderPane();
        melding = new Label();
        borderPane.setTop(melding);
        melding.setPadding(new Insets(7, 0, 0, 230));
        borderPane.setStyle("-fx-background-color: bisque");
        borderPane.setMinSize(510, 35);
        return borderPane;

    }

    private GridPane createVisualGame() {
        double maxWidth = WIDTH / 3;
        double maxHeight = HEIGHT / 3.8;

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        //Rij 1
        position00 = new Button();
        position00.setMinSize(maxWidth, maxHeight);
        position00.getStyleClass().add("button1");

        position01 = new Button();
        position01.setMinSize(maxWidth, maxHeight);
        position01.getStyleClass().add("button1");

        position02 = new Button();
        position02.setMinSize(maxWidth, maxHeight);
        position02.getStyleClass().add("button1");

        //Rij 2
        position10 = new Button();
        position10.setMinSize(maxWidth, maxHeight);
        position10.getStyleClass().add("button1");

        position11 = new Button();
        position11.setMinSize(maxWidth, maxHeight);
        position11.getStyleClass().add("button1");

        position12 = new Button();
        position12.setMinSize(maxWidth, maxHeight);
        position12.getStyleClass().add("button1");
        //Rij 3
        position20 = new Button();
        position20.setMinSize(maxWidth, maxHeight);
        position20.getStyleClass().add("button1");

        position21 = new Button();
        position21.setMinSize(maxWidth, maxHeight);
        position21.getStyleClass().add("button1");

        position22 = new Button();
        position22.setMinSize(maxWidth, maxHeight);
        position22.getStyleClass().add("button");
        //Voeg buttons aan gridPane
        gridPane.add(position00, 0, 0);
        gridPane.add(position01, 0, 1);
        gridPane.add(position02, 0, 2);

        gridPane.add(position10, 1, 0);
        gridPane.add(position11, 1, 1);
        gridPane.add(position12, 1, 2);

        gridPane.add(position20, 2, 0);
        gridPane.add(position21, 2, 1);
        gridPane.add(position22, 2, 2);

        return gridPane;
    }

    public Parent getRoot(){
        return root;
    }

    private void setupController(){
        controller.setField(position00, position01, position02, position10, position11, position12, position20, position21, position22);
        controller.setMelding(melding);
        controller.initialize();
    }


}
