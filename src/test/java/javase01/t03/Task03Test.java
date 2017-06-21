package javase01.t03;

import static org.junit.Assert.*;
import static java.lang.Math.*;

import org.junit.*;
import java.util.*;

public class Task03Test {
    private Task03 task03 = new Task03();

    @Test(expected = IllegalArgumentException.class)
    public void bOverA() {
        double a = 5;
        double b = 2;
        double c = 5;
        task03.printAsTable(task03.F(a, b, c));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeStep() {
        double a = 5;
        double b = 200;
        double c = -5;
        task03.printAsTable(task03.F(a, b, c));
    }

    @Test(expected = IllegalArgumentException.class)
    public void aEqualsB() {
        double a = 5;
        double b = 5;
        double c = 5;
        task03.printAsTable(task03.F(a, b, c));
    }
    @Test
    public void normalRunRowsCount() {
        Map<Double, Double> result = task03.F(3 * PI / 8, 5 * PI / 8, PI / 8);
        assertEquals(3, result.keySet().size());
    }

}