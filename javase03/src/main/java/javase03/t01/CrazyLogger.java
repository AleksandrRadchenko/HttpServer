package javase03.t01;

import java.util.*;

@SuppressWarnings("WeakerAccess")
public class CrazyLogger {
    Locale locale = new Locale("ru");
    StringBuilder sb = new StringBuilder();
    // Send all output to the Appendable object sb
    Formatter formatter = new Formatter(sb, locale);

    public void log(String message) {
        if (message != null) {
            formatter.format("%1$td-%1$tm-%1$tY : %1$tH-%1$tM - ", Calendar.getInstance());
            formatter.format(message);
            formatter.format(";%n");
        }
    }

    @SuppressWarnings("SameParameterValue")
    public String[] search(String searchString){
        String[] rows = sb.toString().split(System.getProperty("line.separator"));
        System.out.printf("Lines containing \"%s\":%n", searchString);
        Arrays.asList(rows).forEach(s -> {if (s.contains(searchString)) System.out.printf("%s%n", s);});
        return rows;
    }

    public String printAll() {
        return sb.toString();
    }
}
