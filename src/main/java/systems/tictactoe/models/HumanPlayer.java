package systems.tictactoe.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class HumanPlayer extends Player {

    private User user;

    @Builder.Default // To initialize in a builder
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Move makeMove(Board board) {
        System.out.println("Enter the row and column");

        int row = scanner.nextInt();
        int column = scanner.nextInt();

        return new Move(row, column);
    }
    
}
