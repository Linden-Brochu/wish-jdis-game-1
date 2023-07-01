public class HarvestAction implements Action {
    public int stationId;

    public HarvestAction(int stationId) {
        this.stationId = stationId;
    }

    @Override
    public void run(Player p, Station[] stations) {
        if (stationId < Simulation.STATION_COUNT && stationId >= 0) {
            Station s = stations[stationId];
            if (p.at(s)) {
                p.payload += s.generate();
                p.money -= 100;
            }
        }
    }
}
