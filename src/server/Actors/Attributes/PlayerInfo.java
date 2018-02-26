package server.Actors.Attributes;

import server.Actors.Actor;

/**
 *
 * @author JjyKs
 */
public class PlayerInfo extends Attribute {

    private String name;

    public String getName() {
        return name;
    }

    public PlayerInfo(String name) {
        this.name = name; 
    }

}
