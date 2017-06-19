package javase01.t01;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task04Test {
    private Task04 t04 = new Task04();
    @Test
    public void returnDouble() {
        assertEquals("Double", ((Object)t04.max(2, 3, 4)).getClass().getSimpleName());
    }

    @Test
    public void getMaxFrom1325() {
        assertEquals(6, t04.max(1, 3, 2, 5), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noArgs() {
        t04.max();
    }

    @Test
    public void oneArg() {
        assertEquals(-1, t04.max(-1), 0.001);
    }

    @Test
    public void negativeArgs() {
        assertEquals(-251, t04.max(-1, -500, -4, -250), 0.001);
    }

    @Test
    public void infinityArgs() {
        assertEquals(Double.POSITIVE_INFINITY, t04.max(Double.POSITIVE_INFINITY, -500, -4, -250), 0.001);
    }

    @Test
    public void infinityArgs2() {
        assertEquals(Double.POSITIVE_INFINITY, t04.max(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, -4, -250), 0.001);
    }

    @Test
    public void positiveAndNegInf() {
        assertEquals(Double.NaN, t04.max(Double.POSITIVE_INFINITY, 3, -4, Double.NEGATIVE_INFINITY), 0.001);
    }

    @Test
    public void nan() {
        assertEquals(Double.NaN, t04.max(Double.NaN, 3, -4, 7), 0.001);
    }

}