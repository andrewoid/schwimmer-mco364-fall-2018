package schwimmer.paint;

import javax.swing.*;
import java.awt.*;

public class PaintFrame extends JFrame {

    private final Canvas canvas;

    public PaintFrame() {
        canvas = new Canvas();
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);

        JButton changeColorButton = new JButton("Change color");
        add(changeColorButton, BorderLayout.NORTH);
        changeColorButton.addActionListener( listener -> {
            Color newColor = JColorChooser.showDialog(
                    PaintFrame.this,
                    "Choose Background Color",
                    canvas.getColor());
            canvas.setColor(newColor);
        });

        setSize(800, 600);

        setTitle("Paint");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        new PaintFrame().setVisible(true);
    }

}
