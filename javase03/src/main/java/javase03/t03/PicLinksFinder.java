package javase03.t03;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PicLinksFinder {

    public static void main(String[] args) {
        readFileToString("javase03/src/main/resources/t03/PicLinksFinder/JF03 - 3.1 - Information handling_task_attachment.html");
    }

    public List<String> getSentencesWithPicturesLinks(@NonNull String fileName) {
        String text = readFileToString(fileName);
        String valuableText = cleanHtmlTags(text);
        // Splitting by sentences
        Pattern p = Pattern.compile("[А-ЯЁ][А-ЯЁа-яёa-z\\w\\s\\d\\p{Punct}«»–]*?[!.?]\\s+(?=[А-ЯЁ]|$)");
        Matcher m = p.matcher(valuableText);
        List<String> sentences = new ArrayList<>();
        String s;
        while (m.find()) {
            s = valuableText.substring(m.start(), m.end() - 1).trim();
            sentences.add(s);
//            System.out.println("string: " + s);
        }
        return sentences;
    }

    private String cleanHtmlTags(String text) {
        // truncating useless bytes from the beginning of the file
        //todo: try withiout it
        String valuableText = text.substring(text.indexOf("Мнения ученых"));
        // Excluding all pictures captions
        Pattern p = Pattern.compile(">Рис.\\s*?\\d+");
        Matcher m = p.matcher(valuableText);
        valuableText = m.replaceAll(">");
        // Excluding html tags
        p = Pattern.compile("&nbsp;");
        m = p.matcher(valuableText);
        valuableText = m.replaceAll(" ");
        p = Pattern.compile("<.*?>");
        m = p.matcher(valuableText);
        valuableText = m.replaceAll(" ");
        return valuableText;
    }

    //Ссылка на рисунок: \s*[^>][Рр]ис[^\d\s]*\s\d+
    //Разбиение на слова: [^а-яёА-ЯЁ_0-9]+

    // Типы ссылок на рисунки:
    // рисунке 1
    // рисунка 17
    // (рис. 8)
    // (Рис. 1)
    // (Рис. 1, 2)
    // (Рис. 8-б)
    // (Рис. 8 г,д)
    // На рисунке (Рис. 14-а)
    // (Рис. 15,16)
    // (Рис. 25 и 26)

    @SneakyThrows
    private static String readFileToString(@NonNull String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), Charset.forName("Windows-1251")))) {
            while (br.ready()) {
                sb.append((char)br.read());
            }
        }
        return sb.toString();
    }
}
