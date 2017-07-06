package t01_t04;


import java.math.BigDecimal;

public class Pen extends OfficeSupply {
    @SuppressWarnings("WeakerAccess")
    public Pen(String name, BigDecimal price) {
        super(name, price);
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        //noinspection SimplifiableIfStatement
        if (!(o instanceof Pen)) return false;
        return super.equals(o);
    }

    public int hashCode() {
        final int PRIME = 37;
        int result = this.getClass().getSimpleName().hashCode();
        result = result * PRIME + super.hashCode();
        return result;
    }

    public String toString() {
        return "Pen(name=" + this.getName() + ", price=" + this.getPrice() + ")";
    }

    @Override
    public Pen clone() {
        return  (Pen) super.clone();
    }
}
