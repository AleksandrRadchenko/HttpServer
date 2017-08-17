package HTTPserver;

public class ServerStarter implements Runnable {
    private String[] port;

    ServerStarter(String[] port) {
        this.port = port;
    }

    @Override
    public void run() {
        SimpleHTTPServer server = new SimpleHTTPServer();
        server.openPort(port);
    }
}
