import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    private static Player[] initiateGame() {
        while (true) {
            System.out.print("Enter a number from 1-3 to play against \n   1. human, \n   2. dumb AI, or \n   3. smart AI\n");
                Player x;
                Player o;
                try {
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            x = new HumanPlayer('X');
                            o = new HumanPlayer('O');
                            return new Player[]{x, o};
                        case 2:
                            x = new HumanPlayer('X');
                            o = new dumbAI('O');
                            return new Player[]{x, o};
                        case 3:
                            x = new HumanPlayer('X');
                            o = new smartAI('O');
                            return new Player[]{x, o};
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
            System.out.println(board);
        } while (!board.checkIfOver());
    }
}