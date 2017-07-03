package t02;

import org.junit.Before;
import org.junit.Test;
import t01.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by ara on 03.07.2017.
 */
public class EmployeeTest {
    Employee e1;

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
        Pen nullPen = null;
        e1.addSupply(nullPen);
    }

    @Test
    public void calcSupplyCostForEmployee() throws Exception {
        BigDecimal supplyCost = e1.calcSuppliesCost();
        assertTrue(supplyCost.equals(new BigDecimal(30+4+3)));
    }

}