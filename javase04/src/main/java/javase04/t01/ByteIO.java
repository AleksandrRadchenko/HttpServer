package javase04.t01;

import java.util.Map;

public class ByteIO {
    public static void main(String[] args) {
        String inputFromFile;
        inputFromFile = TextProcessor.readFileViaByteStream(Strings.INPUT_FILE_PATH + Strings.INPUT_FILE_NAME);
        inputFromFile = TextProcessor.removeStringLiterals(inputFromFile);
        Map<String, Integer> detectedWords = TextProcessor.detectKeyWords(inputFromFile, JavaKeyWords.getJavaKeyWords());
        StringBuilder output = new StringBuilder();
        for (String word : detectedWords.keySet()) {
            output.append(word).append(": ").append(detectedWords.get(word)).append(System.getProperty("line.separator"));
        }
        TextProcessor.writeToFileViaByteStream(output.toString(), Strings.OUTPUT_FILE_PATH_T01 + Strings.INPUT_FILE_NAME + ".txt");
    }

}
