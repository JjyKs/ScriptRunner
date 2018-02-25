package server;

import java.util.UUID;

/**
 *
 * @author JjyKs
 * @param <T>
 */

public class Attribute {
    
    public <T extends Attribute> T getAttribute(Class<T> type) {
        return type.cast(this);
    }

}
