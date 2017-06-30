package t01;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Pen {
    private String name;
    private BigDecimal price;

    /**
     * Creates new Pen with default name = "Pen" and price = 1.00;
     */
    public Pen() {
        setName("Pen");
        setPrice(new BigDecimal("1.00"));
    }

    /**
     * Creates new Pen with default price = 1.00;
     * @param name
     */
    public Pen(String name) {
        setName(name);
        setPrice(new BigDecimal("1.00"));
    }

    public Pen(String name, BigDecimal price) {
        setName(name);
        setPrice(price);
    }
}
