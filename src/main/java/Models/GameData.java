package Models;

import java.util.List;

public interface GameData {

    int getMaxRounds();

    int getRoundNum();

    void setRoundNum(int roundNum);

    List<Integer> getColorIDs();
}
