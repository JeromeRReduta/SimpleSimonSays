import Controllers.GameController;
import Controllers.SimpleGameController;
import Displays.GameDisplay;
import Displays.SimpleGameDisplay;
import Generators.RandomColorIDGenerator;
import Listeners.InputListener;
import Models.GameData;
import Models.SimpleGameData;

import javax.swing.*;

class SimpleSimonSays extends JFrame {

    static final int DEFAULT_MAX_ROUNDS = 5;

    static final int DEFAULT_COLOR_ID_BOUND = 4;

    public static void main(String[] args) {
        InputListener listener = new InputListener();
        GameData data = new SimpleGameData(
                DEFAULT_MAX_ROUNDS,
                0,
                RandomColorIDGenerator.generateColorIDs(DEFAULT_COLOR_ID_BOUND, DEFAULT_MAX_ROUNDS));
        GameDisplay display = new SimpleGameDisplay(listener, data);
        GameController controller = new SimpleGameController(data, display);
        listener.setController(controller);
        controller.runGame();
    }
}
