package schwimmer.paint;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Line extends Shape {

    private List<Dot> list = new ArrayList<>();

    public Line(Color color) {
        super(color);
    }

    public List<Dot> getList() {
        return list;
    }

    @Override
    public void paint(BufferedImage image, Graphics imageGraphics) {
        super.paint(image, imageGraphics);

        for (int i = 1; i < list.size(); i++) {
            Dot dot = list.get(i);
            imageGraphics.drawLine(
                    dot.x, dot.y,
                    list.get(i - 1).x, list.get(i - 1).y);
        }
    }
}
