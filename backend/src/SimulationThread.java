import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import netscape.javascript.JSObject;

import java.util.Random;

public class SimulationThread extends Thread {
    public volatile boolean running = true;


    public SimulationThread() {
    }

    @Override
    public void run() {
        SingletonManager m = SingletonManager.getInstance();
        try {
            Random r = m.getSingleton("random");
            Simulation sim = new Simulation(r);
            TcpThread tcp = m.getSingleton("tcp");

            long timeLeft = 10 * 60 * 1000;

            while (running) {
                long timePass = System.currentTimeMillis();
                System.out.println("new iteration " + timeLeft);
                synchronized (tcp.mutex) {
                    String a = tcp.command;
                    if (a != null && !a.equals("")) {
                        JsonObject object = Json.parse(a).asObject();
                        sim.currentAction = switch (object.getString("type", "")) {
                            case "move" -> new MoveAction(object.getInt("posX", 0), object.getInt("posY", 0));
                            case "harvest" -> new HarvestAction(object.getInt("stationId", -1));
                            case "sell" -> new SellAction();
                            case "end" -> new EndAction();
                            default -> (p, stations) -> {};
                        };

                    }
                }
                sim.run();
                synchronized (tcp.mutex) {
                    tcp.send = sim.toJSON();
                }
                Thread.sleep(1000);
                timeLeft -= System.currentTimeMillis() - timePass;
                if (timeLeft < 0) {
                    running = false;
                    tcp.running = false;
                }
            }
            System.out.println("end of simulation");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
