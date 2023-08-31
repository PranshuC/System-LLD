package systems.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import systems.tictactoe.exceptions.InvalidMoveException;

@Getter
@Setter
public class Game {

    private Board board;
    private List<Player> players = new ArrayList<>();
    private int nextPlayerIndex = 0;
    private GameStatus status;
    private Player winner;

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    public void makeMove() throws InvalidMoveException {

        // Get the next player
        Player player = getNextPlayer();
        Move move = player.makeMove(board);

        // Validate if the cell is not empty
        if(!board.isEmpty(move.getRow(), move.getColumn())) {
            throw new InvalidMoveException(" Cell is not empty");
        }

        // Update the board
        board.getCells().get(move.getRow()).get(move.getColumn()).setSymbol(player.getSymbol());

        // Check if the game is over
        if(checkWinner(player.getSymbol())) {
            status = GameStatus.WON;
            winner = player;
            return;
        }

        // Check if the game is draw
        if(checkDraw()) {
            status = GameStatus.DRAWN;
            return;
        }

        // Update the next player index
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
    }

    private boolean checkDraw() {
        return false;
    }

    private boolean checkWinner(Symbol symbol) {
        return false;
    }

    public void printBoard() {
        board.printBoard();
    }

    public static Builder builder() {
        return new Builder();
    }

    // Step 1 - Create static class
    public static class Builder {

        // Step 2 - Add reference of outer class
        private Game game;

        Builder() {
            this.game = new Game();
            game.status = GameStatus.IN_PROGRESS;
        }

        public Builder withDimensions(int rows, int columns) {
            Board board = new Board(rows, columns);
            this.game.setBoard(board);
            return this;
        }

        private boolean validate() {
            return game.players.size() >= 2;
        }

        public Builder withPlayer(Player player) {
            game.getPlayers().add(player);
            return this;
        }

        public Game build() {
            boolean isValid = validate();
            if (!isValid) {
                throw new RuntimeException("Game is not valid");
            }
            return this.game;
        }
    }
}
