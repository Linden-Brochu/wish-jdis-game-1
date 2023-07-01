public class SellAction implements Action {
    @Override
    public void run(Player p, Station[] stations) {
        if (p.posX == 0 && p.posY == 0) {
            p.money += p.payload * 25;
            p.payload = 0;
        }
    }
}
