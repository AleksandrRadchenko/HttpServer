package HTTPserver;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertThat;

public class SimpleHTTPServerTest {
    SimpleHTTPServer server = new SimpleHTTPServer();
    private String[] args = {"8080"};


////  For running server in local environment for tests
//    @Test
//    public void test0() throws Exception {
//        String[] args = {"8080"};
//        int expected = server.openPort(args);
//    }

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
    public void getTxtFile() throws Exception {
        Thread t1 = new Thread(new ServerStarter(args));
        t1.start();
        String urlString = "http://localhost:8080/test.txt";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//        int responseCode = connection.getResponseCode();
        byte[] actual = readInputStream(connection.getInputStream());
        byte[] expected = FileProcessor.getFile(Strings.PATH + "/test.txt");
        assertThat(actual, Is.is(expected));
        t1.interrupt();

    }

    @Test
    public void getJpgFile() throws Exception {
        Thread t1 = new Thread(new ServerStarter(args));
        t1.start();
        String urlString = "http://localhost:8080/face4small.jpg";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        byte[] actual = readInputStream(connection.getInputStream());
        byte[] expected = FileProcessor.getFile(Strings.PATH + "/face4small.jpg");
        assertThat(actual, Is.is(expected));
        t1.interrupt();
    }

    private byte[] readInputStream(InputStream is) {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
            byte[] buffer = new byte[0xFFFF];
            for (int len; (len = is.read(buffer)) != -1; )
                os.write(buffer, 0, len);
            os.flush();
            return os.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}