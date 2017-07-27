package javase03.t03;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PicLinksFinder {

    public static void main(String[] args) {
//        readFileToString("javase03/src/main/resources/t03/PicLinksFinder/JF03 - 3.1 - Information handling_task_attachment.html");
    }

    private Pattern p;
    private Matcher m;
    // Maps sentences with picture links --> to the List of these link
    private final Map<Integer, Tuple2<String, List<Integer>>> picLinks = new HashMap<>();

//     Типы ссылок на рисунки:
//     рисунке 1
//     рисунка 17
//     (рис. 8)
//     (Рис. 1)
//     (Рис. 1, 2)
//     (Рис. 8-б)
//     (Рис. 8 г,д)
//     На рисунке (Рис. 14-а)
//     (Рис. 15,16)
//     (Рис. 25 и 26)
// Которые могли бы еще быть:
//     рисунках 17 и 20
//     рисунки 17 и 12
//     рисунков 17, 2
//     рис. 17 или 2

    public boolean ifPicLinksSorted(Map<Integer, Tuple2<String, List<Integer>>> picLinks) {
        List<Integer> allLinksOrdered = new ArrayList<>();
        boolean result = true;
        for (Integer i : picLinks.keySet()) {
            allLinksOrdered.addAll(picLinks.get(i)._2);
        }
        Integer previous = -1;
        for (Integer integer : allLinksOrdered) {
            if (previous > integer) {
                result = false;
                break;
            }
            previous = integer;
        }
        return result;
    }
    /**
     * Returns mapping of sentences to list of picture links in this sentence.
     * @param sentences List of Strings to find picture links in.
     * @return Map with Integer keys (indexes) and Tuple2 of String sentence and
     * ArrayList of corresponding picture links from that sentence
     */
    @SuppressWarnings("WeakerAccess")
    public Map<Integer, Tuple2<String, List<Integer>>> getPicLinks(@NonNull List<String> sentences) {
        int sentenceWithLinksCounter = 0;
        // Picture link pattern with capturing group for first and second link
//        p = Pattern.compile("(?<=[кс][.аеиоу][вх\\s]\\s?)(\\d{1,3})([, ил]+(\\d{1,3}))?");
        p = Pattern.compile(Patterns.PIC_LINKS_PATTERN);
        for (String sentence : sentences) {
            // Temporary list to accumulate picture links from current sentence
            List<Integer> links = new ArrayList<>();
            m = p.matcher(sentence);
            while (m.find()) {
                String group1 = m.group(1);
                if (group1 != null)
                    links.add(Integer.parseInt(group1));
                String group3 = m.group(3);
                if (group3 != null)
                    links.add(Integer.parseInt(group3));
            }
            if (!links.isEmpty())
                picLinks.put(sentenceWithLinksCounter++, Tuple.of(sentence, links));
        }
        return picLinks;
    }

    /**
     * Splitting original text from file into sentences and puts them into returned List
     * @param fileName fully qualified file name to read from.
     * @return List of Strings with sentences of the original text.
     */
    public List<String> getSentences(@NonNull String fileName) {
        String text = readFileToString(fileName);
        String valuableText = cleanHtmlTags(text);
        // Splitting text for sentences
//        p = Pattern.compile("[А-ЯЁ][А-ЯЁа-яёa-z\\w\\s\\d\\p{Punct}«»–]*?[!.?]\\s+(?=[А-ЯЁ]|$)");
        p = Pattern.compile(Patterns.SENTENCE_PATTERN);
        m = p.matcher(valuableText);
        List<String> sentences = new ArrayList<>();
        String s;
        while (m.find()) {
            s = valuableText.substring(m.start(), m.end() - 1).trim();
            sentences.add(s);
        }
        return sentences;
    }

    private String cleanHtmlTags(String text) {
        // truncating not valuable bytes from the beginning of the file till "Мнения ученых"
        String valuableText = text.substring(text.indexOf(Patterns.MNENIYA_UCHENYH));
        // Excluding all pictures captions
        p = Pattern.compile(Patterns.PIC_CAPTIONS);
        m = p.matcher(valuableText);
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

    @SneakyThrows
    private static String readFileToString(@NonNull String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_16))) {
            while (br.ready()) {
                sb.append((char)br.read());
            }
        }
        return sb.toString();
    }
}
