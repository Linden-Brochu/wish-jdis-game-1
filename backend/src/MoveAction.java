public class MoveAction implements Action {
    public int posX;
    public int posY;

    public MoveAction(int x, int y) {
        posX = x;
        posY = y;
    }

    @Override
    public void run(Player p, Station[] stations) {
        int x = posX - p.posX;
        int y = posY - p.posY;
        int speed = 5;
        if (Math.abs(x) <= speed) {
            p.posX = posX;
        } else if (x < 0) {
            p.posX -= speed;
        } else {
            p.posX += speed;
        }
        if (Math.abs(y) <= speed) {
            p.posY = posY;
        } else if (y < 0) {
            p.posY -= speed;
        } else {
            p.posY += speed;
        }
        p.money -= 10 + p.payload;
    }
}
