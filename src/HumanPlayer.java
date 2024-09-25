import java.util.Scanner;

public class HumanPlayer extends Player {
    static Scanner sc = new Scanner(System.in);
    
    public HumanPlayer(char mark) {
        super(mark);
    }
    
    public int returnMove(Board board) {
        while (true) {
            System.out.print("Player " + mark + " choose a square (1-9): ");
            try {
                int chosenSquare = Integer.parseInt(sc.nextLine());
                if (chosenSquare < 1 || chosenSquare > 9) {
                    System.out.println("That is not a valid square!");
                    continue;
                }
                else if (board.squares[chosenSquare - 1] != ' '){
                    System.out.println("That square is taken!");
                    continue;
                }
                return chosenSquare;
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }
}
