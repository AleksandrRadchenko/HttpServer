package httpserver;

public enum HttpCodes {
    _200("HTTP/1.1 200 OK"),
    _400("HTTP/1.1 400 Bad Request"),
    _404("HTTP/1.1 404 Not Found");

    private final String codeString;

    HttpCodes(String codeString) {
        this.codeString = codeString;
    }

    @Override
    public String toString() {
        return codeString;
    }

}
