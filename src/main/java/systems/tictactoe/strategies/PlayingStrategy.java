package systems.tictactoe.strategies;

import systems.tictactoe.models.Board;
import systems.tictactoe.models.Move;

public interface PlayingStrategy {
    Move makeMove(Board board);
}
