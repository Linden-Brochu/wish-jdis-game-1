public class Player {
    public int posX = 0;
    public int posY = 0;
    public int payload = 0;

    public int money = 10000;

    public boolean at(Station s) {
        return posX == s.posX && posY == s.posY;
    }

    public String toJSON() {
        return "{\"posX\":" + posX + ",\"posY\":" + posY + ",\"payload\":" + payload + ",\"money\":" + money + "}";
    }
}
