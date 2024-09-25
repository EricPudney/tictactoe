import java.util.ArrayList;
import java.util.Random;

public class dumbAI extends Player {

    Random rng = new Random();

    public dumbAI(char mark) {
        super(mark);
    }

    public int returnMove(Board board) {
        ArrayList<Object> emptySquares = new ArrayList<>();
        for (int i = 0; i < board.squares.length; i++) {
            if (board.squares[i] == ' ') {
                emptySquares.add(i + 1);
            }
        }
        int index = rng.nextInt(emptySquares.size());
        return (int) emptySquares.get(index);
    }
}
