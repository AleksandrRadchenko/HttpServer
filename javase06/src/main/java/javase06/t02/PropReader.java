package javase06.t02;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public interface PropReader {
    Properties properties = new Properties();
    static Map<Object, Object> getPropertyToMap(String pathToFile) {
        HashMap<Object, Object> result = new HashMap<>();
        InputStream is = PropReader.class.getClassLoader().getResourceAsStream(pathToFile);
        if (is != null) {
            try {
                properties.load(is);
                try {
                    is.close();
                } catch (IOException | NullPointerException e) {
                    System.err.println("InputStream closing error");
                    e.printStackTrace();
                }
                result = new HashMap<>(properties);
            } catch (IOException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Please, specify correct properties file (file not found)");
        }
        return result;
    }
}
