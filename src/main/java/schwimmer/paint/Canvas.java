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

    private final List<List<Dot>> lines = new ArrayList<>();

    public Canvas() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for ( List<Dot> line : lines ) {
            for (int i = 1; i < line.size(); i++) {
                Dot dot = line.get(i);
                graphics.setColor(dot.color);
                graphics.drawLine(
                        dot.x, dot.y,
                        line.get(i - 1).x, line.get(i - 1).y);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        lines.get(lines.size()-1)
                .add(new Dot(event.getX(), event.getY(), Color.BLACK));
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
        lines.add(new ArrayList<>());
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
}
