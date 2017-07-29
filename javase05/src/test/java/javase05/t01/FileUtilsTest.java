package javase05.t01;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class FileUtilsTest {
    @Test
    public void showDirContents() throws Exception {
        String dirToShow = "d:\\Temp\\";
        FileUtils.showDirContents(dirToShow);
    }

    @Test
    public void showFileContents() throws Exception {
//        String fileToShow = "Temp\\0\\test.txt";
        String fileToShow = "d:\\Temp\\0\\test.txt";
        FileUtils.showFileContents(fileToShow);
    }

    @Test
    public void showFileContentsError() throws Exception {
//        String fileToShow = "Temp\\0\\test.txt";
        String fileToShow = "d:\\Temp\\0\\test.txt";
        FileUtils.showFileContents(fileToShow);
    }

    @Test
    public void createFileContents() throws Exception {
//        String fileToShow = "Temp\\0\\test.txt";
        String file = "d:\\Temp\\0\\170729.txt";
        String s = "Привет2";
        FileUtils.writeToTxtFile(file, s, false);
        FileUtils.showFileContents(file);
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