import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private DrawingPanel panel = new DrawingPanel();
    public Window() {
        setName("JDIS Wish 2023");
        setSize(Constant.WINDOW_HEIGHT + 16, Constant.WINDOW_HEIGHT + 39);
        add(panel);
        setResizable(false);
    }

    public void setTimeLeft(long timeLeft) {
        panel.timeLeft = timeLeft;
    }

    public void setSimulation(Simulation s) {
        panel.simulation = s;
    }
}
