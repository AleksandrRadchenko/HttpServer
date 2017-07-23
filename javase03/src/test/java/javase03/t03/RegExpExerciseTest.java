package javase03.t03;

import org.junit.Test;

import java.util.List;

public class RegExpExerciseTest {
    private static final String fileName = "src/main/resources/t03/PicLinksFinder/JF03 - 3.1 - Information handling_task_attachment.html";
    private static PicLinksFinder finder = new PicLinksFinder();

    @Test
    public void getSentencesWithPicturesLinksTest() throws Exception {
        List<String> sentences;
        sentences = finder.getSentencesWithPicturesLinks(fileName);

        for (String sentence : sentences) {
            System.out.println(sentence);
        }

    }

}