package javase05.t02;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public interface PropReader {
    Properties properties = new Properties();
    static String getProperty(String pathToFile, String key, Charset cs) {
        String result;
        InputStream is = PropReader.class.getClassLoader().getResourceAsStream(pathToFile);
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is, cs);
            try {
                properties.load(isr);
                try {
                    isr.close();
                } catch (IOException | NullPointerException e) {
                    System.err.println("InputStream closing error");
                    e.printStackTrace();
                }
//                System.out.println(properties.stringPropertyNames());
//                System.out.println("\\u043A\\u043B\\u044E\\u04472");
                result = properties.getProperty(key);
                if (result == null) {
                    result = "Provided key " + key + " was not found in file " + pathToFile;
                }
            } catch (IOException e) {
                result = "Provided properties file is broken.";
                System.err.println(result);
            } catch (IllegalArgumentException e) {
                result = "Provided properties file contains a malformed Unicode escape sequence.";
                System.err.println(result);
            }
        } else {
            result = "Please, specify correct properties file (file not found)";
            System.err.println(result);
        }
        return result;
    }
}
