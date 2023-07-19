import java.util.Random;
import java.util.Scanner;

public class Game_RPS {
    private static final int DRAW = 0;
    private static final int PLAYER_WIN = 1;
    private static final int COMPUTER_WIN = 2;

    public static void main(String[] args) {
        String[] choices = {"rock", "paper", "scissors"};

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = false;
        do {
            System.out.print("Enter your move (rock, paper, or scissors): ");
            String playerMove = scanner.nextLine().toLowerCase();

            if (!isValidMove(playerMove, choices)) {
                System.out.println("Invalid move! Please enter 'rock', 'paper', or 'scissors'.");
                continue;
            }

            int computerMoveIndex = random.nextInt(choices.length);
            String computerMove = choices[computerMoveIndex];

            System.out.println("Computer chooses: " + computerMove);

            int result = determineWinner(playerMove, computerMove);
            if (result == DRAW) {
                System.out.println("It's a draw! Let's play again.");
                playAgain = true;
                continue;
            } else if (result == PLAYER_WIN) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().toLowerCase();
            playAgain = playAgainInput.equals("yes");
            System.out.println();
        } while (playAgain);

        System.out.println("Thanks for playing!");
    }

    static int determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return DRAW;
        }

        if ((playerMove.equals("rock") && computerMove.equals("scissors"))
                || (playerMove.equals("paper") && computerMove.equals("rock"))
                || (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return PLAYER_WIN;
        }

        return COMPUTER_WIN;
    }

    static boolean isValidMove(String move, String[] choices) {
        for (String choice : choices) {
            if (choice.equals(move)) {
                return true;
            }
        }
        return false;
    }
}
