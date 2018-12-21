package schwimmer.paint;

import java.awt.*;

public class BucketFillTool implements Tool {
    private FillShape shape;

    @Override
    public void onDrag(int x, int y) {

    }

    @Override
    public void onPressed(int x, int y, Color color) {
        shape = new FillShape(new Dot(x,y), color);
    }

    @Override
    public Shape getShape() {
        return shape;
    }
}
