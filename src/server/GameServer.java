package server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Tools.CommandExecutor;
import server.Actors.Actor;
import server.Actors.Factories.PlayerFactory;

/**
 *
 * @author JjyKs
 */
public class GameServer {

    final long TICKMS = 1;
    final int TCPPORT = 1995;
    final int UDPPORT = 1996;

    long serverTick;
    long loopLastRunTime;
    CommandExecutor cmdExec;
    Server server;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.gameLoop();
    }

    public GameServer() {
        loopLastRunTime = 0;
        serverTick = 0;
        cmdExec = new CommandExecutor();

        server = new Server() {
            protected Connection newConnection() {
                return new PlayerConnection();
            }
        };

        Kryo kryo = server.getKryo();
        kryo.register(HashMap.class);

        server.addListener(new Listener() {
            public void received(Connection c, Object object) {
                System.out.println("asd");
                // We know all connections for this server are actually CharacterConnections.
                PlayerConnection connection = (PlayerConnection) c;

                if (object instanceof Object) {
                }
            }

            public void disconnected(Connection c) {
            }

        });
        try {
            server.bind(TCPPORT, UDPPORT);
            server.start();

        } catch (IOException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void gameLoop() {
        Actor player1 = PlayerFactory.makePlayer("player1");
        Actor player2 = PlayerFactory.makePlayer("player2");
        cmdExec.StartFight(player1, player2);

        while (true) {
            long loopStartTime = System.currentTimeMillis();
            if (loopLastRunTime + TICKMS <= loopStartTime) {
                loopLastRunTime = loopStartTime;
                serverTick++;
                //System.out.println("Servertick: " + serverTick);
                process();
                player1.executeScripts(serverTick);
                player2.executeScripts(serverTick);
            }
            long loopElapsedTime = System.nanoTime() - loopStartTime;
        }
    }

    public void process() {
        //System.out.println("processed: " + System.currentTimeMillis());
    }

}
