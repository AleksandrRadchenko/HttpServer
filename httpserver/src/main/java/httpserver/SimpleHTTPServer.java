package httpserver;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class to start the server. Each socket, created by ServerSocket.accept() is provided to
 * executor service. Port parse and server socket error's handling here.
 */
@SuppressWarnings("WeakerAccess")
public class SimpleHTTPServer {
    private ServerSocket ss;
    @Getter
    private static int requestCounter = 0;
    private static Logger log = new Logger();
    static void increaseRequestCounter() {
        requestCounter++;
    }

    /**
     * Starts HTTP server on specified port
     * @param args first argument should be port to start HTTP server on in String representation.
     *             For example: "8080". Should be in range 1024 < port < 65536.
     * @return 1 if all ok, -1 if cant' parse for port number, 0 if no args provided
     */
    @SneakyThrows
    public int openPort(String[] args) {
        int result;
        if ((args == null) || (args.length < 1)) {
            log.info("Port to listen not specified");
            result = 0;
        } else {
            try {
                int port = Integer.parseInt(args[0]);
                if (port < 1025 || port > 65535) {
                    log.error("Port should be in range 1025-65535");
                    result = 0;
                } else {
                    log.info("specified port = " + port);
                    result = 1;
                    ss = new ServerSocket(port); // Starting server
                    log.info(String.format("Server started: http:/%s:%d%n", ConnectionProcessor.getLocalIpAddr(), port));
                    ExecutorService executorService = Executors.newCachedThreadPool();
                    while (!Thread.currentThread().isInterrupted()) {
                        // Processing request
                        Socket s = ss.accept();
//                        Single thread for debugging purposes
//                        ConnectionProcessor cp = new ConnectionProcessor(s);
//                        cp.run();
                        // TODO: 15.08.2017 singlethread -> multithread 
                        executorService.execute(new ConnectionProcessor(s));
                        log.info("Processing finished, request counter = " + requestCounter++);
                    }
                }
            } catch (NumberFormatException e) {
                log.error("can't parse " + e.getMessage() + ". Please specify correct port.");
                result = -1;
            } catch (IOException e) {
                log.error("can't start " + e.getMessage() + ". Please specify correct port.");
                throw e;
            } finally {
                try {
                    if (ss != null) ss.close();
                } catch (IOException e) {
                    log.error("Error while closing server socket, " + e.getMessage());
                }
            }
        }
        return result;
    }

}
