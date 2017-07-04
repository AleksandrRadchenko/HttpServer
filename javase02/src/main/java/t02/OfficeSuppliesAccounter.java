package t02;

import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.ArrayList;

@SuppressWarnings("WeakerAccess")
@Getter
public class OfficeSuppliesAccounter {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(@NonNull Employee employee) {
        employees.add(employee);
    }

    public BigDecimal calcSuppliesCost(@NonNull Employee employee) {
        return employee.calcSuppliesCost();
    }

}
