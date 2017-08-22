package httpserver;

public interface Strings {
    String RESPONSE =
            HttpCodes._200.toString() +
                    "Content-Type: text/html\r\n" +
//                            "Content-Length: %d\r\n" +
                    "Connection: close" +
                    "\r\n\r\n%s" +
                    "";

    String PATH = "src/main/resources/HTTPServer/files";
//    String MIME_TYPES_PATH = "src/main/resources/mime.types";
    String MIME_TYPES_PATH = "mime.types";

    // For debug:
    String FILENAME1 = "src/main/resources/HTTPServer/files/test.txt";
    String FILENAME = "src/main/resources/HTTPServer/files/FileInputStream.html";
}
