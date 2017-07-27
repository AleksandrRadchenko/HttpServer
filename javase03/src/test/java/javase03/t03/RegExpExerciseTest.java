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
        testText.add("        В электроне (позитроне) гамма-коллапсары образуют семь гамма-трубок (Рис. 3), в каждой из семи гамма-трубок по семь элементарных Рисунке 4 и рисунка 5 трубок, всего в (Рис. 15,16) (Рис. 25 и 26) электроне (позитроне) 49 элементарных трубок, сорок девятая трубка расположена в центре.".trim());
        testText.add("                Новое описание истинной структуры ядра атома углерода основано на универсальных свойствах коллапсаров-нуклонов в силовых структурах трёх альф, расположенных в ядерной трубке атома углерода с взаимным относительным смещением на 60 (рис. 27).".trim());
        testText.add("        Только мощные свободные неэлектростатические – спиновые (сторонние) электрические заряды протонов, в ядрах атома углерода создают силовую кристаллическую структуру графита (Рис. 28), фуллерена (Рис. 29) и алмаза (Рис. 30).".trim());
        testText.add("   рисунках 31 и 32 рисунки 33 и 34 рисунков 37, 40".trim());
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
        assertThat(picLinks.get(0)._2, Is.is(string0Links));
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