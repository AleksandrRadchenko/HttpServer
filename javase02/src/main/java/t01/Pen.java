package t01;

import lombok.*;

import java.math.BigDecimal;

@Value
public class Pen {
    private String name;
    private BigDecimal price;

//    /**
//     * Creates new Pen with default name = "Pen" and price = 1.00;
//     */
//    public Pen() {
//        this.name = "Pen";
//        this.price = new BigDecimal("1.00");
//    }
//
//    /**
//     * Creates new Pen with default price = 1.00;
//     * @param name
//     */
//    public Pen(String name) {
//        this.name = name;
//        this.price = new BigDecimal("1.00");
//    }
//
//    /**
//     * Creates new Pen with default name = "Pen";
//     * @param price
//     */
//    public Pen(BigDecimal price) {
//        this.name = "Pen";
//        this.price = new BigDecimal("1.00");
//    }

}
