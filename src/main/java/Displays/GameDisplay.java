package Displays;

import java.util.List;

public interface GameDisplay {

    void display();

    void flickerBigBar(List<Integer> colorIDs, int length);

    void displayStringOnButtons(String str);

}
