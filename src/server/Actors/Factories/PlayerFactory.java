package server.Actors.Factories;

import server.Actors.Actor;
import server.Actors.Attributes.CombatStats;
import server.Actors.Attributes.PlayerInfo;

/**
 *
 * @author JjyKs
 */
public class PlayerFactory {

    public static Actor makePlayer(String name) {
        Actor actor = new Actor();
        actor.addAttribute(new CombatStats());
        actor.addAttribute(new PlayerInfo(name));
        
        
        return actor;
    }
}
