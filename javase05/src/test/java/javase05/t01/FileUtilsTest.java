package javase05.t01;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class FileUtilsTest {
    @Test
    public void showDirContents() throws Exception {
        String dirToShow = ".";
        assertThat(true, Is.is(FileUtils.showDirContents(dirToShow)));
    }

    @Test
    public void showDirContentsFalse() throws Exception {
        String dirToShow = "g:";
        assertThat(false, Is.is(FileUtils.showDirContents(dirToShow)));
    }

    @Test
    public void showFileContents() throws Exception {
        String fileToShow = "src\\main\\java\\javase05\\t01\\FileUtils.java";
        assertThat(true, Is.is(FileUtils.showFileContents(fileToShow)));
    }

    @Test
    public void showFileContentsError() throws Exception {
//        String fileToShow = "Temp\\0\\test.txt";
        String fileToShow = "d:\\Temp\\0\\test.txt";
        FileUtils.showFileContents(fileToShow);
    }

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