package httpserver;

import lombok.Getter;
import lombok.Setter;

public enum Protocol {
    HTTP;

    @Setter
    @Getter
    private String version;
}
