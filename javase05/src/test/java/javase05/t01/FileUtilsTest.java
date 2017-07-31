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
        final boolean actual = FileUtils.showFileContents(fileToShow.toString());
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

    // TODO: 31.07.2017 not refactored 
    @Test
    public void createFileContents() throws Exception {
        String file = "a";
//        String file = "d:\\Temp\\0\\170729.txt";
        String s = "Привет1";
        FileUtils.writeToTxtFile(file, s, false);
        FileUtils.showFileContents(file);
        FileUtils.deleteFile("a");
    }

    @Test
    public void deleteFileFails() throws Exception {
        String file = "170728.txt";
        assertThat(false, Is.is(FileUtils.deleteFile(file)));
    }

    @Test
    public void getCurrentDir() throws Exception {
        FileUtilsClass.getCurrentDirectory();
    }



}