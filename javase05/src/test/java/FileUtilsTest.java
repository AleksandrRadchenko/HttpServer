import org.junit.Test;

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

}