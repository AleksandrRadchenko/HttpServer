package t01;

import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode
@Getter
public abstract class OfficeSupply {
    private String name;
    private BigDecimal price;

    public OfficeSupply(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "t01.OfficeSupply(name=" + this.getName() + ", price=" + this.getPrice() + ")";
    }


}
