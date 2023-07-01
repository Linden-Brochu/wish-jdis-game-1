import java.util.Random;

public class Station {
    public int stationId;
    public int lastHarvest;
    public int posX;
    public int posY;

    public String toJSON() {
        return "{\"posX\":" + posX + ",\"posY\":" + posY + ",\"lastHarvested\":" + lastHarvest + ",\"id\":" + stationId + "}";
    }

    public int generate() {
        if (lastHarvest > 0) {
            SingletonManager m = SingletonManager.getInstance();
            Random r = m.getSingleton("random");
            lastHarvest = r.nextInt(Math.max(0, lastHarvest - 10), Math.max(lastHarvest, 0));
        }
        return lastHarvest;
    }
}
