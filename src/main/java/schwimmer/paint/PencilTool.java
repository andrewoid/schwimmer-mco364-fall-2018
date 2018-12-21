package schwimmer.paint;

import java.awt.*;

public class PencilTool implements Tool {

    private Line line;

    public PencilTool() {
    }

    @Override
    public void onDrag(int x, int y) {
        line.getList().add(new Dot(x, y));
    }

    @Override
    public void onPressed(int x, int y, Color color) {
        line = new Line(color);
    }

    @Override
    public Shape getShape() {
        return line;
    }


}
