package views;

import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class AboutView {


    private Stage stage;
    private TextArea melding;

    private static final int WIDTH = 450;
    private static final int HEIGHT = 300;

    public AboutView() {
        stage = new Stage();
        stage.setTitle("Over");

        Parent root = createRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }

    private BorderPane createRoot() {
        melding = new TextArea();
        melding.setStyle("-fx-background-color: red");
        melding.setText("Deze programma is gemaakt door Mohamed Ben Ali");
        melding.setEditable(false);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(melding);
        return borderPane;
    }

    public void show() {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        stage.setX((primaryScreenBounds.getWidth() - WIDTH) / 2f);
        stage.setY((primaryScreenBounds.getHeight() - HEIGHT) / 2f);
        stage.setHeight(HEIGHT);
        stage.setWidth(WIDTH);

        stage.show();
    }
}
