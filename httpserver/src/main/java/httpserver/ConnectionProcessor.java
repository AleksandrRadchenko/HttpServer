package httpserver;

import lombok.SneakyThrows;

import java.io.*;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Processes provided socket for HttpRequest, forms HttpResponse object and
 * writes it to the socket's output stream.
 */
public class ConnectionProcessor implements Runnable {
    private Logger log = new Logger();
    private Socket socket;
    private OutputStream os;
    private InputStream is;
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;

    ConnectionProcessor(Socket socket) {
        this.socket = socket;

        try {
            os = socket.getOutputStream();
            is = socket.getInputStream();
        } catch (IOException e) {
            log.error("Error while creating socket input/output stream. " + e.getMessage());
        }
    }

    /**
     * Forms HttpResponse object and writes it to socket's output stream.
     */
    public void run() {
        httpResponse = new HttpResponse();

        //Status
        httpRequest = RequestParser.parse(readStringFromInputStream(is));
        if (httpRequest == null) {
            httpResponse.setStatus(HttpCodes._400);
            writeResponse(httpResponse);
            return;
        }
        httpResponse.setStatus(HttpCodes._200);

        //ContentType
        httpResponse.setContentType(RequestParser.getMimeType(httpRequest.getPath()));

        //Connection
        httpResponse.setConnection("close");

        //Body
        byte[] file = FileProcessor.readFromFile(Strings.PATH + httpRequest.getPath());
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
            os.flush();
            log.info(r.getStatus().toString() + (httpRequest == null ? "" : " for URI: " + httpRequest.getPath()) );
            // TODO: 13.08.2017 serve connection keep-alive status, don't close socket's input stream
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    /**
     * Reads InputStream.available() bytes from inputStream using readLine()
     *
     * @param inputStream to be read from
     * @return String read from input stream
     */
    private String readStringFromInputStream(InputStream inputStream) {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String s;
        try {
            while ((s = br.readLine()) != null && !s.trim().isEmpty()) {
                sb.append(s);
                sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return sb.toString();
    }

    /**
     * Returns first found local ip address, which contains "192" or "10.0".
     * @return String representation of IP address, like "192.168.0.78" or
     * empty String if none address wich begins from "10.0" or "192" found.
     */
    @SneakyThrows
    static String getLocalIpAddr() {
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
