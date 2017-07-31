package javase05.t02;


import org.hamcrest.core.Is;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;

public class PropReaderTest {
    private String propFilePath = "javase05/t02/test.properties";
    private Charset cs = StandardCharsets.UTF_8;

    @Test
    public void readProp() throws Exception {
        String key = "key1";
        final String actual = PropReader.getProperty(propFilePath, key, cs);
        final String expected = "Value1";
        assertThat(actual, Is.is(expected));
    }

    @Test
    public void keyNotFound() throws Exception {
        String key = "key2";
        final String actual = PropReader.getProperty(propFilePath, key, cs);
        final String expected = "Provided key " + key + " was not found in file " + propFilePath;
        assertThat(actual, Is.is(expected));
    }

    @Test
    public void fileNotFound() throws Exception {
        propFilePath = "asd";
        String key = "key1";
        final String actual = PropReader.getProperty(propFilePath, key, cs);
        final String expected = "Please, specify correct properties file (file not found)";
        assertThat(actual, Is.is(expected));
    }

    @Test
    public void readPropLocaleRu() throws Exception {
        String key = "ключ2";
//        String key = "\\u043A\\u043B\\u044E\\u04472";
        final String actual = PropReader.getProperty(propFilePath, key, cs);
        final String expected = "значение2";
//        final String expected = "\\u0437\\u043d\\u0430\\u0447\\u0435\\u043d\\u0438\\u0435\\u0032";
        assertThat(actual, Is.is(expected));
    }


}