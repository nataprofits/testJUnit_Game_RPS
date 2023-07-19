
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Game_RPSTest {
private Game_RPS game;

    @BeforeEach
    public void setUp() {
      game = new Game_RPS();
    }
@Test
    public void testIsValidMove() {
        String[] choices = {"rock", "paper", "scissors"};
    Assertions.assertTrue(game.isValidMove("rock", choices));
    Assertions.assertTrue(game.isValidMove("paper", choices));
    Assertions.assertTrue(game.isValidMove("scissors", choices));
    Assertions.assertFalse(game.isValidMove("invalid", choices));
}
@Test
    public void testDetermineWinner(){
     Assertions.assertEquals(0, game.determineWinner("rock", "rock"));
    Assertions.assertEquals(0, game.determineWinner("paper", "paper"));
    Assertions.assertEquals(0, game.determineWinner("scissors", "scissors"));

    Assertions.assertEquals(1, game.determineWinner("rock", "scissors"));
    Assertions.assertEquals(1, game.determineWinner("paper", "rock"));
    Assertions.assertEquals(1, game.determineWinner("scissors", "paper"));

    Assertions.assertEquals(2, game.determineWinner("rock", "paper"));
    Assertions.assertEquals(2, game.determineWinner("paper", "scissors"));
    Assertions.assertEquals(2, game.determineWinner("scissors", "rock"));
}
}