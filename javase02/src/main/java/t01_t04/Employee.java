package t01_t04;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Contains name of employee and ArrayList of his/her office supplies
 */
@Getter
@EqualsAndHashCode
public class Employee {
    private String name;
    private ArrayList<OfficeSupply> supplies;

    @SuppressWarnings({"WeakerAccess", "unchecked"})
    public Employee(String name, ArrayList<OfficeSupply> supplies) {
        this.name = name;
        this.supplies = supplies == null ? null : (ArrayList<OfficeSupply>) supplies.clone();
    }

    @SuppressWarnings("WeakerAccess")
    public void addSupply(@NonNull OfficeSupply supply) {
        this.getSupplies().add(supply);
    }

    /**
     * Removes the first Office supply with the given name.
     * @param supplyName NonNull String
     */
    @SuppressWarnings("WeakerAccess")
    public void removeSupply(@NonNull String supplyName) {
        this.getSupplies().removeIf(supply -> supplyName.equals(supply.getName()));
    }

    /**
     * Calculates cost of all office supplies for this employee
     * @return BigDecimal
     */
    @SuppressWarnings("WeakerAccess")
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
