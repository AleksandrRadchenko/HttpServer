package HTTPserver;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

@Log4j2
public class ConnectionProcessor implements Runnable {
    private Socket socket;
    public ConnectionProcessor(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try (OutputStream os = socket.getOutputStream()) {
            byte[] bytes = FileProcessor.getFile(Strings.FILENAME);
            final String RESPONSE =
                    "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/html\r\n" +
//                            "Content-Length: %d\r\n" +
                            "Connection: close\r\n\r\n%s";
//            byte[] bytes = String.format(RESPONSE, "hi").getBytes();
            os.write(bytes);
            os.flush();
        } catch (IOException e) {
            log.error(e);
        }
    }
}
