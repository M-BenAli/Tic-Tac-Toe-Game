import controllers.MainController;
import views.GameView;
import javafx.application.Application;
import javafx.stage.Stage;
import views.MainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainController mainController = new MainController();
        MainView mainView = new MainView(mainController);
        mainView.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
