package schwimmer.maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void removeWalls_SOUTH() {

        Cell a = new Cell(1,1);
        Cell b = new Cell(1, 2);

        a.removeWalls(b);

        assertFalse(a.isSouthWall());
        assertFalse(b.isNorthWall());

    }

    @Test
    public void removeWalls_NORTH() {

        Cell a = new Cell(1,1);
        Cell b = new Cell(1, 0);

        a.removeWalls(b);

        assertFalse(a.isNorthWall());
        assertFalse(b.isSouthWall());

    }
    @Test
    public void removeWalls_EAST() {

        Cell a = new Cell(1,1);
        Cell b = new Cell(2, 1);

        a.removeWalls(b);

        assertFalse(a.isEastWall());
        assertFalse(b.isWestWall());
    }

    @Test
    public void removeWalls_WEST() {

        Cell a = new Cell(1,1);
        Cell b = new Cell(0, 1);

        a.removeWalls(b);

        assertFalse(a.isWestWall());
        assertFalse(b.isEastWall());
    }

    @Test(expected = IllegalStateException.class)
    public void removeWalls_notNeighbors() {

        Cell a = new Cell(1,1);
        Cell b = new Cell(2, 2);

        a.removeWalls(b);
    }


}