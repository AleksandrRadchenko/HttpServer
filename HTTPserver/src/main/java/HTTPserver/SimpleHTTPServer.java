package HTTPserver;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Log4j2
public class SimpleHTTPServer {
    /**
     * Starts HTTP server on specified port
     * @param args first argument should be port to start HTTP server on in String representation.
     *             For example: "8080"
     * @return 1 if all ok, -1 if cant' parse for port number, 0 if no args provided
     */
    private ServerSocket ss;
    @SneakyThrows
    public int openPort(String[] args) {
        int result = 0;
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
                    log.printf(Level.INFO, "Server started: http:/%s:%d", getLocalIpAddr(), port);
                    ExecutorService executorService = Executors.newCachedThreadPool();
                    while (!Thread.currentThread().isInterrupted()) {
                        executorService.execute(new ConnectionProcessor(ss.accept()));
                        log.info("Processing finished");
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
                    log.error("Error while closing server socket", e);
                }
            }
        }
        return result;
    }

    @SneakyThrows
    /**
     * Returns first fount ip addres, which contains "192" or "10.0"
     */
    private static String getLocalIpAddr() {
        Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
        List<InterfaceAddress> addrList = new ArrayList<>();
        while (ifaces.hasMoreElements()) {
            addrList.addAll(ifaces.nextElement().getInterfaceAddresses());
        }
        // Getting first local addr
        String localAddr = "";
        for (InterfaceAddress interfaceAddress : addrList) {
            localAddr = interfaceAddress.getAddress().toString();
            if (localAddr.contains("192") || localAddr.contains("10.0"))
                break;
        }
        return localAddr;
    }
}
