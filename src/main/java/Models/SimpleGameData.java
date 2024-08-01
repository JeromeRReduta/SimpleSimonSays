package Models;

import java.util.List;

public class SimpleGameData implements GameData {

    private final int maxRounds;

    private int roundNum;

    private final List<Integer> colorIDs;

    public SimpleGameData(
            int maxRounds,
            int roundNum,
            List<Integer> colorIDs) {
        this.maxRounds = maxRounds;
        this.roundNum = roundNum;
        this.colorIDs = colorIDs;
    }

    @Override
    public int getMaxRounds() {
        return maxRounds;
    }

    @Override
    public int getRoundNum() {
        return roundNum;
    }

    @Override
    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }

    @Override
    public List<Integer> getColorIDs() {
        return colorIDs;
    }
}
