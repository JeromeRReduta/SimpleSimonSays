package JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ColorButton extends JButton {

    private final Color originalColor;

    private ColorButton(Builder builder) {
        this.originalColor = builder.originalColor;
        setBackground(builder.originalColor);
        setPreferredSize(builder.dimensions);
        this.addActionListener(builder.listener);
    }

    public static class Builder {

        final int DEFAULT_WIDTH = 200;

        final int DEFAULT_HEIGHT = 200;

        private Color originalColor;

        private Dimension dimensions;

        private ActionListener listener;

        public Builder withColor(Color color) {
            this.originalColor = color;
            return this;
        }

        public Builder withDimensions(Dimension dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder withDimensions(int width, int height) {
            return withDimensions(new Dimension(width, height));
        }

        public Builder withDefaultDimensions() {
            return withDimensions(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        }

        public Builder withListener(ActionListener listener) {
            this.listener = listener;
            return this;
        }

        public ColorButton build() {
            return new ColorButton(this);
        }
    }
}
