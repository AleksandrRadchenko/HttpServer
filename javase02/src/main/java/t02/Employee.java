package t02;

import lombok.*;
import t01.OfficeSupply;

import java.math.BigDecimal;
import java.util.ArrayList;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Employee {
    private String name;
    private ArrayList<OfficeSupply> supplies;

    public void addSupply(@NonNull OfficeSupply supply) {
        this.getSupplies().add(supply);
    }

    /**
     * Calculates cost of all office supplies of this employee
     * @return BigDecimal
     */
    public BigDecimal calcSuppliesCost() {
        BigDecimal cost = new BigDecimal(0);
        if (this.getSupplies() != null) {
            for (OfficeSupply supply : this.getSupplies()) {
                cost = cost.add(supply.getPrice());
            }
        }
        return cost;
    }

    public String toString() {
        return "Employee(name=" + this.getName() + ", supplies=" + this.getSupplies() + ")";
    }
}
