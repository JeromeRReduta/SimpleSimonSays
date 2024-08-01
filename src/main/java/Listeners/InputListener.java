package Listeners;

import Controllers.GameController;
import Models.GameData;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class InputListener {

    private final List<Integer> userSequence;

    private GameController controller;

    public InputListener() {
        this.userSequence = new ArrayList<>();
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public void onButtonClick(int colorID, GameData data) {
        int roundNum = data.getRoundNum();
        userSequence.add(colorID);
        if (userSequence.size() == roundNum) {
            boolean userHasFailed = !subSequencesMatch(
                    data.getColorIDs(),
                    userSequence,
                    data.getRoundNum());
            if (userHasFailed) {
                endWithFailure();
                return;
            }
            playNextRound(data);
        }
    }

    private void playNextRound(GameData data) {
        controller.incrementRoundNum();
        userSequence.clear();
        if (data.getRoundNum() > data.getMaxRounds()) {
            endWithSuccess();
            return;
        }
        controller.flickerBigBar();
    }

    private void endWithFailure() {
        Timer timer = new Timer();
        controller.displaySadFaces();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                },
                1000);
}

    private void endWithSuccess() {
        Timer timer = new Timer();
        controller.displayHappyFaces();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                },
                1000);
    }
    public List<Integer> getUserSequence() {
        return new ArrayList<>(userSequence);
    }

    private boolean subSequencesMatch(List<Integer> first, List<Integer> second, int limit) {
        List<Integer> firstSubSequence = first.subList(0, limit);
        List<Integer> secondSubSequence = second.subList(0, limit);
        return firstSubSequence.equals(secondSubSequence);
    }

}
