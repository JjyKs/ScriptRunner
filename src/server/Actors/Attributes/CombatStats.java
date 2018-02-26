package server.Actors.Attributes;

/**
 *
 * @author JjyKs
 */
public class CombatStats extends Attribute {

    private int health;
    private int damage;
    private int defence;

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
    }

    public int getDamage() {
        return damage;
    }

    public CombatStats() {
        health = 100;
        damage = 10;
        defence = 10;
    }

}
