package schwimmer.paint;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
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
    private BufferedImage image = new BufferedImage(800, 600,
            BufferedImage.TYPE_INT_RGB);

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

        Graphics imageGraphics = image.getGraphics();
        imageGraphics.setColor(Color.WHITE);
        imageGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());

        for ( Shape shape : shapes ) {
            shape.paint(image, imageGraphics);
        }

        if (tool != null && tool.getShape() != null) {
            tool.getShape().paint(image, imageGraphics);
        }

        graphics.drawImage(image, 0, 0, null);
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
