package javase03.t03;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RegExpExerciseTest {
    private static final String fileName = "src/main/resources/t03/PicLinksFinder/JF03 - 3.1 - Information handling_task_attachment.html";
    private static PicLinksFinder finder = new PicLinksFinder();
    private static List<String> sentences;
    private static List<Integer> picLinkNumbers;


    @Test
    public void getSentencesWithPicturesLinksTest() throws Exception {
        sentences = finder.getSentencesWithPicturesLinks(fileName);
        int i = 0;
        for (String sentence : sentences) {
            System.out.printf("str %d: %s%n", ++i, sentence);
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
        List<Integer> picLinks = Collections.singletonList(Integer.valueOf(0));
        for (String sentence : sentences) {
            picLinks = finder.getPicLinkNumberFromSentence(sentence);
            if (picLinks.get(0) != 0) picLinkNumbers.addAll(picLinks);
        }
    }

}