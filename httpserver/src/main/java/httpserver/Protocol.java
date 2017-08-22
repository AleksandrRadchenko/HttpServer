package httpserver;

import lombok.Getter;
import lombok.Setter;

/**
 * Holds String field version for HTTP protocol.
 */
public enum Protocol {
    HTTP;

    @Setter
    @Getter
    private String version;
}
