package httpserver;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Utility interface for methods to operate files.
 */
interface FileProcessor {
    org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(RequestParser.class);

    /**
     * Reads file from disk and returns as byte array. File size should not be
     * more than 2 Gb (Integer.MAX_VALUE), or it will be truncated to 2 Gb.
     * @param fileName String representation of path to the file.
     * @return byte array with raw file contents.
     */
    static byte[] readFromFile(final String fileName) {
        try {
            return Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    static void writeToFile(final Path path, final byte[] contents) {
        try {
            Files.write(path, contents);
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * Returns the contents of dir as the List<String>.
     * @param dir Path object, represents the path to the directory to list.
     * @return List<String> with names of all files and folders in the provided dir
     * or empty ArrayList<String> if error occurs.
     */
    static List<String> directoryListing(Path dir) {
        List<String> result = new ArrayList<>();
        if (dir == null || !Files.isDirectory(dir)) {
            log.error("Provided path is not the directory");
            return result;
        }
        try {
            DirectoryStream<Path> dirList = Files.newDirectoryStream(dir);
            for (Path path : dirList) {
                result.add(path.getFileName().toString());
            }
            dirList.close();
        } catch (Exception e) {
            log.error("Exception in directoryListing method.", e);
            return new ArrayList<>();
        }
        return result;
    }

    static void generateIndexHtml() {
        final String body = "<html>\r\n" +
                "    <head>\r\n" +
                "        <meta charset=\"utf-8\"/>\r\n" +
                "    </head>\r\n" +
                "    <body>\r\n" +
                "        <h1>List of files:</h1>\r\n" +
                "%s" +
                "    </body>\r\n" +
                "</html>";
        StringBuffer sb = new StringBuffer();
        for (String s : directoryListing(Paths.get(Strings.PATH))) {
            String appendable = "        <a href=\"" + s + "\">" + s + "</a><br>";
            sb.append(appendable);
            sb.append(System.lineSeparator());
        }
        writeToFile(Paths.get(Strings.PATH + "/index.html"), String.format(body, sb.toString()).getBytes());
    }

    /**
     * Copied from Java 9 (stackoverflow exactly) for educational purposes.
     */
    static byte[] readFully(final InputStream is, int length, final boolean readAll)
            throws IOException {
        byte[] output = {};
        if (length == -1)
            length = Integer.MAX_VALUE;
        int pos = 0;
        while (pos < length) {
            int bytesToRead;
            if (pos >= output.length) { // Only expand when there's no room
                bytesToRead = Math.min(length - pos, output.length + 1024);
                if (output.length < pos + bytesToRead) {
                    output = Arrays.copyOf(output, pos + bytesToRead);
                }
            } else {
                bytesToRead = output.length - pos;
            }
            int cc = is.read(output, pos, bytesToRead);
            if (cc < 0) {
                if (readAll && length != Integer.MAX_VALUE) {
                    throw new EOFException("Detect premature EOF");
                } else {
                    if (output.length != pos) {
                        output = Arrays.copyOf(output, pos);
                    }
                    break;
                }
            }
            pos += cc;
        }
        return output;
    }

    /**
     * Remain here for study purposes.
     * @param fileName String representation of path to the file.
     * @return byte array with raw file contents.
     */
    static byte[] getFile0(final String fileName) {
        byte[] result;
        try (FileInputStream fis = new FileInputStream(fileName);
             BufferedInputStream br = new BufferedInputStream(fis)) {
            result = new byte[(int) fis.getChannel().size()];
            int i = 0;
            int read;
            while ((read = br.read()) != -1)
                result[i++] = (byte) read;
            return result;
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }

}
