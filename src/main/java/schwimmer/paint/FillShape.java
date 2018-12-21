package schwimmer.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FillShape extends Shape {

    private Dot center;

    public FillShape(Dot center, Color color) {
        super(color);
        this.center = center;
    }

    @Override
    public void paint(BufferedImage image, Graphics imageGraphics) {
        super.paint(image, imageGraphics);
    }
}
