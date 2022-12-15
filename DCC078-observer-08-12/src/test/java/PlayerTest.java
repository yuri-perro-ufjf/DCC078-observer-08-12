import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void shouldBeNotifyOnePlayer() {
        Furnace furnace = new Furnace("sword", 1);
        Player player = new Player("first_player");
        player.createFurnace(furnace);
        furnace.finishItems();
        assertEquals("first_player Notification: Furnace finish item {Item type=soap, Item quantity=5}", player.getLastNotification());
    }

    @Test
    void shouldBeNotifyPlayers() {
        Furnace furnace = new Furnace("knife", 2);
        Player player_one = new Player("player_one");
        Player player_two = new Player("player_two");
        player_one.createFurnace(furnace);
        player_two.createFurnace(furnace);
        furnace.finishItems();
        assertEquals("player_one Notification: Furnace finish item {Item type=knife, Item quantity=2}", player_one.getLastNotification());
        assertEquals("player_two Notification: Furnace finish item {Item type=knife, Item quantity=2}", player_two.getLastNotification());
    }

    @Test
    void shouldNotBeNotifyPlayer() {
        Furnace furnace = new Furnace("sword", 3);
        Player player = new Player("player_one");
        furnace.finishItems();
        assertEquals(null, player.getLastNotification());
    }

    @Test
    void shouldBeNotifyPlayerFurnaceOne() {
        Furnace furnace_one = new Furnace("sword", 3);
        Furnace furnace_two = new Furnace("shield", 2);
        Player player_one = new Player("player_one");
        Player player_two = new Player("player_two");
        player_one.createFurnace(furnace_one);
        player_two.createFurnace(furnace_two);
        furnace_one.finishItems();
        assertEquals("player_one Notification: Furnace finish item {Item type=sword, Item quantity=3}", player_one.getLastNotification());
        assertEquals(null, player_two.getLastNotification());
    }
}