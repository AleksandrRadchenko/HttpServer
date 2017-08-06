package HTTPserver;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class SimpleHTTPServerTest {
    SimpleHTTPServer server = new SimpleHTTPServer();

    @Test
    public void portNumShouldBeIntegerString() throws Exception {
        String[] args = {"asd"};
        int expected = server.openPort(args);
        assertThat(expected, Is.is(-1));
    }

}