package HTTPserver;

import java.util.HashMap;
import java.util.Map;

public interface RequestParser {
    org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(RequestParser.class);

    static HttpRequest parse(String request) {
        HttpRequest httpRequest = new HttpRequest();

        // GET ...
        String[] requestElements = request.trim().split("\\s+", 2);
        try {
            httpRequest.setHttpMethod(HttpMethod.valueOf(requestElements[0]));
        } catch (NullPointerException | IllegalArgumentException e) {
            log.error(e);
            return null; // Sorry
        }

        // /path/file.ext HTTP/1.1...
        requestElements = requestElements[1].trim().split("\\s+", 2);
        if (requestElements[0].startsWith("/"))
            httpRequest.setPath(requestElements[0]);
        else
            return null; // Sorry twice

        // HTTP/1.1 Host: 127.0.0.1:8080
        requestElements = requestElements[1].trim().split("\\s+", 2);
        String[] protocol = requestElements[0].trim().split("/", 2);
        try {
            httpRequest.setProtocol(Protocol.valueOf(protocol[0]));
            httpRequest.getProtocol().setVersion(protocol[1]);
        } catch (NullPointerException | IllegalArgumentException e) {
            log.error(e);
            return null; // Sorry again
        }

        // Host: 127.0.0.1:8080 and other headers
        // TODO: 14.08.2017 detect empty line as headers end 
        Map<String, String> headers = new HashMap<>();
        String[] sHeaders = requestElements[1].trim().split("\\r?\\n");
        for (String s : sHeaders) {
            String[] header = s.split(":\\s+", 2);
            headers.put(header[0], header[1]);
        }
        httpRequest.setHeaders(headers);

// TODO: 14.08.2017 body 
        return httpRequest;
    }
    
    static void parsePath(String path) {
        // TODO: 14.08.2017 form response type according to file type 
    }
}
