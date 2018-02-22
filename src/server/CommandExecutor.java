package server;

/**
 *
 * @author JjyKs
 */
public class CommandExecutor {
    public void StartFight(Actor actor1, Actor actor2){
        FightScript fightScript = new FightScript(actor1, actor2);
        
        addScriptToActor(actor1, fightScript);
        addScriptToActor(actor2, fightScript);
    }
    
    private void addScriptToActor(Actor actor, Script script){
       actor.addScript(script);
    }
}
