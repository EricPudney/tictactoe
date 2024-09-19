import java.util.Scanner;

class Board {
    char[] squares = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    public Board() {
    }

    public boolean checkIfOver() {
        if (returnWinner()) {
            return true;
        }
        else {
            for (char c : squares) {
                if (c == ' ') {
                    return false;
                }
            }
        }
        System.out.println("Game over - it's a draw.");
        return true;
    }

    public boolean returnWinner() {
        char[][] rows = {{squares[0], squares[1], squares[2]}, {squares[3], squares[4], squares[5]}, {squares[6], squares[7], squares[8]}};
        char[][] columns = {{squares[0], squares[3], squares[6]}, {squares[1], squares[4], squares[7]}, {squares[2], squares[5], squares[8]}};
        char[][] diagonals = {{squares[0], squares[4], squares[8]}, {squares[2], squares[4], squares[6]}};
        char[][][] lines = {rows, columns, diagonals};
        for (char[][] arr : lines) {
            for (char[] line : arr) {
                if (line[0] == line[1] && line[1] == line[2] && line[0] != ' ') {
                    System.out.println("Game over! Player " + line[0] + " wins!");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean recordMove(int square, char mark) {
        if (squares[square - 1] == ' ') {
            squares[square - 1] = mark;
            return true;
        }
        else {
            System.out.println("Invalid move");
            return false;
        }
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

class Player {
    char mark;
    Scanner sc = new Scanner(System.in);

    public Player(char mark) {
        this.mark = mark;
    }

    public int takeTurn() {
        System.out.print("Player " + this.mark + " choose a square (1-9): ");
        return Integer.parseInt(sc.nextLine());
        }

    }


public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player x = new Player('X');
        Player o = new Player('O');
        System.out.println(board);
        while (true) {
            boolean validMove = false;
            while (!validMove) {
                if (board.recordMove(x.takeTurn(), x.mark)) {
                    System.out.println(board);
                    validMove = true;
                }
            }
            if (board.checkIfOver()) {
                break;
            }
            validMove = false;
            while (!validMove) {
                if (board.recordMove(o.takeTurn(), o.mark)) {
                    System.out.println(board);
                    validMove = true;
                }
            }
            if (board.checkIfOver()) {
                break;
            }
            }
        }
    }
