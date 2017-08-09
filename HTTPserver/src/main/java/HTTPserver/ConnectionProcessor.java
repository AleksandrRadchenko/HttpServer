package HTTPserver;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.net.Socket;

@Log4j2
public class ConnectionProcessor implements Runnable {
    private Socket socket;

    public ConnectionProcessor(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try (OutputStream os = socket.getOutputStream();
             InputStream is = socket.getInputStream()) {
            String request = readFromInputStream(is);
            //            byte[] file = "hi".getBytes();
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
            os.write(bytes);
            os.flush();
        } catch (IOException e) {
            log.error(e);
        }
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String i;
        while (br.ready()) {
            sb.append(br.readLine());
            sb.append(System.lineSeparator());
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
