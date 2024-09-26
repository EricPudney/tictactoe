import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    private static Player playerType(char mark) {
        while (true) {
            System.out.printf("Enter a number from 1-3 to choose player type for player %s: \n   1. human, \n   2. dumb AI, or \n   3. smart AI\n", mark);
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        return new HumanPlayer(mark);
                    case 2:
                        return new dumbAI(mark);
                    case 3:
                        return new smartAI(mark);
                    default:
                        System.out.println("Invalid input!");
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }
    }

    private static Player[] initiateGame() {
        Player x = playerType('X');
        Player o = playerType('O');
        return new Player[]{x, o};
    }

    public static void main(String[] args) {
        Board board = new Board();
        Player[] players = initiateGame();
        Player x = players[0];
        Player o = players[1];
        System.out.println(board);
        do {
            Player currentPlayer;
            if (board.currentPlayer() == 'X') {
                currentPlayer = x;
            } else {
                currentPlayer = o;
            }
            board.recordMove(currentPlayer.returnMove(board), currentPlayer.mark);
            System.out.println("\n" + board);
        } while (!board.checkIfOver());
        switch (board.returnWinner()) {
            case 'X':
                System.out.println("Player X won!");
                break;
                case 'O':
                    System.out.println("Player O won!");
                    break;
                    default:
                        System.out.println("It's a draw!");
                        break;
        }
    }
}