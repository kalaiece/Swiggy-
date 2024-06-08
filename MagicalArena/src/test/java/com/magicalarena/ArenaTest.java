package MagicalArena.src.test.java.com.magicalarena;

import org.junit.Test;

import MagicalArena.src.main.java.com.magicalarena.Arena;
import MagicalArena.src.main.java.com.magicalarena.Player;

import static org.junit.Assert.*;

public class ArenaTest {
    @Test
    public void testFight() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        Arena arena = new Arena(playerA, playerB);
        
        arena.fight();
        
        assertTrue(playerA.getHealth() <= 0 || playerB.getHealth() <= 0);
    }

    @Test
    public void testPlayerAttributes() {
        Player player = new Player(50, 5, 10);
        
        assertEquals(50, player.getHealth());
        assertEquals(5, player.getStrength());
        assertEquals(10, player.getAttack());
    }
}
