package t01;

import com.sun.istack.internal.NotNull;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode
@Getter
public abstract class OfficeSupply implements Cloneable{
    private String name;
    private BigDecimal price;

    @SuppressWarnings("WeakerAccess")
    public OfficeSupply(@NotNull String name, @NotNull BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "t01.OfficeSupply(name=" + this.getName() + ", price=" + this.getPrice() + ")";
    }

    protected OfficeSupply clone() {
        try {
            Object cloneObject = super.clone();
            OfficeSupply clone = (OfficeSupply) cloneObject;
//            OfficeSupply clone = (OfficeSupply) super.clone();
//            clone.name = this.getName();
//            clone.price = this.getPrice();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); //throwing AE here, cause this (exception in cloning) should never happen
                                        // (as in Item 2 of the "Effective Java, 2nd edition").
        }
    }

}
