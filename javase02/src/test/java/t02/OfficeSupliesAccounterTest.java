package t02;

import org.junit.Before;
import org.junit.Test;
import t01.Eraser;
import t01.OfficeSupply;
import t01.Pen;
import t01.Pencil;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OfficeSupliesAccounterTest {
    OfficeSupliesAccounter osa = new OfficeSupliesAccounter();
    @Before
    public void createFewEmployees() throws Exception {
        String name = "Ivan";
        ArrayList<OfficeSupply> supplies = new ArrayList<>();
        supplies.add(new Pen("Stabilo", new BigDecimal(30)));
        supplies.add(new Pencil("Luch", new BigDecimal(4)));
        Employee e1 = new Employee(name, supplies);
        name = "Pavel";
        supplies.add(new Eraser("Bic", new BigDecimal(3)));
        Employee e2 = new Employee(name, supplies);

//        osa.addEmployee(e1);
    }

    @Test
    public void calcSuppliesCost() throws Exception {

    }



}