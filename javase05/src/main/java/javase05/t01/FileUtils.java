package javase05.t01;

import java.io.*;
import java.nio.file.*;

/**
 * Allows to show file contents, list dir, write to and delete the file.
 */
public interface FileUtils {
    static void showDirContents(String pathLocal) {
        try {
            DirectoryStream<Path> dirList = Files.newDirectoryStream(Paths.get(pathLocal));
            System.out.printf("Directory \"%s\" listing:%n", pathLocal);
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
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
            Path p = Paths.get(pathToFile);
            StringBuilder sb = new StringBuilder();
            while (br.ready()) {
                sb.append((char)br.read());
            }
            System.out.printf("Contents of file \"%s\":%n", p);
        } catch (FileNotFoundException e) {
            System.err.printf("Please, specify correct file:%n%s", e);
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * Write the whole String text to the given file.
     * @param pathToFile path to file.
     * @param text String to write to file.
     * @param append it true writes to the end of file. Else rewrites contents of a file.
     */
    static void writeToTxtFile(String pathToFile, String text, boolean append) {
        Path file = Paths.get(pathToFile);
        try {
            FileWriter writer = new FileWriter(new File(file.toUri()), append);
//            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(new File(file.toUri())));
            writer.write(text);
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    static boolean deleteFile(String pathToFile) {
        boolean result = false;
        try {
            File file = new File(pathToFile);
            result = file.delete();
            if (!result) {
                System.out.printf("Failed to delete file \"%s\".%n", pathToFile);
            }
        } catch (SecurityException e) {
            System.err.println(e);
        } catch (NullPointerException e) {
            System.err.println(e);
        }
        return result;
    }


}
