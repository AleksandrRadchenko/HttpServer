package javase04.t03;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ChangeEncoding {
    private static final String INPUT_FILE_PATH = "javase04/src/main/resources/javase04/t03/";
    private static final String INPUT_FILE_NAME = "TextInUTF-8.txt";
    private static final String OUTPUT_FILE_PATH = INPUT_FILE_PATH;
    private static final String OUTPUT_FILE_NAME = "TextInUTF-16.txt";

    public static void main(String[] args) {
        String result = fileReader(INPUT_FILE_PATH + INPUT_FILE_NAME, StandardCharsets.UTF_8);
        fileWriter(OUTPUT_FILE_PATH + OUTPUT_FILE_NAME, result, StandardCharsets.UTF_16);
    }

    @SneakyThrows
    static String fileReader(String filename, Charset cs) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), cs))) {
            while (br.ready()) {
                sb.append((char)br.read());
            }
        }
        return sb.toString();
    }

    @SneakyThrows
    static void fileWriter(String filename, String string, Charset cs) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), cs))) {
            bw.write(string);
        }
    }


}
