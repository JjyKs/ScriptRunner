package server.Actors.Attributes;

import server.Actors.Actor;

/**
 *
 * @author JjyKs
 * @param <T>
 */
public class Attribute {

    @Networked
    Actor owner;

    public void setOwner(Actor owner) {
        this.owner = owner;
    }

    public <T extends Attribute> T getAttribute(Class<T> type) {
        return type.cast(this);
    }
}
