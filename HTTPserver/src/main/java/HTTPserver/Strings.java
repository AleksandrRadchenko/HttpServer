package HTTPserver;

public interface Strings {
    String RESPONSE =
            "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n" +
//                            "Content-Length: %d\r\n" +
                    "Connection: close" +
                    "\r\n\r\n%s" +
                    "";

    String PATH = "src/main/resources/HTTPServer/files";

    // Http codes:
    String HTTP_400 = "HTTP/1.1 400 Bad Request";
    String HTTP_404 = "HTTP/1.1 404 Not Found";

    // For debug:
    String FILENAME1 = "src/main/resources/HTTPServer/files/test.txt";
    String FILENAME = "src/main/resources/HTTPServer/files/FileInputStream.html";
}
