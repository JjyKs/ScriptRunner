package server.Tools;

import server.Actors.Actor;
import server.Actors.Attributes.CombatStats;
import server.Actors.Attributes.PlayerInfo;

/**
 *
 * @author JjyKs
 */
public class CombatTools {

    public static int calculateDamage(Actor actor) {
        return (int) (Math.random() * 10);
    }

    public static int doDamage(int incomingDamage, Actor actor) {
        int calculatedDamage = calculateDamageAfterArmor(incomingDamage, actor);
        actor.getAttribute(CombatStats.class).reduceHealth(calculatedDamage);

        return calculatedDamage;
    }

    private static int calculateDamageAfterArmor(int incomingDamage, Actor actor) {
        CombatStats combatStats = actor.getAttribute(CombatStats.class);
        PlayerInfo playerInfo = actor.getAttribute(PlayerInfo.class);

        int amount = Math.max(0, incomingDamage - (int) (Math.random() * combatStats.getDefence()));

        System.out.println("");
        System.out.println("---" + playerInfo.getName() + "---");
        System.out.println("Took " + amount + " damage");
        System.out.println("-------------");
        System.out.println("");
        return amount;
    }

    public static boolean isAlive(Actor actor) {
        CombatStats combatStats = actor.getAttribute(CombatStats.class);
        return combatStats.getHealth() > 0;
    }
}
