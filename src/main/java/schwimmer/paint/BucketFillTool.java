package schwimmer.paint;

import java.awt.*;

public class BucketFillTool implements Tool {
    private Fill shape;

    @Override
    public void onDrag(int x, int y) {

    }

    @Override
    public void onPressed(int x, int y, Color color) {
        shape = new Fill(new Dot(x,y), color);
    }

    @Override
    public Shape getShape() {
        return shape;
    }
}
