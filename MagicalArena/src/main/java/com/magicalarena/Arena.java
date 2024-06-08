package MagicalArena.src.main.java.com.magicalarena;

import java.util.Random;

public class Arena {
    private Player playerA;
    private Player playerB;
    private Random random;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.random = new Random();
    }

    public void fight() {
        while (playerA.isAlive() && playerB.isAlive()) {
            if (playerA.getHealth() < playerB.getHealth()) {
                takeTurn(playerA, playerB);
                if (!playerB.isAlive()) break;
                takeTurn(playerB, playerA);
            } else {
                takeTurn(playerB, playerA);
                if (!playerA.isAlive()) break;
                takeTurn(playerA, playerB);
            }
        }

        System.out.println(playerA.isAlive() ? "Player A wins!" : "Player B wins!");
    }

    private void takeTurn(Player attacker, Player defender) {
        int attackRoll = rollDice();
        int defendRoll = rollDice();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defendValue = defender.getStrength() * defendRoll;

        int damage = attackDamage - defendValue;
        if (damage > 0) {
            defender.setHealth(defender.getHealth() - damage);
            System.out.println(String.format("%s attacks %s for %d damage. %s health is now %d.",
                    attacker, defender, damage, defender, defender.getHealth()));
        } else {
            System.out.println(String.format("%s attacks %s but the attack is fully defended.",
                    attacker, defender));
        }
    }

    private int rollDice() {
        return random.nextInt(6) + 1;
    }
}
