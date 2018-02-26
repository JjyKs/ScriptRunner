package server.Actors.Attributes;

import java.util.UUID;
import server.Actors.Actor;

/**
 *
 * @author JjyKs
 * @param <T>
 */

public class Attribute {
    Actor owner;
    
    public void setOwner(Actor owner){
        this.owner = owner;
    }
    
    public <T extends Attribute> T getAttribute(Class<T> type) {
        return type.cast(this);
    }

}
