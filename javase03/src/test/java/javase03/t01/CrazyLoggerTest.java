package javase03.t01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CrazyLoggerTest {
    private CrazyLogger cl = new CrazyLogger();
    private String expectedString;
    private String actualString;

    @Before
    public void loggingSomeStuff() {
        cl.log("asdsad1");
        cl.log("asdsad2");
        cl.log("123asdsad2123");
        cl.log("asd1sad2");
        cl.log("asdsad22");
    }

    @Test
    public void testLogger() throws Exception {
        actualString = cl.printAll();
        assertTrue(actualString.contains(" - asdsad1;"));
        assertTrue(actualString.contains(" - asdsad2;"));
    }

    @Test
    public void search() throws Exception {
        assertTrue(cl.search("asdsad2").size() == 3);
    }
}