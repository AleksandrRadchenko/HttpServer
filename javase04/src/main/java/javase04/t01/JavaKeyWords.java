package javase04.t01;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JavaKeyWords {
    @Getter
    private static List<String> javaKeyWords = new ArrayList<>(Arrays.asList(
            "abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package",
            "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements",
            "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof",
            "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface",
            "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native",
            "super", "while"));

    private JavaKeyWords(){};
}
