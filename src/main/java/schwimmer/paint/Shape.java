package schwimmer.paint;

import java.awt.*;

public abstract class Shape {

    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void paint(Graphics graphics) {
        graphics.setColor(color);
    }
}
