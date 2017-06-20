package javase01.t01;

import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class Task02Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    // Setting environment to test System.out content.
    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    //Testing normal output
    @Test
    public void normalRunFrom0_02() {
        String[] args = {"0.02"};
        String expectedOutput = String.format("%s%n%s%n%s%n", "E=0,020000",
                "Number of the least element, which satisfies M condition: 7",
                "Elements: a_1=0,250000, a_2=0,111111, a_3=0,062500, a_4=0,040000, a_5=0,027778, a_6=0,020408, a_7=0,015625");
        Task02.calcAndPrintN(args);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test(expected = NumberFormatException.class)
    public void notParsableArgs() {
        String[] args = {"asd"};
        Task02.calcAndPrintN(args);
    }

    @Test(expected = InvalidParameterException.class)
    public void NoArgs() {
        String[] args = {};
        Task02.calcAndPrintN(args);
    }

    @Test(expected = InvalidParameterException.class)
    public void negativeArgs() {
        String[] args = {"-5"};
        Task02.calcAndPrintN(args);
    }

    @Test(expected = InvalidParameterException.class)
    public void negativeInfArgs() {
        String[] args = {"-Infinity"};
        Task02.calcAndPrintN(args);
    }

    @Test(expected = InvalidParameterException.class)
    public void zeroArgs() {
        String[] args = {"0"};
        Task02.calcAndPrintN(args);
    }

    @Test
    public void infinityArgs() {
        String[] args = {"Infinity"};
        String expectedOutput = String.format("%s%n%s%n%s%n", "E=Infinity",
                "Number of the least element, which satisfies M condition: 1",
                "Elements: a_1=0,250000");
        Task02.calcAndPrintN(args);
        assertEquals(expectedOutput, outContent.toString());
    }

}