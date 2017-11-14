package httpserver;

public class Launch {

    public static void main(String[] args) {
        SimpleHTTPServer server = new SimpleHTTPServer();
        String[] defaultPort = {"8080"};
        if (args.length != 0) defaultPort = args;
        server.openPort(defaultPort);
    }
}
