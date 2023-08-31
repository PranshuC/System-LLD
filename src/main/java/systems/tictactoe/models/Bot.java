package systems.tictactoe.models;

import lombok.Builder;
import systems.tictactoe.strategies.PlayingStrategy;
import systems.tictactoe.strategies.RandomPlayingStrategy;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class Bot extends Player {

    private BotLevel level;
    @Builder.Default
    private PlayingStrategy strategy = new RandomPlayingStrategy();

    @Override
    public Move makeMove(Board board) {
        return strategy.makeMove(board);
    }

}
