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
            SimpleHTTPServer.increaseRequestCounter();
            System.out.println("----- REQUEST " + SimpleHTTPServer.getRequestCounter() + " START -----" + System.lineSeparator() + request + System.lineSeparator());
            System.out.println("------ REQUEST " + SimpleHTTPServer.getRequestCounter() + " END ------");
            byte[] file = FileProcessor.getFile(Strings.FILENAME1);
            final String RESPONSE =
                    "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/html\r\n" +
//                            "Content-Length: %d\r\n" +
//                            "Connection: close" +
                            "\r\n\r\n%s" +
                            "";
            byte[] bytes = String.format(RESPONSE, new String(file)).getBytes();
//            printBytes(bytes);
        try {
            os.write(bytes);
            os.flush();
            socket.close();
        } catch (IOException e) {
            log.error(e);
        }
    }

    private void writeResponse(String s) {

    }

    private String readFromInputStream(InputStream inputStream) {
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        StringBuilder sb = new StringBuilder();
        try {
            while (bis.available() > 0) {
                sb.append((char)bis.read());
            }
        } catch (IOException e) {
            log.error(e);
        }
        return sb.toString();
    }

//    private String readFromInputStream(InputStream inputStream) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//        StringBuilder sb = new StringBuilder();
//        int i;
//        while ((i = br.read()) > -1)
//            sb.append((char)i);
//        return sb.toString();
//    }
//
    private void printBytes(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append((char) b);
        }
        System.out.println(sb);
    }
}
