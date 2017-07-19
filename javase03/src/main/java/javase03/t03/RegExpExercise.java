package javase03.t03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class RegExpExercise {
    private static String text;
    private static StringBuilder sb = new StringBuilder();
    private static final String fileName = "javase03/src/main/resources/t03/RegExpExercise/JF03 - 3.1 - Information handling_task_attachment.html";

    public static void main(String[] args) {
        text = readFileToString();
        System.out.println(text.substring(1,1000));
    }

    private static String readFileToString() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), Charset.forName("Windows-1251")))) {
            while (br.ready()) {
                sb.append((char)br.read());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return sb.toString();
    }
}
