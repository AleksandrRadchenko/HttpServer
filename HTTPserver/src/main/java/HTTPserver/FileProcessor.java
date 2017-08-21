package HTTPserver;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Reads file from disk and returns as byte array. File size should not be
 * more than 2 Gb (Integer.MAX_VALUE), or it will be truncated to 2 Gb.
 */
@Log4j2
public class FileProcessor {
    /**
     * For files smaller then 2Gb
     * @param fileName String representation of path to the file
     * @return byte array with raw file contents
     */
    public static byte[] getFile(String fileName) {
        try {
            return Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    /**
     * Copied from Java 9 for educational purposes
     */
    private static byte[] readFully(InputStream is, int length, boolean readAll)
            throws IOException {
        byte[] output = {};
        if (length == -1) length = Integer.MAX_VALUE;
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
     * @param fileName String representation of path to the file
     * @return
     */
    private static byte[] getFile0(String fileName) {
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
