import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random(Constant.SEED);

        SingletonManager m = SingletonManager.getInstance();
        TcpThread t = new TcpThread(Constant.PORT);
        SimulationThread s = new SimulationThread();
        Window window = new Window();

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                t.running = false;
                s.running = false;
            }
        });

        m.setSingleton("random", r);
        m.setSingleton("tcp", t);
        m.setSingleton("sim", s);
        m.setSingleton("window", window);

        t.start();
    }
}
