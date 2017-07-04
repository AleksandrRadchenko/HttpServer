package t02;

import lombok.NonNull;

import java.math.BigDecimal;

@SuppressWarnings("WeakerAccess")
public class OfficeSuppliesAccounter {

    public BigDecimal calcSuppliesCost(@NonNull Employee employee) {
        return employee.calcSuppliesCost();
    }

}
