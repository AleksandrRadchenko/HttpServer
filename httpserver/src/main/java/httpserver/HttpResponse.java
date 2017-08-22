package httpserver;

import lombok.Getter;
import lombok.Setter;

/**
 * POJO to contain Http responses.
 */
public class HttpResponse {
    @Setter
    @Getter
    private HttpCodes status;
    private String contentType = "";
    private String contentLength = "";
    private String connection = "";
    private byte[] body = new byte[0];

    @Override
    public String toString() {
        return status.toString() +
                contentType +
                contentLength +
                connection + "\r\n";
    }

    //Getters
    public String getContentType() {
        if (contentType != null && !"".equals(contentType.trim()))
            return contentType.split(": ", 2)[1];
        else
            return "";
    }

    public String getContentLength() {
        if (contentLength != null && !"".equals(contentLength.trim()))
            return contentLength.split(": ", 2)[1];
        else
            return "";
    }

    public String getConnection() {
        if (connection != null && !"".equals(connection.trim()))
            return connection.split(": ", 2)[1];
        else
            return "";
    }

    @SuppressWarnings("WeakerAccess")
    public byte[] getBody() {
        return body;
    }

    //Setters
    @SuppressWarnings("WeakerAccess")
    public void setContentType(final String contentType) {
        if (contentType != null && !"".equals(contentType.trim()))
            this.contentType = "Content-Type: " + contentType + "\r\n";
        else
            this.contentType = "";
    }

    @SuppressWarnings("WeakerAccess")
    public void setContentLength(final String contentLength) {
        if (contentLength != null && !"".equals(contentLength.trim()))
            this.contentLength = "Content-Length: " + contentLength + "\r\n";
        else
            this.contentLength = "";
    }

    @SuppressWarnings("WeakerAccess")
    public void setConnection(final String connection) {
        if (connection != null && !"".equals(connection.trim()))
            this.connection = "Connection: " + connection + "\r\n";
        else
            this.connection = "";
    }

    @SuppressWarnings("WeakerAccess")
    public void setBody(final byte[] body) {
        if (body != null)
            this.body = body;
        else
            this.body = new byte[0];
    }
}
