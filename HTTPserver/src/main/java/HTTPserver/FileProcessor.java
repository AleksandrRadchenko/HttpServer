package HTTPserver;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Reads file from disk and returns as byte array. File size should not be
 * more than 2 Gb (Integer.MAX_VALUE), or it will be truncated to 2 Gb.
 */
@Log4j2
public class FileProcessor {
    // TODO: 15.08.2017 change encoding to system default 
    public static byte[] getFile(String fileName) {
        byte[] result;
        try (FileInputStream fis = new FileInputStream(fileName);
             BufferedInputStream br = new BufferedInputStream(fis)) {
            result = new byte[(int) fis.getChannel().size()];
            int i = 0;
            byte read;
            while ((read = (byte) br.read()) != -1) {
                result[i] = read;
                i++;
            }
            return result;
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }
}
