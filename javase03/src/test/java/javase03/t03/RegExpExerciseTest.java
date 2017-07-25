package javase03.t03;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class RegExpExerciseTest {
    private static final String fileName = "src/main/resources/t03/PicLinksFinder/JF03 - 3.1 - Information handling_task_attachment.html";
    private static PicLinksFinder finder = new PicLinksFinder();
    private static List<String> sentences;
    private static List<Integer> picLinkNumbers = new ArrayList<>();
    private List<String> testText = new ArrayList<>();
    @Before
    public void setUp() throws Exception {
        testText.add("        В электроне (позитроне) гамма-коллапсары образуют семь гамма-трубок (Рис. 3), в каждой из семи гамма-трубок по семь элементарных Рисунке 34 и рисунка 133 трубок, всего в (Рис. 15,16) (Рис. 25 и 26) электроне (позитроне) 49 элементарных трубок, сорок девятая трубка расположена в центре.");
        testText.add("                Новое описание истинной структуры ядра атома углерода основано на универсальных свойствах коллапсаров-нуклонов в силовых структурах трёх альф, расположенных в ядерной трубке атома углерода с взаимным относительным смещением на 60 (рис. 8).");
        testText.add("        Только мощные свободные неэлектростатические – спиновые (сторонние) электрические заряды протонов, в ядрах атома углерода создают силовую кристаллическую структуру графита (Рис. 18), фуллерена (Рис. 22) и алмаза (Рис. 25).");
    }

    @Test
    public void getSentencesTest() throws Exception {
        sentences = finder.getSentences(fileName);
        int i = 0;
        for (String sentence : sentences) {
            System.out.printf("str %d: %s%n", ++i, sentence);
        }
    }

    @Test
    public void filterTestText() throws Exception {
        final Map<String, List<Integer>> picLinks = finder.getPicLinks(testText);
//        final Map<String, List<Integer>> picLinks = finder.getPicLinks(sentences);
        int i = 0;
        for (String sentence : picLinks.keySet()) {
            System.out.printf("%s : ", sentence);
            for (Integer integer : picLinks.get(sentence)) {
                System.out.printf("%d, ", integer);
            }
            System.out.println();
        }
    }

    @Test
    public void getPicLinkNumbers() throws Exception {
        String s = "Коллапсар-электрон (Рис. 3)  построен из гамма-коллапсаров";
        List<Integer> picLinks = finder.getPicLinkNumberFromSentence(s);
        List<Integer> expected = Collections.singletonList(Integer.valueOf(3));
        assertTrue(expected.equals(picLinks));
    }

    @Test
    public void getAllPicLinkNumbersOrdered() throws Exception {
        List<Integer> picLinks = new ArrayList<>();
        sentences = finder.getSentences(fileName);
        for (String sentence : sentences) {
            picLinks = finder.getPicLinkNumberFromSentence(sentence);
            if (picLinks.size() != 0)
                picLinkNumbers.addAll(picLinks);
        }
        // TODO: 24.07.2017 remove next line:
        System.out.println("");
    }

    @Test
    public void tmpTest() throws Exception {
        Pattern p = Pattern.compile("\\w*");
        final String tmp = "asDA32dSsA{END}sadasd";
        Matcher m = p.matcher(tmp);
        while (m.find()) {
            System.out.println(tmp.substring(m.start(), m.end()));
        }

    }
}