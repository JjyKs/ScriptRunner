package server;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/**
 *
 * @author JjyKs
 */
public class Actor {

    // Later on we might want to remove scripts from some other model by using the UUID, so let's save these on hashmap
    HashMap<UUID, Script> scripts;

    String name;
    int health;

    public Actor(String name) {
        scripts = new HashMap<>();
        health = 100;
        this.name = name;
    }

    public boolean addScript(Script script) {
        boolean addedAlready = scripts.containsKey(script.getUUID());
        if (!addedAlready) {
            scripts.put(script.getUUID(), script);
        }

        return addedAlready;
    }

    public void executeScripts(long tick) {
        for (Iterator<HashMap.Entry<UUID, Script>> it = scripts.entrySet().iterator(); it.hasNext();) {
            HashMap.Entry<UUID, Script> entry = it.next();
            
            // Executes the script and removes it if it's done
            if (entry.getValue().execute(tick)) {
                System.out.println("removed");
                it.remove();
            }
        }
    }

    public int calculateDamage() {
        return (int) (Math.random() * 10);
    }

    public int doDamage(int incomingDamage) {
        int calculatedDamage = calculateDamageAfterArmor(incomingDamage);
        health -= calculatedDamage;

        return calculatedDamage;
    }

    private int calculateDamageAfterArmor(int incomingDamage) {
        int amount = Math.max(0, incomingDamage - (int) (Math.random() * 4));
        System.out.println("");
        System.out.println("---" + name + "---");
        System.out.println("Took " + amount + " damage");
        System.out.println("-------------");
        System.out.println("");
        return amount;
    }

    public boolean isAlive() {
        return health > 0;
    }

}
