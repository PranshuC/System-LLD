package systems.tictactoe;

import org.junit.Test;
import systems.tictactoe.models.Board;
import systems.tictactoe.models.Cell;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class BoardTest {

    @Test
    public void testDimensions() {
        Board board = new Board(3, 3);
        List<List<Cell>> cells = board.getCells();
        assertEquals("If board cells are created, number of rows should be ", 3, cells.size());
        List<Cell> firstRow = cells.get(0);
        assertEquals("If board cells are created, number of columns should be ", 3, firstRow.size());
    }
}
