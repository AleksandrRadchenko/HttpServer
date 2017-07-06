package t02;

import lombok.NonNull;
import t01.Eraser;
import t01.OfficeSupply;
import t01.Pen;
import t01.Pencil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("WeakerAccess")
public class OfficeSuppliesAccounter {

    /**
     * Calculating cost of @NonNull employee's all supplies.
     * @param employee
     * @return BigDecimal cost. If supplies == null returns new BigDecimal(0).
     */
    @SuppressWarnings("JavaDoc")
    public BigDecimal calcSuppliesCost(@NonNull Employee employee) {
        return employee.calcSuppliesCost();
    }

    /**
     * Creates supply set for new employee from essential supplies.
     * @return ArrayList of supplies.
     */
    public ArrayList<OfficeSupply> getNewbeeSupplySet() {
        ArrayList<OfficeSupply> newbeeSupplySet = new ArrayList<>();
        OfficeSupply pen = new Pen("Stabilo", new BigDecimal(15));
        OfficeSupply pencil = new Pencil("ErichKrause", new BigDecimal(25));
        OfficeSupply eraser = new Eraser("BIC", new BigDecimal("5.50"));
        newbeeSupplySet.add(pen);
        newbeeSupplySet.add(pencil);
        newbeeSupplySet.add(eraser);
        return newbeeSupplySet;
    }

    public void suppliesSortByName(ArrayList<OfficeSupply> supplies) {
        supplies.sort(Comparator.comparing(OfficeSupply::getName));
    }

    public void suppliesSortByPrice(ArrayList<OfficeSupply> supplies) {
        supplies.sort(Comparator.comparing(OfficeSupply::getPrice));
    }

    public void suppliesSortByPriceAndName(ArrayList<OfficeSupply> supplies) {
        supplies.sort(Comparator.comparing(OfficeSupply::getPrice).thenComparing(OfficeSupply::getName));
    }
}
