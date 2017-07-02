package t01;

import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class Eraser extends OfficeSupply {
    public Eraser(String name, BigDecimal price) {
        super(name, price);
    }

}
