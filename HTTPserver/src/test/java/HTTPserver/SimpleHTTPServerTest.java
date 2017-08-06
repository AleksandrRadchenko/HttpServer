package HTTPserver;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class SimpleHTTPServerTest {
    SimpleHTTPServer server = new SimpleHTTPServer();

    @Test
    public void strArgsFail() throws Exception {
        String[] args = {"asd"};
        int expected = server.openPort(args);
        assertThat(expected, Is.is(-1));
    }

    @Test
    public void portWrongRangeFail() throws Exception {
        String[] args = {"80"};
        int expected = server.openPort(args);
        assertThat(expected, Is.is(0));
    }

    @Test
    public void noArgsFail() throws Exception {
        String[] args = {};
        int expected = server.openPort(args);
        assertThat(expected, Is.is(0));
        args = null;
        expected = server.openPort(args);
        assertThat(expected, Is.is(0));
    }

    @Test
    public void test() throws Exception {
        String[] args = {"8080"};
        int expected = server.openPort(args);
    }

}