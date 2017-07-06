package t01_t04;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class OfficeSuppliesAccounterTest {

    private OfficeSuppliesAccounter osa = new OfficeSuppliesAccounter();
    private Employee e1, e2, employeeWithNoSupplies;
    private ArrayList<OfficeSupply> newbeeSet = new ArrayList<>();
    private ArrayList<OfficeSupply> setToTestSortByPriceAndName = new ArrayList<>();

    @Before
    public void createFewEmployees() throws Exception {
        String name = "Ivan";
        ArrayList<OfficeSupply> supplies = new ArrayList<>();
        supplies.add(new Pen("Stabilo", new BigDecimal(30)));
        supplies.add(new Pencil("Luch", new BigDecimal(4)));
        e1 = new Employee(name, supplies);
        name = "Pavel";
        supplies.add(new Eraser("Bic", new BigDecimal(3)));
        e2 = new Employee(name, supplies);
        employeeWithNoSupplies = new Employee("Vanya", null);
        newbeeSet = osa.getNewbeeSupplySet();
        //Initialising setToTestSortByPriceAndName
        OfficeSupply pen = new Pen("Stabilo", new BigDecimal(15));
        OfficeSupply pencil = new Pencil("ErichKrause", new BigDecimal(25));
        OfficeSupply pencil2 = new Pencil("Edding", new BigDecimal(25));
        OfficeSupply eraser = new Eraser("BIC", new BigDecimal("5.50"));
        setToTestSortByPriceAndName.add(pen);
        setToTestSortByPriceAndName.add(pencil);
        setToTestSortByPriceAndName.add(pencil2);
        setToTestSortByPriceAndName.add(eraser);
    }

    @Test
    public void calcSuppliesCost() throws Exception {
        BigDecimal suppliesCost = osa.calcSuppliesCost(e1);
        assertTrue(suppliesCost.equals(new BigDecimal(34)));
        assertTrue(osa.calcSuppliesCost(e2).equals(new BigDecimal(37)));
    }

    @Test
    public void calcEmptySuppliesCost() throws Exception {
        BigDecimal suppliesCost = osa.calcSuppliesCost(employeeWithNoSupplies);
        assertTrue(suppliesCost.equals(new BigDecimal(0)));
    }

    @Test
    public void createEployeeWithNewbeeSet() throws Exception {
        Employee newbee = new Employee("Lena", osa.getNewbeeSupplySet());
        BigDecimal suppliesCost = osa.calcSuppliesCost(newbee);
        assertTrue(suppliesCost.equals(new BigDecimal("45.50")));
    }

    @Test
    public void threeSuppliesInNewbeeSet() throws Exception {
        ArrayList<OfficeSupply> newbeeSet = osa.getNewbeeSupplySet();
        assertTrue(newbeeSet.size() == 3);
    }

    @Test
    public void suppliesSortedByName() throws Exception {
        osa.suppliesSortByName(newbeeSet);
        ArrayList<String> expectedNamesList = new ArrayList<>(Arrays.asList("BIC", "ErichKrause", "Stabilo"));
        ArrayList<String> newbeeNamesList = new ArrayList<>();
        for (OfficeSupply supply : newbeeSet) {
            newbeeNamesList.add(supply.getName());
        }
        assertTrue(expectedNamesList.equals(newbeeNamesList));
    }

    @Test
    public void suppliesSortedByPrice() throws Exception {
        osa.suppliesSortByPrice(newbeeSet);
        ArrayList<BigDecimal> expectedPricesList = new ArrayList<>(Arrays.asList(
                new BigDecimal("5.50"),
                new BigDecimal(15),
                new BigDecimal(25)));
        ArrayList<BigDecimal> newbeePricesList = new ArrayList<>();
        for (OfficeSupply supply : newbeeSet) newbeePricesList.add(supply.getPrice());
        assertTrue(expectedPricesList.equals(newbeePricesList));
    }

    @Test
    public void suppliesSortedByPriceAndName() throws Exception {
        osa.suppliesSortByPriceAndName(setToTestSortByPriceAndName);
        ArrayList<String> expectedNamesList = new ArrayList<>(Arrays.asList("BIC", "Stabilo", "Edding", "ErichKrause"));
        ArrayList<String> sortedNamesList = new ArrayList<>();
        for (OfficeSupply supply : setToTestSortByPriceAndName) {
            sortedNamesList.add(supply.getName());
        }
        assertTrue(expectedNamesList.equals(sortedNamesList));
    }

}