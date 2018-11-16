package schwimmer.paint;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Canvas extends JComponent
        implements MouseMotionListener, MouseListener {

    private final List<Shape> shapes = new ArrayList<>();
    private Tool tool = null;
    private Color color = Color.BLACK;

    public Canvas() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for ( Shape shape : shapes ) {
            shape.paint(graphics);
        }
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        tool.onDrag(event.getX(), event.getY());

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent event) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Line line = new Line(color);
        tool = new PencilTool(line);
        shapes.add(line);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
