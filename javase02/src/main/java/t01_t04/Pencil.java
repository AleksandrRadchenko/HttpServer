package t01_t04;

import java.math.BigDecimal;

public class Pencil extends OfficeSupply {
    @SuppressWarnings("WeakerAccess")
    public Pencil(String name, BigDecimal price) {
        super(name, price);
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        //noinspection SimplifiableIfStatement
        if (!(o instanceof Pencil)) return false;
        return super.equals(o);
    }

    public int hashCode() {
        final int PRIME = 37;
        int result = this.getClass().getSimpleName().hashCode();
        result = result * PRIME + super.hashCode();
        return result;
    }

    public String toString() {
        return "Pencil(name=" + this.getName() + ", price=" + this.getPrice() + ")";
    }

    @Override
    public Pencil clone() {
        return  (Pencil) super.clone();
    }
}
