package schwimmer.paint;

import java.awt.*;

public class RectangleTool implements Tool {

    private Rectangle rectangle;

    @Override
    public void onDrag(int x, int y) {
        rectangle.setX2(x);
        rectangle.setY2(y);
    }

    @Override
    public void onPressed(int x, int y, Color color) {
        rectangle = new Rectangle(color, x, y);
    }

    @Override
    public Shape getShape() {
        return rectangle;
    }

}