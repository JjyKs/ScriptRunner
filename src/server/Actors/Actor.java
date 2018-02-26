package server.Actors;

import server.Actors.Scripts.Script;
import server.Actors.Attributes.Location;
import server.Actors.Attributes.Attribute;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/**
 *
 * @author JjyKs
 */
public class Actor {

    // Later on we might want to remove scripts from some model by using the UUID, so let's save these on hashmap
    HashMap<UUID, Script> scripts;
    HashMap<Class<?>, Attribute> attributes;
    
    public Actor() {
        scripts = new HashMap<>();
        attributes = new HashMap<>();
    }

    public <T extends Attribute> boolean addAttribute(T attribute) {
        boolean addedAlready = attributes.containsKey(attribute.getClass());
        if (!addedAlready) {
            attribute.setOwner(this);
            attributes.put(attribute.getClass(), attribute);
        }

        return addedAlready;
    }

    public <T extends Attribute> T getAttribute(Class<T> type) {
        return attributes.get(type).getAttribute(type);
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
                System.out.println("removed: " + entry.getClass());
                it.remove();
            }
        }
    }
}
