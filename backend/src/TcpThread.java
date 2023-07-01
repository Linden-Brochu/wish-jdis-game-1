import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class TcpThread extends Thread {
    private final int port;
    public volatile boolean running = true;
    public TcpThread(int port) {
        this.port = port;
    }

    public volatile String send = null;
    public volatile String command = null;

    public final Object mutex = new Object();
    @Override
    public void run() {
        SimulationThread t = SingletonManager.getInstance().getSingleton("sim");
        try {
            ServerSocket socket = new ServerSocket(port);
            System.out.println("run on " + port);
            Socket s = socket.accept();
            t.start();

            System.out.println("socket");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));

            while (running) {
                String toSend;
                synchronized (mutex) {
                    toSend = send;
                    send = null;
                }
                if (toSend != null) {
                    writer.write(toSend + "\n");
                    writer.flush();

                    command = reader.readLine();
                }
            }
            writer.write("\n");
            writer.flush();
            System.out.println("end of tcp");
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
