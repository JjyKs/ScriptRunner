package server.Actors.Scripts;

import server.Actors.Actor;
import server.Actors.Attributes.CombatStats;
import server.Tools.CombatTools;

/**
 *
 * @author JjyKs
 */
public class FightScript extends Script {

    Actor actor1;
    Actor actor2;

    public FightScript(Actor actor1, Actor actor2) {
        super();
        this.actor1 = actor1;
        this.actor2 = actor2;
    }

    @Override
    public boolean runImplementation(long tick) {
        CombatTools.doDamage(CombatTools.calculateDamage(actor2), actor1);
        CombatTools.doDamage(CombatTools.calculateDamage(actor1), actor2);
        printStatus();
        
        return !(CombatTools.isAlive(actor1) && CombatTools.isAlive(actor2));
    }

    private void printStatus() {
        System.out.println("");
        System.out.println("---FIGHT---");
        System.out.println("Actor1: " + actor1.getAttribute(CombatStats.class).getHealth());
        System.out.println("Actor2: " + actor2.getAttribute(CombatStats.class).getHealth());
        System.out.println("-----------");
        System.out.println("");
    }
}
