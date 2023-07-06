import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    public Simulation simulation;
    public long timeLeft;

    @Override
    public void paint(Graphics g) {
        int halfWidth = Constant.WINDOW_WIDTH / 2;
        int halfHeight = Constant.WINDOW_HEIGHT / 2;

        super.paint(g);
        if (simulation != null) {
            g.setColor(new Color(177, 177, 177));
            g.drawRect(0, 0, getWidth(), getHeight());
            g.setColor(new Color(0,0,0));

            Player p = simulation.p;

            g.drawRect(p.posX - 2 + halfWidth, p.posY - 2 + halfHeight, 4, 4);

            g.setColor(new Color(255, 0, 0));

            for (Station s : simulation.stations) {
                g.drawRect(s.posX - 1 + halfWidth, s.posY - 1 + halfHeight, 2, 2);
            }

            g.setColor(new Color(0, 255, 0));
            g.drawRect(-3 + halfWidth, -3 + halfHeight, 6, 6);

            if (simulation.currentAction instanceof Drawable) {
                ((Drawable)simulation.currentAction).draw(g, p);
            }

            g.setColor(new Color(0,0,0));
            g.drawString("Money: " + p.money, 15, 15);
            g.drawString("Payload: " + p.payload, 15, 30);
            g.drawString("Time left: " + timeLeft / 1000, 15, 45);
        }
    }
}
