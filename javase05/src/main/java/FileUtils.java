import java.io.*;
import java.nio.file.*;

public interface FileUtils {
    static void showDirContents(String pathLocal) {
        try {
            DirectoryStream<Path> dirList = Files.newDirectoryStream(Paths.get(pathLocal));
            for (Path path : dirList) {
                System.out.println(path.getFileName());
            }
            dirList.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    static void showFileContents(String pathToFile) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathToFile)))) {
            Path p = Paths.get(pathToFile);
            Path root = p.getRoot();
            System.out.printf("Contents of file \"%s\" in directory \"%s%s\":%n", p.getFileName(), p.getRoot(), p.subpath(0,p.getNameCount()-1));
            while (br.ready()) {
                System.out.print((char)br.read());
            }
        } catch (FileNotFoundException e) {
            System.err.printf("Please, specify correct file:%n%s%n", e.toString());
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
