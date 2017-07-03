package t02;

import lombok.NonNull;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OfficeSupliesAccounter {
    private ArrayList<Employee> employees;

    public BigDecimal calcSuppliesCost(@NonNull Employee employee) {
        return employee.calcSuppliesCost();
    }
}
