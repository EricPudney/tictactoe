public class Board {
    char[] squares = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    public Board() {
    }

    public char currentPlayer() {
        int moves = 0;
        for (char square : this.squares) {
            if (square == 'X' || square == 'O') {
                moves++;
            }
        }
        if (moves % 2 == 0) {
            return 'X';
        }
        else {
            return 'O';
        }
    }

    public boolean checkIfOver() {
        char winner = returnWinner();
        if (winner != ' ') {
            return true;
        }
        else {
            for (char c : squares) {
                if (c == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public char returnWinner() {
        char[][] rows = {{squares[0], squares[1], squares[2]}, {squares[3], squares[4], squares[5]}, {squares[6], squares[7], squares[8]}};
        char[][] columns = {{squares[0], squares[3], squares[6]}, {squares[1], squares[4], squares[7]}, {squares[2], squares[5], squares[8]}};
        char[][] diagonals = {{squares[0], squares[4], squares[8]}, {squares[2], squares[4], squares[6]}};
        char[][][] lines = {rows, columns, diagonals};
        for (char[][] arr : lines) {
            for (char[] line : arr) {
                if (line[0] == line[1] && line[1] == line[2] && line[0] != ' ') {
                    return line[0];
                }
            }
        }
        return ' ';
    }

    public void recordMove(int square, char mark) {
        squares[square - 1] = mark;
    }

    @Override
    public String toString() {
        return " " + squares[0] + " | " + squares[1] + " | " + squares[2]
                + "\n---+---+---\n" +
                " " + squares[3] + " | " + squares[4] + " | " + squares[5]
                + "\n---+---+---\n" +
                " " + squares[6] + " | " + squares[7] + " | " + squares[8];
    }
}