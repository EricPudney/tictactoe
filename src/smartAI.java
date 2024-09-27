import java.util.ArrayList;

import static java.lang.Math.min;
import static java.lang.Math.max;

public class smartAI extends Player {
    public smartAI(char mark) {
        super(mark);
    }

    public int returnMove(Board board) {
        int[] possibleMoves = actions(board);
        int bestMove = 0;
        if (board.currentPlayer() == 'X') {
            int score = -100;
            for (int move : possibleMoves) {
                Board newBoard = result(board, move, 'X');
                int moveScore = minvalue(newBoard);
                if (moveScore > score) {
                    score = moveScore;
                    bestMove = move;
                }
            }
        } else if (board.currentPlayer() == 'O') {
            int score = 100;
            for (int move : possibleMoves) {
                Board newBoard = result(board, move, 'O');
                int moveScore = maxvalue(newBoard);
                if (moveScore < score) {
                    score = moveScore;
                    bestMove = move;
                }
            }
        }
        return bestMove;
    }


    public int[] actions(Board board) {
            ArrayList<Integer> possibleMoves = new ArrayList<>();
            for (int i = 0; i < board.squares.length; i++) {
                if (board.squares[i] == ' ') {
                    possibleMoves.add(i + 1);
                }
            }
            int[] returnValue = new int[possibleMoves.size()];
            for (int i = 0; i < returnValue.length; i++) {
                returnValue[i] = possibleMoves.get(i);
            }
            return returnValue;
    }

    public Board result(Board board, int action, char mark) {
        Board newBoard = new Board();
        for (int i = 0; i < board.squares.length; i++) {
            if (board.squares[i] == 'X') {
                newBoard.squares[i] = 'X';
            }
            else if (board.squares[i] == 'O') {
                newBoard.squares[i] = 'O';
            }
        }
        newBoard.squares[action - 1] = mark;
        return newBoard;
    }

    public int utility(Board board) {
        char winner = board.returnWinner();
        int depth = 1;
        for (char square : board.squares) {
            if (square == ' ') {
                depth++;
            }
        }
        return switch (winner) {
            case 'X' -> depth;
            case 'O' -> -1 * depth;
            default -> 0;
        };
    }

    private int maxvalue(Board board) {
        if (board.checkIfOver()) {
            return utility(board);
        }
        int v = -100;
        int[] possibleMoves = actions(board);
        for (int action : possibleMoves) {
            v = max(v, minvalue(result(board, action, 'X')));
        }
        return v;
    }

    private int minvalue(Board board) {
        if (board.checkIfOver()) {
            return utility(board);
        }
        int v = 100;
        int[] possibleMoves = actions(board);
        for (int action : possibleMoves) {
            v = min(v, maxvalue(result(board, action, 'O')));
        }
        return v;
    }
}