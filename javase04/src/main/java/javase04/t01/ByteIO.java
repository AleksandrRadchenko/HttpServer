package javase04.t01;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByteIO {
    private String filename = "javase03/src/main/java/javase03/t02/I18n.java";
    private List<String> list = JavaKeyWords.getJavaKeyWords();
    private String inputFromFile;

    public static void main(String[] args) {
        ByteIO b = new ByteIO();
        b.inputFromFile = b.readFromFile(b.filename);
        b.inputFromFile = b.removeStrings(b.inputFromFile);
        Map<String, Integer> detectedWords = b.detectKeyWords(b.inputFromFile);
        for (String word : detectedWords.keySet()) {
            System.out.printf("%s: %d%n", word, detectedWords.get(word));
        }
    }

    private String removeStrings(String inputFromFile) {
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

    private Map<String, Integer> detectKeyWords(String s) {
        Map<String, Integer> output = new HashMap<>();
        for (String keyword : list) {
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
    private String readFromFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            while (br.ready()) {
                sb.append((char)br.read());
            }
        }
        return sb.toString();
    }

}
