package schwimmer.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Shape {

    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void paint(BufferedImage image, Graphics imageGraphics) {
        imageGraphics.setColor(color);
    }
}
