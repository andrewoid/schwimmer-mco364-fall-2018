package schwimmer.paint;

import java.awt.*;
import java.util.List;

interface Tool {

    void onDrag(int x, int y);

    void onPressed(int x, int y, Color color);

    Shape getShape();
}
