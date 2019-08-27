package views;

import controllers.StartController;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class StartView {

    private Parent root;
    private StartController controller;

    public StartView(StartController controller){
        this.controller = controller;
        root = createRoot();
        setupController();
    }

    public Parent createRoot(){
        GridPane startScherm = createStartScherm();

        VBox vBox = new VBox();
        vBox.getChildren().add(startScherm);
        return vBox;

    }

    public GridPane createStartScherm(){


        GridPane gridPane = new GridPane();
        Button button = new Button("Start game!");
        gridPane.add(button, 2, 1);
        return gridPane;

    }

    public Parent getRoot(){return root;}

    public void setupController(){
        controller.initialize();

    }


}
