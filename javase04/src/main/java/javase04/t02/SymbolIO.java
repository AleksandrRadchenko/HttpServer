package javase04.t02;

import javase04.t01.JavaKeyWords;
import javase04.t01.Strings;
import javase04.t01.TextProcessor;

import java.util.Map;

public class SymbolIO {
    public static void main(String[] args) {
        String inputFromFile;
        inputFromFile = TextProcessor.readFileViaCharStreams(Strings.INPUT_FILE_PATH + Strings.INPUT_FILE_NAME);
        inputFromFile = TextProcessor.removeStringLiterals(inputFromFile);
        Map<String, Integer> detectedWords = TextProcessor.detectKeyWords(inputFromFile, JavaKeyWords.getJavaKeyWords());
        StringBuilder output = new StringBuilder();
        for (String word : detectedWords.keySet()) {
            output.append(word).append(": ").append(detectedWords.get(word)).append(System.getProperty("line.separator"));
        }
        TextProcessor.writeToFileViaCharStream(output.toString(), Strings.OUTPUT_FILE_PATH_T02 + Strings.INPUT_FILE_NAME + ".txt");
    }
}
