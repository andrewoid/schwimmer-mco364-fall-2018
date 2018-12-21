package schwimmer.paint;

import javax.swing.*;
import java.awt.*;

public class PaintFrame extends JFrame {

    private final Canvas canvas;

    public PaintFrame() {
        canvas = new Canvas();
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);

        JPanel north = new JPanel();
        north.setLayout(new FlowLayout());

        JButton changeColorButton = new JButton("Change color");
        changeColorButton.addActionListener( listener -> {
            Color newColor = JColorChooser.showDialog(
                    PaintFrame.this,
                    "Choose Background Color",
                    canvas.getColor());
            canvas.setColor(newColor);
        });
        north.add(changeColorButton);

        JButton pencilButton = new JButton("Pencil");
        pencilButton.addActionListener(listener -> {
            canvas.setTool(new PencilTool());
        });
        north.add(pencilButton);

        JButton rectangleButton = new JButton("Rectangle");
        rectangleButton.addActionListener(listener -> {
            canvas.setTool(new RectangleTool());
        });
        north.add(rectangleButton);

        JButton bucketFillButton = new JButton("Bucket Fill");
        bucketFillButton.addActionListener(listener -> {
            canvas.setTool(new BucketFillTool());
        });
        north.add(bucketFillButton);

        add(north, BorderLayout.NORTH);

        setSize(800, 600);

        setTitle("Paint");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        new PaintFrame().setVisible(true);
    }

}
