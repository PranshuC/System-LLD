package systems.tictactoe.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public abstract class Player {
   
    private Symbol symbol;

    public abstract Move makeMove(Board board);
}
