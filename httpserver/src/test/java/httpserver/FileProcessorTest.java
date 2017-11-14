package httpserver;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests for methods of FileProcessor interface
 */
public class FileProcessorTest {
    @Test
    public void directoryListing() throws Exception {
        List<String> actual = FileProcessor.directoryListing(Paths.get(Strings.PATH + "/TestDirDoNotChange"));
        List<String> expected = new ArrayList<>();
        expected.add("doNotChange.png");
        assertThat(actual, Is.is(expected));
    }
}