package javase06.t02;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class PropReaderTest {
    private String propFilePath = "javase06/t02/test.properties";

    @Test
    public void readProp() throws Exception {
        final Map<Object, Object> actual = PropReader.getPropertyToMap(propFilePath);
        final Map<Object, Object> expected = new HashMap<>();
        expected.put("key1", "Value1");
        expected.put("key2", "value2");
        assertThat(actual, Is.is(expected));
    }

    @Test
    public void reariteValue() throws Exception {
        Map<Object, Object> actual = PropReader.getPropertyToMap(propFilePath);
        System.out.println(actual);
        System.out.println("Результат записи в map элемента \"key1\", \"Value3\": " + actual.put("key1", "Value3"));
        System.out.println(actual);
        System.out.println("Если в map коллекцию добавить элемент с ключем, который уже присутствует, " +
                "значение, соответствующее этому ключу, будет перезаписано значением нового элемента.");
//        final Map<Object, Object> expected = new HashMap<>();
//        expected.put("key1", "Value1");
//        expected.put("key2", "value2");
//        assertThat(actual, Is.is(expected));
    }



}