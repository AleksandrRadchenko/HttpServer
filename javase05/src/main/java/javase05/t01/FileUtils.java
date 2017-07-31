package javase05.t01;

import java.io.*;
import java.nio.file.*;

/**
 * Allows to show file contents, list dir, write to and delete the file.
 */
public interface FileUtils {
    static boolean showDirContents(String pathLocal) {
        boolean result = true;
        try {
            DirectoryStream<Path> dirList = Files.newDirectoryStream(Paths.get(pathLocal));
            System.out.printf("Directory \"%s\" listing:%n", pathLocal);
            for (Path path : dirList) {
                System.out.println(path.getFileName());
            }
            dirList.close();
        } catch (Exception e) {
            System.err.println("Exception in showDirContents method.");
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    static boolean showFileContents(String pathToFile) {
        boolean result = true;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathToFile)))) {
            Path p = Paths.get(pathToFile);
            StringBuilder sb = new StringBuilder();
            while (br.ready()) {
                sb.append((char)br.read());
            }
            System.out.printf("Contents of file \"%s\":%n%s", p, sb);
        } catch (FileNotFoundException e) {
            System.err.printf("Please, specify correct file:%n%s", e);
            result = false;
        }
        catch (IOException e) {
            System.err.println("IOException in showFileContents method.");
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    /**
     * Write the whole String text to the given file.
     * @param pathToFile path to file.
     * @param text String to write to file.
     * @param append it true writes to the end of file. Else rewrites contents of a file.
     */
    static boolean writeToTxtFile(String pathToFile, String text, boolean append) {
        boolean result = true;
        Path file = Paths.get(pathToFile);
        try {
            FileWriter writer = new FileWriter(new File(file.toUri()), append);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.err.println("IOException in writeToTxtFile method.");
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    static boolean deleteFile(String pathToFile) {
        boolean result;
        try {
            File file = new File(pathToFile);
            result = file.delete();
            if (!result) {
                System.err.printf("Failed to delete file \"%s\".%n", pathToFile);
            }
        } catch (Exception e) {
            System.err.println("Exception in deleteFile method.");
            e.printStackTrace();
            result = false;
        }
        return result;
    }


}
