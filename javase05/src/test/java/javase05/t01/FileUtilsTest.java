package javase05.t01;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;

public class FileUtilsTest {
    @Test
    public void showDirContents() throws Exception {
        String dirToShow = ".";
        final boolean actual = FileUtils.showDirContents(dirToShow);
        final boolean expected = true;
        assertThat(actual, Is.is(expected));
    }

    @Test
    public void showDirContentsFalse() throws Exception {
        String dirToShow = "g:";
        final boolean actual = FileUtils.showDirContents(dirToShow);
        final boolean expected = false;
        assertThat(actual, Is.is(expected));
    }

    @Test
    public void showFileContents() throws Exception {
        String s = File.separator;
        String fileToShow = "src" + s + "main" + s + "java" + s + "javase05" + s + "t01" + s + "FileUtils.java";
        final boolean actual = FileUtils.showFileContents(fileToShow);
        final boolean expected = true;
        assertThat(actual, Is.is(expected));
    }

    @Test
    public void showFileContentsError() throws Exception {
        String fileToShow = "dasdsad";
        final boolean actual = FileUtils.showFileContents(fileToShow);
        final boolean expected = false;
        assertThat(actual, Is.is(expected));
    }

    @Test
    public void createFileContents() throws Exception {
        String file = "a";
        String s = "Привет1";
        final boolean actual = FileUtils.writeToTxtFile(file, s, false);
        final boolean expected = true;
        assertThat(actual, Is.is(expected));
//        FileUtils.deleteFile("a");
    }

    @Test
    public void deleteFileFails() throws Exception {
        String fileToDelete = "170728.txt";
        final boolean actual = FileUtils.deleteFile(fileToDelete);
        final boolean expected = false;
        assertThat(actual, Is.is(expected));
    }

}