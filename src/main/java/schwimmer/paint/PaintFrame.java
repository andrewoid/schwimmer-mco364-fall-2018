package schwimmer.paint;

import javax.swing.*;
import java.awt.*;

public class PaintFrame extends JFrame {

    private final Canvas canvas;

    public PaintFrame() {
        canvas = new Canvas();
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);

        setSize(800, 600);

        setTitle("Paint");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        new PaintFrame().setVisible(true);
    }

}
