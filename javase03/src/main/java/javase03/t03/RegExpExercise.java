package javase03.t03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpExercise {
    private static String text;
    private static StringBuilder sb = new StringBuilder();
    private static final String fileName = "javase03/src/main/resources/t03/RegExpExercise/JF03 - 3.1 - Information handling_task_attachment.html";

    public static void main(String[] args) {
        text = readFileToString();
        // truncating html tags from text we read from file
        String valuableText = text.substring(text.indexOf("Мнения ученых"));
        //TODO: exclude all html tags
        //Ссылка на рисунок: \s*[^>][Рр]ис[^\d\s]*\s\d+
        //предложение: [А-Я]([^\.]|(. \d))+\.[^а-яёА-ЯЁ_0-9]
        //Разбиение на слова: [^а-яёА-ЯЁ_0-9]+
        Pattern p = Pattern.compile("&nbsp;");
        Matcher m = p.matcher(valuableText);
        valuableText = m.replaceAll(" ");
        p = Pattern.compile("<.+>");
        m = p.matcher(valuableText);
        valuableText = m.replaceAll(" ");
        p = Pattern.compile("[А-Я]([^\\.]|(. \\d))+[\\.][^а-яёА-ЯЁ_0-9]");
        m = p.matcher(valuableText);
        List<String> sentences = new ArrayList<>();
        String s;

        while (m.find()) {
            s = valuableText.substring(m.start(), m.end() - 1);
            sentences.add(s);
            System.out.println("string: " + s);
        }
    }

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

    // Подписи к рисункам:
    // <p>Рис. 11_
    // Рис. 2
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
