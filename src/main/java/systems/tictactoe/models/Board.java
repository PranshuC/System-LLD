package systems.tictactoe.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private List<List<Cell>> cells = new ArrayList<>();

    public Board(int rows, int columns) {
        /*List<Cell> columnCells = Collections.nCopies(columns, new Cell());
        List<List<Cell>> rowCells = Collections.nCopies(rows, columnCells);
        this.cells = rowCells;*/
        IntStream.range(0, rows).forEach(row -> {
            List<Cell> rowCells = new ArrayList<>();
            IntStream.range(0, columns).forEach(column -> rowCells.add(new Cell(row, column)));
            cells.add(rowCells);
        });
    }

    public boolean isEmpty(int row, int column) {
        return cells.get(row).get(column).getSymbol() == null;
    }

    public List<Cell> getAvailableCells() {
        return cells.stream()
                .flatMap(List::stream)
                .filter(cell -> cell.getSymbol() == null)
                .toList();
    }

    public void printBoard() {
        for (int i =0; i<cells.size(); i++) {
            for (int j=0; j< cells.size(); j++) {
                Symbol symbol = cells.get(i).get(j).getSymbol();

                if (symbol == null) {
                    System.out.print(" | - | ");
                } else {
                    System.out.print(" | " + symbol + " | ");
                }
            }
            System.out.print("\n");
        }
    }
}
