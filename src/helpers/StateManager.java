package helpers;

import controllers.GameController;
import controllers.MainController;
import views.GameView;

public class StateManager {

    private static MainController mainController;
    public final static String VIEW_GAME_SCHERM = "GameScherm";

    public static void initialize(MainController mainController) {
        StateManager.mainController = mainController;

    }

    public static void schakelScherm(String naam) {
        switch (naam) {
            case VIEW_GAME_SCHERM:

                GameController gameController = new GameController();
                GameView gameView = new GameView(gameController);
                mainController.schakelScherm(gameView.getRoot());

            break;
        }


    }
}
