package server;

import java.util.UUID;

/**
 *
 * @author JjyKs
 */
interface ScriptInterface {

    /**
     * Executes the script.
     *
     * @param tick
     * @return Is script finished and should it be deleted
     */
    public boolean execute(long tick);

    public UUID getUUID();
}

public abstract class Script implements ScriptInterface {

    private UUID uuid;
    private long executedOnTick;

    public Script() {
        uuid = java.util.UUID.randomUUID();
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public boolean execute(long tick) {
        if (canExecute(tick)) {
            return runImplementation(tick);
        }
        return false;
    }

    public boolean runImplementation(long tick) {
        throw new UnsupportedOperationException("Basescript shouldn't be executed without a script attached on top of it");
    }

    private boolean canExecute(long tick) {
        boolean alreadyExecuted = tick == executedOnTick;
        executedOnTick = tick;

        return alreadyExecuted;
    }

}
