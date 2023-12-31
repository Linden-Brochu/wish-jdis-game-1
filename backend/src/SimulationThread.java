import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import netscape.javascript.JSObject;

import javax.swing.*;
import java.util.Random;

public class SimulationThread extends Thread {
    public volatile boolean running = true;

    @Override
    public void run() {
        SingletonManager m = SingletonManager.getInstance();

        Random r = m.getSingleton("random");
        Simulation sim = new Simulation(r);
        TcpThread tcp = m.getSingleton("tcp");

        Window window = m.getSingleton("window");
        window.setVisible(true);
        window.setSimulation(sim);
        try {
            long timeLeft = Constant.SIMULATION_LENGTH;

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

                window.setTimeLeft(timeLeft);
                window.repaint();

                Thread.sleep(Constant.SLEEP_TIME);
                timeLeft -= System.currentTimeMillis() - timePass;
                if (timeLeft < 0 || sim.p.money < 0) {
                    running = false;
                    tcp.running = false;
                }
            }
            System.out.println("account is " + sim.p.money);
            System.out.println("end of simulation");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.dispose();
    }
}
