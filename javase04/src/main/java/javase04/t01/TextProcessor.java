package javase04.t01;

import lombok.SneakyThrows;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface TextProcessor {

    static String removeStringLiterals(String inputFromFile) {
        String result;
        // Stripping strings
        Pattern p = Pattern.compile("\".*?\"");
        Matcher m = p.matcher(inputFromFile);
        result = m.replaceAll("");
        // Stripping comments
        p = Pattern.compile("//.*?\n", Pattern.DOTALL);
        m = p.matcher(result);
        result = m.replaceAll("");
        // Stripping javadocs
        p = Pattern.compile("/\\*\\*.+?\\*\\*/", Pattern.DOTALL);
        m = p.matcher(result);
        result = m.replaceAll("");
        return result;
    }

    static Map<String, Integer> detectKeyWords(String s, List<String> keywords) {
        Map<String, Integer> output = new HashMap<>();
        for (String keyword : keywords) {
            Pattern p = Pattern.compile(keyword);
            Matcher m = p.matcher(s);
            int counter = 0;
            while (m.find()) {
                counter++;
            }
            if (counter != 0)
                output.put(keyword, counter);
        }
        return output;
    }
    @SneakyThrows
    static String readFileViaCharStreams(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            while (br.ready()) {
                sb.append((char)br.read());
            }
        }
        return sb.toString();
    }

    @SneakyThrows
    static String readFileViaByteStream(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedInputStream bs = new BufferedInputStream(new FileInputStream(filename))) {
            while (bs.available() > 0) {
                sb.append((char)bs.read());
            }
        }
        return sb.toString();
    }

    @SneakyThrows
    static boolean writeToFileViaByteStream(String text, String filename) {
        try (BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(filename))) {
            for (char c : text.toCharArray()) {
                bs.write((int) c);
            }
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @SneakyThrows
    static boolean writeToFileViaCharStream(String text, String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(text);
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }


}
