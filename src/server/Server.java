package server;

/**
 *
 * @author JjyKs
 */
public class Server {

    final long TICKMS = 600;
    long serverTick;
    long loopLastRunTime;
    CommandExecutor cmdExec;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.gameLoop();
    }

    public Server() {
        loopLastRunTime = 0;
        serverTick = 0;
        cmdExec = new CommandExecutor();
    }

    public void gameLoop() {
        Actor player1 = new Actor("player1");
        Actor player2 = new Actor("player2");
        cmdExec.StartFight(player1, player2);

        while (true) {
            long loopStartTime = System.currentTimeMillis();
            if (loopLastRunTime + TICKMS <= loopStartTime) {
                loopLastRunTime = loopStartTime;
                serverTick++;
                System.out.println("Servertick: " + serverTick);
                process();
                player1.executeScripts(serverTick);
                player2.executeScripts(serverTick);
            }
            long loopElapsedTime = System.nanoTime() - loopStartTime;
        }
    }

    public void process() {
        System.out.println("processed: " + System.currentTimeMillis());
    }
}
