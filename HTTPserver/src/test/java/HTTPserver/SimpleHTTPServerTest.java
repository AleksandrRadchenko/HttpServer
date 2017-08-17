package HTTPserver;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
    public void test0() throws Exception {
        String[] args = {"8080"};
        int expected = server.openPort(args);
    }

    @Test
    public void test1() throws Exception {
        String[] args = {"8080"};
        Thread t1 = new Thread(new ServerStarter(args));
        t1.start();

        String urlString = "http://localhost:8080/test.txt";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + urlString);
//        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            response.append(System.lineSeparator());
        }
        in.close();

        //print result
        System.out.println(response.toString());

        //testing for equivalence with original file
        byte[] actual = response.toString().getBytes();
        byte[] expected = FileProcessor.getFile(Strings.PATH + "/test.txt");
        assertThat(actual, Is.is(expected));
        t1.interrupt();
//        t1.join();

//        InputStream is = socket.getInputStream();
//        OutputStream os = socket.getOutputStream();
//        os.write("GET /face4small4.jpg HTTP/1.1\r\nHost: http://192.168.0.79:8080".getBytes());
//        while (is.available() > 0) {
//            System.out.print(is.read());
//        }
//        System.out.println("End of stream");
//        socket.close();
    }

}