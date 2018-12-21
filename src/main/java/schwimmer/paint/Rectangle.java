package schwimmer.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rectangle extends Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(Color color, int x1, int y1) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1;
        this.y2 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void paint(BufferedImage image, Graphics imageGraphics) {
        super.paint(image, imageGraphics);

        int xi = Math.min(x1, x2);
        int yi = Math.min(y1, y2);
        int width = Math.abs(x1 - x2);
        int height = Math.abs(y1 - y2);

        imageGraphics.drawRect(xi, yi, width, height);
    }
}
