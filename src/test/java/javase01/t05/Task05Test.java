package javase01.t05;

import org.junit.Test;

public class Task05Test {
    private Task05 t05 = new Task05();

    @Test(expected = IllegalArgumentException.class)
    public void negativeArg() throws Exception {
        t05.printMatrix(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroArg() throws Exception {
        t05.printMatrix(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minValueArg() throws Exception {
        t05.printMatrix(Integer.MIN_VALUE);
    }

}