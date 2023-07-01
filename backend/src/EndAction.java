public class EndAction implements Action {
    @Override
    public void run(Player p, Station[] stations) {
        SingletonManager m = SingletonManager.getInstance();
        TcpThread tcp = m.getSingleton("tcp");
        SimulationThread sim = m.getSingleton("sim");
        tcp.running = false;
        sim.running = false;
    }
}
