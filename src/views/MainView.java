package views;

import controllers.GameController;
import controllers.MainController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainView {

    private static final String TITEL= "Boterkaas en Eiren";
    private static final int WIDTH = 550;
    private static final int HEIGHT = 480;

    private Stage stage;


    private MenuBar menuBar;
    private MenuItem afsluitItem;
    private Button startButton;
    private Button overButton;
    private BorderPane borderPane;
    private BorderPane startPane;
    private Label melding;

    String style = getClass().getResource("/styles/allbtn.css").toExternalForm();
    private MainController controller;

    public MainView(MainController controller){
    this.controller = controller;

    stage = new Stage();
    stage.setTitle(TITEL);
    Parent root = createRoot();
    Scene scene = new Scene(root);
    scene.getStylesheets().add(style);

    stage.setScene(scene);
    stage.setResizable(true);

    setupController();

    }

    private Parent createRoot() {
        menuBar = createMenuBar();
        borderPane = createBorderPane();
        startPane = createStartPane();
        VBox startVbox = new VBox();
        startVbox.getChildren().addAll(startPane);
        return new VBox(menuBar, borderPane, startVbox);
    }


    private MenuBar createMenuBar() {
        //Opties menu
        Menu menu = new Menu("Opties");
        afsluitItem = new MenuItem("Afsluiten");
        menu.getItems().addAll(afsluitItem);
        //Menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.setMinWidth(520);
        menuBar.setMinHeight(0);
        menuBar.getMenus().addAll(menu);

        return menuBar;
    }

    private BorderPane createBorderPane(){
        borderPane = new BorderPane();
        melding = new Label();
        melding.setStyle("-fx-background-color: bisque");
        melding.setMaxWidth(Double.MAX_VALUE);
        melding.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
        borderPane.setTop(melding);
        return borderPane;

    }

    private BorderPane createStartPane(){
        startPane = new BorderPane();
        startPane.setMinSize(550, 380);
        HBox hBox = new HBox();
        Image startImage = new Image("/images/startImage.jpg");
        ImageView startImageView = new ImageView(startImage);
        startImageView.setFitHeight(100);
        startImageView.setFitWidth(530);
        startButton = new Button("Start game!");
        overButton = new Button("Over");
        overButton.setMinSize(100, 50);
        startButton.setMinSize(150, 50);
        hBox.getChildren().addAll(startButton, overButton);
        hBox.setSpacing(60);
        hBox.setPadding(new Insets(100, 0, 0, 185));

        startButton.getStyleClass().add("startButton");
        overButton.getStyleClass().add("startButton");
        startPane.setStyle("-fx-background-color:#009933;");
        startPane.setCenter(hBox);
        startPane.setTop(startImageView);
        return startPane;
    }

    public void show(){
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        stage.setX((primaryScreenBounds.getWidth() - WIDTH) / 2);
        stage.setY((primaryScreenBounds.getHeight() - HEIGHT) / 2);

        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.show();

    }
    public void setupController(){
        controller.setAfsluitItem(afsluitItem);
        controller.setBorderPane(borderPane);
        controller.setMelding(melding);
        controller.setStartButton(startButton);
        controller.setOverButton(overButton);
        controller.setStartPane(startPane);

        controller.initialize();

    }

}
