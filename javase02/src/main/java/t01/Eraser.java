package t01;

import java.math.BigDecimal;

public class Eraser extends OfficeSupply {
    public Eraser(String name, BigDecimal price) {
        super(name, price);
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        //noinspection SimplifiableIfStatement
        if (!(o instanceof Eraser)) return false;
        return super.equals(o);
    }

    public int hashCode() {
        final int PRIME = 37;
        int result = this.getClass().getSimpleName().hashCode();
        result = result * PRIME + super.hashCode();
        return result;
    }

    public String toString() {
        return "Eraser(name=" + this.getName() + ", price=" + this.getPrice() + ")";
    }
}
