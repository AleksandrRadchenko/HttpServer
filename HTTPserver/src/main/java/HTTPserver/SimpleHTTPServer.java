package HTTPserver;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SimpleHTTPServer {
    /**
     * Starts HTTP server on specified port
     * @param args first argument should be port to start HTTP server on in String representation.
     *             For example: "8080"
     * @return 1 if all ok, -1 if cant' parse for port number, 0 if no args provided
     */
    public int openPort(String[] args) {
        int result = 0;
        if (args.length < 1) {
            log.info("Port to listen not specified");
            result = 0;
        } else {
            try {
                int port = Integer.parseInt(args[0]);
                log.info("specified port = " + port);
                result = 1;
            } catch (NumberFormatException e) {
                log.error("can't parse " + e.getMessage() + ". Please specify correct port.");
                result = -1;
            }
        }
        return result;
    }
}
