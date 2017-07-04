package t02;

import org.junit.Before;
import org.junit.Test;
import t01.Eraser;
import t01.OfficeSupply;
import t01.Pen;
import t01.Pencil;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class OfficeSuppliesAccounterTest {

    private OfficeSuppliesAccounter osa = new OfficeSuppliesAccounter();
    private Employee e1, e2, employeeWithNoSupplies;

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
        osa.addEmployee(e1);
    }

    @Test
    public void addEmployee() throws Exception {
        int employeesListSize = osa.getEmployees().size();
        osa.addEmployee(e1);
        assertTrue(employeesListSize == osa.getEmployees().size() - 1);
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



}