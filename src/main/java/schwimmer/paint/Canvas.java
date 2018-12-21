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
    private Color color = Color.BLACK;
    private Tool tool = new PencilTool();

    public Canvas() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for ( Shape shape : shapes ) {
            shape.paint(graphics);
        }

        if (tool != null && tool.getShape() != null) {
            tool.getShape().paint(graphics);
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
        tool.onPressed(mouseEvent.getX(), mouseEvent.getY(), color);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        shapes.add(tool.getShape());
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
