package HTTPserver;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        ExecutorService executorService = Executors.newCachedThreadPool();
        String[] args = {"8080"};
        executorService.execute(new ServerStarter(args));
//        int expected = server.openPort(args);
        Socket socket = new Socket("192.168.0.79", 8080);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        os.write("GET /face4small4.jpg HTTP/1.1\r\nHost: http://192.168.0.79:8080".getBytes());
        while (is.available() > 0) {
            System.out.print(is.read());
        }
        System.out.println("End of stream");
        socket.close();
    }

}