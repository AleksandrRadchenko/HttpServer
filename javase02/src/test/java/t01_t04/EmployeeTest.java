package t01_t04;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;


public class EmployeeTest {
    private Employee e1;

    @Before
    public void creatingEmpoyee() throws Exception {
        String name = "Ivan";
        ArrayList<OfficeSupply> supplies = new ArrayList<>();
        supplies.add(new Pen("Stabilo", new BigDecimal(30)));
        supplies.add(new Pencil("Luch", new BigDecimal(4)));
        supplies.add(new Eraser("Bic", new BigDecimal(3)));
        e1 = new Employee(name, supplies);
    }

    @Test
    public void toStringTest() throws Exception {
        assertTrue(("Employee(name=Ivan, supplies=[Pen(name=Stabilo, price=30), Pencil(name=Luch, price=4), " +
                "Eraser(name=Bic, price=3)])").equals(e1.toString()));
    }

    @Test
    public void addingSuplyIncreasesSuppliesSize() throws Exception {
        int oldSize = e1.getSupplies().size();
        ArrayList<OfficeSupply> supplies = e1.getSupplies();
        supplies.add(new Pen("ErichKrause", new BigDecimal(27)));
        int newSize = e1.getSupplies().size();
        assertTrue(newSize - oldSize == 1);
    }

    @Test(expected = NullPointerException.class)
    public void cantAddNullSupply() throws Exception {
        e1.addSupply(null);
    }

    @Test
    public void removeSupply() throws Exception {
        int oldSize = e1.getSupplies().size();
        e1.removeSupply("Luch");
        assertTrue(e1.getSupplies().size() == oldSize - 1);
    }

    @Test(expected = NullPointerException.class)
    public void cantRemoveNullSupply() throws Exception {
        e1.removeSupply(null);
    }

    @Test
    public void removeSupplyWithNoName() throws Exception {
        int oldSize = e1.getSupplies().size();
        e1.removeSupply("");
        assertTrue(e1.getSupplies().size() == oldSize);
    }

    @Test
    public void removeNonExistentSupply() throws Exception {
        int oldSize = e1.getSupplies().size();
        e1.removeSupply("asdjh4@kjh3h58&611kjhs");
        assertTrue(e1.getSupplies().size() == oldSize);
    }

    @Test
    public void calcSupplyCostForEmployee() throws Exception {
        BigDecimal supplyCost = e1.calcSuppliesCost();
        assertTrue(supplyCost.equals(new BigDecimal(30+4+3)));
    }

}