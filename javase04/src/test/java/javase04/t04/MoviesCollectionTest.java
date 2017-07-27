package javase04.t04;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertThat;

/**
 * Created by ara on 26.07.2017.
 */
public class MoviesCollectionTest {
    private final MoviesCollection mc = new MoviesCollection();
    @Before
    public void putFirstRecord() throws Exception {
        mc.put("Matrix", "Keanu Reeves");
    }

    @Test
    public void putSecondRecord() throws Exception {
        mc.put("Matrix", "Laurence Fishburne");
        mc.put("Matrix", "Laurence Fishburne");
        final Map<String, Set<String>> collection = mc.getCollection();
        final Map<String, Set<String>> expected = new HashMap<>();
        final Set<String> expectedSet = new HashSet<>();
        expectedSet.add("Keanu Reeves");
        expectedSet.add("Laurence Fishburne");
        expected.put("Matrix", expectedSet);
        assertThat(collection, Is.is(expected));
    }

    @Test
    public void deleteMatrix() throws Exception {
        mc.deleteMovie("Matrix");
        assertThat(0, Is.is(mc.getCollection().size()));
    }

    @Test
    public void deserializing() throws Exception {
        mc.shutDown();
        final MoviesCollection mc2 = new MoviesCollection();
        mc2.start();
        assertThat(mc.getCollection(), Is.is(mc2.getCollection()));
    }



}