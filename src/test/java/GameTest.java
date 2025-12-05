import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    Game game = new Game();

    @Test
    public void shouldRegisterPlayersAndFightFirstWins() {

        Player p1 = new Player(1, "Bob", 50);
        Player p2 = new Player(2, "Alex", 30);

        game.register(p1);
        game.register(p2);

        int result = game.round("Bob", "Alex");

        assertEquals(1, result);
    }

    @Test
    public void shouldSecondWin() {

        Player p1 = new Player(1, "Bob", 20);
        Player p2 = new Player(2, "Alex", 40);

        game.register(p1);
        game.register(p2);

        int result = game.round("Bob", "Alex");

        assertEquals(2, result);
    }

    @Test
    public void shouldBeDraw() {

        Player p1 = new Player(1, "Bob", 30);
        Player p2 = new Player(2, "Alex", 30);

        game.register(p1);
        game.register(p2);

        int result = game.round("Bob", "Alex");

        assertEquals(0, result);
    }

    @Test
    public void shouldThrowIfFirstNotRegistered() {

        Player p2 = new Player(2, "Alex", 30);
        game.register(p2);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Bob", "Alex");
        });
    }

    @Test
    public void shouldThrowIfSecondNotRegistered() {

        Player p1 = new Player(1, "Bob", 30);
        game.register(p1);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Bob", "Alex");
        });
    }

    @Test
    public void shouldReturnPlayerId() {
        Player player = new Player(10, "TestPlayer", 99);

        int actual = player.getId();

        assertEquals(10, actual);
    }

}
