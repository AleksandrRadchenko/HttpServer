package javase01.t01;

//import org.junit.jupiter.api.Test;
import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

public class Task02Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void printNof0_003() {
        String[] args = {"0.003"};
        String expectedOutput = String.format("%s%n%s%n%s%s%s%n", "E=0,003000",
                "Number of the least element, which satisfies M condition: 18",
                "Elements: a_1=0,250000, a_2=0,111111, a_3=0,062500, a_4=0,040000, a_5=0,027778,",
                " a_6=0,020408, a_7=0,015625, a_8=0,012346, a_9=0,010000, a_10=0,008264, a_11=0,006944,",
                " a_12=0,005917, a_13=0,005102, a_14=0,004444, a_15=0,003906, a_16=0,003460, a_17=0,003086, a_18=0,002770");
        Task02.printN(args);
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void printNof0_02() {
        String[] args = {"0.02"};
        String expectedOutput = String.format("%s%n%s%n%s%n", "E=0,020000",
                "Number of the least element, which satisfies M condition: 7",
                "Elements: a_1=0,250000, a_2=0,111111, a_3=0,062500, a_4=0,040000, a_5=0,027778, a_6=0,020408, a_7=0,015625");
        Task02.printN(args);
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void printWithNoArgs() {
        String[] args = {""};
        String expectedOutput = String.format("%s%n", "Epsilon should be positive double (NumberFormatException)");
        Task02.printN(args);
        assertEquals(expectedOutput, outContent.toString());
    }

}