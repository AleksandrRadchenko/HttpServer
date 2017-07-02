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

    //    public String getName() {
//        return this.name;
//    }
//
//    public BigDecimal getPrice() {
//        return this.price;
//    }
//
//    public boolean equals(Object o) {
//        if (o == this) return true;
//        if (!(o instanceof OfficeSupply)) return false;
//        final OfficeSupply other = (OfficeSupply) o;
//        final Object this$name = this.getName();
//        final Object other$name = other.getName();
//        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
//        final Object this$price = this.getPrice();
//        final Object other$price = other.getPrice();
//        //noinspection SimplifiableIfStatement
//        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
//        return true;
//    }
//
//    public int hashCode() {
//        final int PRIME = 59;
//        int result = 1;
//        final Object $name = this.getName();
//        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
//        final Object $price = this.getPrice();
//        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
//        return result;
//    }

}
