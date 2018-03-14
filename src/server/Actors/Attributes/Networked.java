package server.Actors.Attributes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) //can use in method only.
public @interface Networked{

	public boolean synced() default true;
        public Hashmap<int, int> lastSynced(int playerId)

}
