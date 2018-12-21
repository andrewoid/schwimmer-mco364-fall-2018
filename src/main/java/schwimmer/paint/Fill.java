package schwimmer.paint;

import java.awt.*;

public class Fill extends Shape {

    private Dot center;

    public Fill(Dot center, Color color) {
        super(color);
        this.center = center;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
    }
}
