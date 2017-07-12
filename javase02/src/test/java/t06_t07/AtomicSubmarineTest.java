package t06_t07;

import org.junit.Test;

public class AtomicSubmarineTest {
    //Creating onject Atomic Submarine
    private AtomicSubmarine submarine = new AtomicSubmarine(3);
    private Destination destination = new Destination(59.9386300, 30.3141300);

    //Sending Atomic Submarine head to destination
    @Test
    public void goTo() throws Exception {
        submarine.headToDestination(destination);
    }

}