package javase03.t03;

import io.vavr.Tuple2;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;

public class RegExpExerciseTest {
    private static final String fileName = "src/main/resources/t03/PicLinksFinder/JF03 - 3.1 - Information handling_task_attachment.html";
    private static PicLinksFinder finder = new PicLinksFinder();
    private static List<String> sentences;
    private List<String> testText = new ArrayList<>();
    private static boolean printOn = false;

    public void printPicLinks(Map<Integer, Tuple2<String, List<Integer>>> picLinks) {
        if (printOn) {
            for (Integer i : picLinks.keySet()) {
                System.out.printf("%s : ", picLinks.get(i)._1);
                for (Integer integer : picLinks.get(i)._2) {
                    System.out.printf("%d, ", integer);
                }
                System.out.println();
            }
        }
    }


    @Before
    public void setUp() throws Exception {
//        testText.add("        В электроне (позитроне) гамма-коллапсары образуют семь гамма-трубок (Рис. 3), в каждой из семи гамма-трубок по семь элементарных Рисунке 4 и рисунка 5 трубок, всего в (Рис. 15,16) (Рис. 25 и 26) электроне (позитроне) 49 элементарных трубок, сорок девятая трубка расположена в центре.".trim());
//        testText.add("                Новое описание истинной структуры ядра атома углерода основано на универсальных свойствах коллапсаров-нуклонов в силовых структурах трёх альф, расположенных в ядерной трубке атома углерода с взаимным относительным смещением на 60 (рис. 27).".trim());
//        testText.add("        Только мощные свободные неэлектростатические – спиновые (сторонние) электрические заряды протонов, в ядрах атома углерода создают силовую кристаллическую структуру графита (Рис. 28), фуллерена (Рис. 29) и алмаза (Рис. 30).".trim());
//        testText.add("   рисунках 31 и 32 рисунки 33 и 34 рисунков 37, 40".trim());
        testText.add("\u0412 \u044d\u043b\u0435\u043a\u0442\u0440\u043e\u043d\u0435 \u0028\u043f\u043e\u0437\u0438\u0442\u0440\u043e\u043d\u0435\u0029 \u0433\u0430\u043c\u043c\u0430\u002d\u043a\u043e\u043b\u043b\u0430\u043f\u0441\u0430\u0440\u044b \u043e\u0431\u0440\u0430\u0437\u0443\u044e\u0442 \u0441\u0435\u043c\u044c \u0433\u0430\u043c\u043c\u0430\u002d\u0442\u0440\u0443\u0431\u043e\u043a \u0028\u0420\u0438\u0441\u002e \u0033\u0029\u002c \u0432 \u043a\u0430\u0436\u0434\u043e\u0439 \u0438\u0437 \u0441\u0435\u043c\u0438 \u0433\u0430\u043c\u043c\u0430\u002d\u0442\u0440\u0443\u0431\u043e\u043a \u043f\u043e \u0441\u0435\u043c\u044c \u044d\u043b\u0435\u043c\u0435\u043d\u0442\u0430\u0440\u043d\u044b\u0445 \u0420\u0438\u0441\u0443\u043d\u043a\u0435 \u0034 \u0438 \u0440\u0438\u0441\u0443\u043d\u043a\u0430 \u0035 \u0442\u0440\u0443\u0431\u043e\u043a\u002c \u0432\u0441\u0435\u0433\u043e \u0432 \u0028\u0420\u0438\u0441\u002e \u0031\u0035\u002c\u0031\u0036\u0029 \u0028\u0420\u0438\u0441\u002e \u0032\u0035 \u0438 \u0032\u0036\u0029 \u044d\u043b\u0435\u043a\u0442\u0440\u043e\u043d\u0435 \u0028\u043f\u043e\u0437\u0438\u0442\u0440\u043e\u043d\u0435\u0029 \u0034\u0039 \u044d\u043b\u0435\u043c\u0435\u043d\u0442\u0430\u0440\u043d\u044b\u0445 \u0442\u0440\u0443\u0431\u043e\u043a\u002c \u0441\u043e\u0440\u043e\u043a \u0434\u0435\u0432\u044f\u0442\u0430\u044f \u0442\u0440\u0443\u0431\u043a\u0430 \u0440\u0430\u0441\u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0430 \u0432 \u0446\u0435\u043d\u0442\u0440\u0435\u002e".trim());
        testText.add("\u041d\u043e\u0432\u043e\u0435 \u043e\u043f\u0438\u0441\u0430\u043d\u0438\u0435 \u0438\u0441\u0442\u0438\u043d\u043d\u043e\u0439 \u0441\u0442\u0440\u0443\u043a\u0442\u0443\u0440\u044b \u044f\u0434\u0440\u0430 \u0430\u0442\u043e\u043c\u0430 \u0443\u0433\u043b\u0435\u0440\u043e\u0434\u0430 \u043e\u0441\u043d\u043e\u0432\u0430\u043d\u043e \u043d\u0430 \u0443\u043d\u0438\u0432\u0435\u0440\u0441\u0430\u043b\u044c\u043d\u044b\u0445 \u0441\u0432\u043e\u0439\u0441\u0442\u0432\u0430\u0445 \u043a\u043e\u043b\u043b\u0430\u043f\u0441\u0430\u0440\u043e\u0432\u002d\u043d\u0443\u043a\u043b\u043e\u043d\u043e\u0432 \u0432 \u0441\u0438\u043b\u043e\u0432\u044b\u0445 \u0441\u0442\u0440\u0443\u043a\u0442\u0443\u0440\u0430\u0445 \u0442\u0440\u0451\u0445 \u0430\u043b\u044c\u0444\u002c \u0440\u0430\u0441\u043f\u043e\u043b\u043e\u0436\u0435\u043d\u043d\u044b\u0445 \u0432 \u044f\u0434\u0435\u0440\u043d\u043e\u0439 \u0442\u0440\u0443\u0431\u043a\u0435 \u0430\u0442\u043e\u043c\u0430 \u0443\u0433\u043b\u0435\u0440\u043e\u0434\u0430 \u0441 \u0432\u0437\u0430\u0438\u043c\u043d\u044b\u043c \u043e\u0442\u043d\u043e\u0441\u0438\u0442\u0435\u043b\u044c\u043d\u044b\u043c \u0441\u043c\u0435\u0449\u0435\u043d\u0438\u0435\u043c \u043d\u0430 \u0036\u0030 \u0028\u0440\u0438\u0441\u002e \u0032\u0037\u0029\u002e".trim());
        testText.add("\u0422\u043e\u043b\u044c\u043a\u043e \u043c\u043e\u0449\u043d\u044b\u0435 \u0441\u0432\u043e\u0431\u043e\u0434\u043d\u044b\u0435 \u043d\u0435\u044d\u043b\u0435\u043a\u0442\u0440\u043e\u0441\u0442\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438\u0435 \u2013 \u0441\u043f\u0438\u043d\u043e\u0432\u044b\u0435 \u0028\u0441\u0442\u043e\u0440\u043e\u043d\u043d\u0438\u0435\u0029 \u044d\u043b\u0435\u043a\u0442\u0440\u0438\u0447\u0435\u0441\u043a\u0438\u0435 \u0437\u0430\u0440\u044f\u0434\u044b \u043f\u0440\u043e\u0442\u043e\u043d\u043e\u0432\u002c \u0432 \u044f\u0434\u0440\u0430\u0445 \u0430\u0442\u043e\u043c\u0430 \u0443\u0433\u043b\u0435\u0440\u043e\u0434\u0430 \u0441\u043e\u0437\u0434\u0430\u044e\u0442 \u0441\u0438\u043b\u043e\u0432\u0443\u044e \u043a\u0440\u0438\u0441\u0442\u0430\u043b\u043b\u0438\u0447\u0435\u0441\u043a\u0443\u044e \u0441\u0442\u0440\u0443\u043a\u0442\u0443\u0440\u0443 \u0433\u0440\u0430\u0444\u0438\u0442\u0430 \u0028\u0420\u0438\u0441\u002e \u0032\u0038\u0029\u002c \u0444\u0443\u043b\u043b\u0435\u0440\u0435\u043d\u0430 \u0028\u0420\u0438\u0441\u002e \u0032\u0039\u0029 \u0438 \u0430\u043b\u043c\u0430\u0437\u0430 \u0028\u0420\u0438\u0441\u002e \u0033\u0030\u0029\u002e".trim());
        testText.add("\u0440\u0438\u0441\u0443\u043d\u043a\u0430\u0445 \u0033\u0031 \u0438 \u0033\u0032 \u0440\u0438\u0441\u0443\u043d\u043a\u0438 \u0033\u0033 \u0438 \u0033\u0034 \u0440\u0438\u0441\u0443\u043d\u043a\u043e\u0432 \u0033\u0037\u002c \u0034\u0030".trim());
    }

    @Test
    public void getSentencesTest() throws Exception {
        sentences = finder.getSentences(fileName);
        int i = 0;
        if (printOn) {
            for (String sentence : sentences) {
                System.out.printf("str %d: %s%n", ++i, sentence);
            }
        }
    }

    @Test
    public void filterTestText() throws Exception {
        final Map<Integer, Tuple2<String, List<Integer>>> picLinks = finder.getPicLinks(testText);
        List<Integer> string0Links = new ArrayList<>(Arrays.asList(3, 4, 5, 15, 16, 25, 26));
        List<Integer> string1Links = new ArrayList<>(Arrays.asList(27));
        List<Integer> string2Links = new ArrayList<>(Arrays.asList(28, 29, 30));
        List<Integer> string3Links = new ArrayList<>(Arrays.asList(31, 32, 33, 34, 37, 40));
        printPicLinks(picLinks);
        assertThat(picLinks.get(0)._2,
                Is.is(string0Links));
        assertThat(picLinks.get(1)._2, Is.is(string1Links));
        assertThat(picLinks.get(2)._2, Is.is(string2Links));
        assertThat(picLinks.get(3)._2, Is.is(string3Links));

    }

    @Test
    public void filterTextFromFile() throws Exception {
        sentences = finder.getSentences(fileName);
        final Map<Integer, Tuple2<String, List<Integer>>> picLinks = finder.getPicLinks(sentences);
        printPicLinks(picLinks);
    }

    @Test
    public void linksAreSorted() throws Exception {
        final Map<Integer, Tuple2<String, List<Integer>>> picLinks1 = finder.getPicLinks(testText);
        assertThat(finder.ifPicLinksSorted(picLinks1), Is.is(true));
    }

    @Test
    public void linksAreNotSorted() throws Exception {
        sentences = finder.getSentences(fileName);
        final Map<Integer, Tuple2<String, List<Integer>>> picLinks2 = finder.getPicLinks(sentences);
        assertThat(finder.ifPicLinksSorted(picLinks2), Is.is(false));
    }
}