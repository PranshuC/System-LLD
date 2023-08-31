package systems.tictactoe.strategies;


import systems.tictactoe.models.Board;
import systems.tictactoe.models.Cell;
import systems.tictactoe.models.Move;

import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategy {

    @Override
    public Move makeMove(Board board) {

        // Get the available cells
        List<Cell> availableCells = board.getAvailableCells();

        // Generate a random number with the size of the available cells
        int randomIndex = (int) Math.random() * availableCells.size();
        Cell randomCell = availableCells.get(randomIndex);

        // Return the random cell
        return new Move(randomCell.getRow(), randomCell.getColumn());
    }
    
}
