package Displays;

import Generators.RandomColorIDGenerator;
import JPanel.ColorButton;
import Listeners.InputListener;
import Models.GameData;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Timer;
import java.util.*;


public class SimpleGameDisplay implements GameDisplay {

    static final int RED_ID = 0;

    static final int BLUE_ID = 1;

    static final int GREEN_ID = 2;

    static final int YELLOW_ID = 3;

    public static ColorButton bigBar = new ColorButton.Builder()
            .withColor(Color.WHITE)
            .withDimensions(401, 200)
            .build();

    public static ColorButton red = new ColorButton.Builder()
            .withColor(Color.RED)
            .withDefaultDimensions()
            .build();

    public static ColorButton blue = new ColorButton.Builder()
            .withColor(Color.BLUE)
            .withDefaultDimensions()
            .build();

    public static ColorButton green = new ColorButton.Builder()
            .withColor(Color.GREEN)
            .withDefaultDimensions()
            .build();

    public static ColorButton yellow = new ColorButton.Builder()
            .withColor(Color.YELLOW)
            .withDefaultDimensions()
            .build();

    public static void turnWhiteWhileHeld(ColorButton button) {
        if (button.getModel().isPressed()) {
            button.setBackground(Color.WHITE);
        }
    }

    public static void toggleButtonColor(ColorButton button, Iterator<Integer> iterator) {
        Color newColor = idToColors.get(iterator.next());
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                button.setBackground(Color.WHITE);
            }
        };
        long delay = 500;
        button.setBackground(newColor);
        timer.schedule(task, delay);
    }

    static final Map<Integer, Color> idToColors = Map.of(
            RED_ID, Color.RED,
            BLUE_ID, Color.BLUE,
            GREEN_ID, Color.GREEN,
            YELLOW_ID, Color.YELLOW);

    static final Map<Integer, ColorButton> idToButtons = Map.of(
            RED_ID, red,
            BLUE_ID, blue,
            GREEN_ID, green,
            YELLOW_ID, yellow);

    private List<ColorButton> setupButtons() {
        List<ColorButton> buttons = new ArrayList<>();
        buttons.addAll(List.of(red, blue, green, yellow));
        buttons.forEach(
                button -> button.addActionListener(
                        e -> turnWhiteWhileHeld(button)));
        buttons.add(0, bigBar);
        buttons.forEach(button -> button.setFont(new Font("Arial", Font.PLAIN, 48)));
        red.addActionListener(e -> inputListener.onButtonClick(RED_ID, data));
        blue.addActionListener(e -> inputListener.onButtonClick(BLUE_ID, data));
        green.addActionListener(e -> inputListener.onButtonClick(GREEN_ID, data));
        yellow.addActionListener(e -> inputListener.onButtonClick(YELLOW_ID, data));
        return buttons;
    }


    private final InputListener inputListener;

    private final GameData data;

    public SimpleGameDisplay(InputListener inputListener, GameData data) {
        this.inputListener = inputListener;
        this.data = data;
    }



    @Override
    public void display() {
        Collection<ColorButton> buttons = setupButtons();

        JFrame frame = new JFrame("panel");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

        panel.setBackground(Color.WHITE);
        buttons.iterator().forEachRemaining(panel::add);

        frame.setSize(416, 616);
        frame.add(panel);

        List<Integer> ids = RandomColorIDGenerator.generateColorIDs(YELLOW_ID + 1, 5);
        Iterator<Integer> iterator = ids.iterator();

        frame.show();
    }

    @Override
    public void flickerBigBar(List<Integer> colorIDs, int length) {
        Iterator<Integer> iterator = colorIDs.subList(0, length).iterator();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            public void run() {
                if (!iterator.hasNext()) {
                    timer.cancel();
                    timer.purge();
                    return;
                }
                toggleButtonColor(bigBar, iterator);
            }
        };
        long delay = 1000;
        timer.scheduleAtFixedRate(task, new Date(), delay);
    }

    @Override
    public void displayStringOnButtons(String str) {
        List.of(red, blue, green, yellow, bigBar)
                .forEach(button -> button.setText(str));
    }
}
