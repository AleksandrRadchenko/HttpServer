package HTTPserver;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.net.Socket;

@Log4j2
public class ConnectionProcessor implements Runnable {
    private Socket socket;
    private OutputStream os;
    private InputStream is;
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;

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
        httpResponse = new HttpResponse();

        //Status
        httpRequest = RequestParser.parse(readFromInputStream(is));
        if (httpRequest == null) {
            httpResponse.setStatus(HttpCodes._400);
            writeResponse(httpResponse);
            return;
        }
        httpResponse.setStatus(HttpCodes._200);

        //ContentType
        httpResponse.setContentType("text/html");

        //Connection
        httpResponse.setConnection("close");

        //Body
        byte[] file = FileProcessor.getFile(Strings.PATH + httpRequest.getPath());
        if (file == null) {
            httpResponse.setStatus(HttpCodes._404);
            writeResponse(httpResponse);
            return;
        }
        httpResponse.setBody(file);

        //Write it out
        writeResponse(httpResponse);
    }

    /**
     * Writing to socket's output stream and closing the socket
     *
     * @param r String to write to the output stream
     */
    private void writeResponse(HttpResponse r) {
        try {
            os.write(r.toString().getBytes());
            os.write(r.getBody());
            log.info(r.getStatus().toString() + " for URI: " + httpRequest.getPath());
            // TODO: 13.08.2017 serve connection keep-alive status, don't close socket's input stream
            socket.close();
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * Reads InputStream.available() bytes from inputStream using readLine()
     *
     * @param inputStream to be read from
     * @return String read from input stream
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
     *
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
     * Temporary method for debugging requests
     *
     * @param request String to print to System.out
     */
    private void printRequest(String request) {
        SimpleHTTPServer.increaseRequestCounter();
        System.out.println("----- REQUEST " + SimpleHTTPServer.getRequestCounter() + " START -----" + System.lineSeparator() + request + System.lineSeparator());
        System.out.println("------ REQUEST " + SimpleHTTPServer.getRequestCounter() + " END ------");
    }
}
