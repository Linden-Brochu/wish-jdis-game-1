import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int SEED = 1;
        int PORT = 8081;
        Random r = new Random(SEED);

        SingletonManager m = SingletonManager.getInstance();
        TcpThread t = new TcpThread(PORT);
        SimulationThread s = new SimulationThread();

        m.setSingleton("random", r);
        m.setSingleton("tcp", t);
        m.setSingleton("sim", s);

        t.start();
    }
}
