package systems.tictactoe;

import systems.tictactoe.exceptions.InvalidMoveException;
import systems.tictactoe.models.*;

public class TicTacToe {
    public static void main(String[] args) throws InvalidMoveException {
        Game game = createGame();

        System.out.println("Welcome to TicTacToe !");

        while(game.getStatus() == GameStatus.IN_PROGRESS) {
            Player nextplayer = game.getNextPlayer();
            System.out.println("Next move is of Player " + nextplayer.getSymbol());
            game.makeMove();
            game.printBoard();
        }

        if (game.getStatus() == GameStatus.DRAWN) {
            System.out.println("Game DRAWN. Now winner.");
        }

        if(game.getStatus() == GameStatus.WON) {
            System.out.println("Game OWN. Winner : " + game.getWinner().getSymbol());
        }
    }

    private static Game createGame() {

        // Assignment - Refactor this code to use factory
        Player human = HumanPlayer.builder()
                .symbol(Symbol.O)
                .user(new User("Pragg", "pragg@chess.com", null))
                .build();

        Player bot = Bot.builder()
                .symbol(Symbol.X)
                .level(BotLevel.EASY)
                .build();

        Game game = Game.builder()
                .withDimensions(3, 3)
                .withPlayer(human)
                .withPlayer(bot)
                .build();

        return game;
    }
}
