package schwimmer.paint;

public class PencilTool implements Tool {

    private Line line;

    public PencilTool(Line line) {
        this.line = line;
    }

    @Override
    public void onDrag(int x, int y) {

        line.getList().add(new Dot(x, y));

    }
}
