package Controllers;

import Displays.GameDisplay;
import Models.GameData;

import java.util.List;

public class SimpleGameController implements GameController {

    private final GameData data;

    private final GameDisplay display;


    public SimpleGameController(GameData data, GameDisplay display) {
        this.data = data;
        this.display = display;
    }

    @Override
    public void display() {
        display.display();
    }

    @Override
    public void flickerBigBar() {
        List<Integer> ids = data.getColorIDs();
        display.flickerBigBar(ids, data.getRoundNum());
    }

    @Override
    public void displayHappyFaces() {
        display.displayStringOnButtons(":)");
    }

    @Override
    public void displaySadFaces() {
        display.displayStringOnButtons(":(");
    }

    @Override
    public void incrementRoundNum() {
        data.setRoundNum(data.getRoundNum() + 1);
    }

    @Override
    public void runGame() {
        data.setRoundNum(1);
        display();
        flickerBigBar();

    }
}
