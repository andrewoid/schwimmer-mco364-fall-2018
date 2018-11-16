package schwimmer.paint;

public class RectangleTool implements Tool {

    private Rectangle rectangle;

    @Override
    public void onDrag(int x, int y) {
        rectangle.setX2(x);
        rectangle.setY2(y);
    }
}
