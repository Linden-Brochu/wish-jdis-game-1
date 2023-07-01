import java.util.Random;

public class Simulation {
    public static final int STATION_COUNT = 10;
    public Station[] stations;

    public Player p = new Player();
    public Action currentAction = (p, stations) -> {};

    public Simulation(Random r) {
        p.posX = 0;
        p.posY = 0;
        stations = new Station[STATION_COUNT];
        for (int i = 0; i < STATION_COUNT; i++) {
            Station s = new Station();
            s.stationId = i;
            s.lastHarvest = r.nextInt(30, 50);
            s.posX = r.nextInt(-100, 101);
            s.posY = r.nextInt(-100, 101);
            stations[i] = s;
        }
    }

    public void run() {
        currentAction.run(p, stations);
    }

    public String toJSON() {
        return "{\"player\":" + p.toJSON() + ",\"stations\":" + stationJSON() + "}";
    }

    private String stationJSON() {
        String json = "";
        for (int i = 0; i < STATION_COUNT - 1; i++) {
            json += stations[i].toJSON() + ",";
        }
        return "[" + json + stations[STATION_COUNT - 1].toJSON() + "]";
    }
}
