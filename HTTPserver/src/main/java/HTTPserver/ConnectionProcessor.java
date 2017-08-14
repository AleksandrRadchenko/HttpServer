package HTTPserver;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.net.Socket;

@Log4j2
public class ConnectionProcessor implements Runnable {
    private Socket socket;
    private OutputStream os;
    private InputStream is;

    public ConnectionProcessor(Socket socket) {
        this.socket = socket;
        try {
            os = socket.getOutputStream();
            is = socket.getInputStream();
        } catch (IOException e) {
            log.error("Error while creating socket input/output stream", e);
        }
    }

    public void run() {
            String request = readFromInputStream(is);
//            printRequest(request);
            HttpRequest httpRequest = RequestParser.parse(request);
            if (httpRequest == null) {
                writeResponse(Strings.HTTP_400);
                return;
            }
            byte[] file = FileProcessor.getFile(Strings.PATH + httpRequest.getPath());
            if (file == null) {
                writeResponse(Strings.HTTP_404);
                return;
            }
            writeResponse(String.format(Strings.RESPONSE, new String(file)));
    }

    /**
     * Writing to socket's output stream and closing the socket
     * @param s
     */
    private void writeResponse(String s) {
        try {
            os.write(s.getBytes());
            // TODO: 13.08.2017 serve connection keep-alive status, don't close socket's imput stream
            socket.close();
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * Reads InputStream.available() bytes from inputStream
     * @param inputStream
     * @return
     */
    private String readFromInputStream(InputStream inputStream) {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String s;
        try {
            while ((s = br.readLine()) != null && !s.trim().isEmpty()) {
                sb.append(s);
                sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
            log.error(e);
        }
        return sb.toString();
    }

    /**
     * Temporary method to conveniently print byte[]
     * @param bytes byte array
     */
    private void printBytes(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append((char) b);
        }
        System.out.println(sb);
    }

    /**
     * Temporary method to debuggin request
     * @param request String
     */
    private void printRequest(String request) {
        SimpleHTTPServer.increaseRequestCounter();
        System.out.println("----- REQUEST " + SimpleHTTPServer.getRequestCounter() + " START -----" + System.lineSeparator() + request + System.lineSeparator());
        System.out.println("------ REQUEST " + SimpleHTTPServer.getRequestCounter() + " END ------");
    }
}
