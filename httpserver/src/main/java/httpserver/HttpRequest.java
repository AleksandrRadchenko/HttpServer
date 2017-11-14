package httpserver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * POJO to contain Http requests.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class HttpRequest {
    private HttpMethod httpMethod;
    private String path;
    private Protocol protocol;
    private Map<String, String> headers;
//    private String messageBody;
}
