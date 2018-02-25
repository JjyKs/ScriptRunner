package server;

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
        actor2.doDamage(actor1.calculateDamage());
        actor1.doDamage(actor2.calculateDamage());
        
        System.out.println("");
        System.out.println("---FIGHT---");
        System.out.println("Actor1: " + actor1.health);
        System.out.println("Actor2: " + actor2.health);
        System.out.println("-----------");
        System.out.println("");
        
        return !(actor1.isAlive() && actor2.isAlive());
    }
}
