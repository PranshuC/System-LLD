package systems.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cell {
    private Integer row;
    private Integer column;
    private Symbol symbol;

    public Cell (int row, int column) {
        this.row = row;
        this.column = column;
    }
}
