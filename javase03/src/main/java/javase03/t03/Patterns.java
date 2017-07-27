package javase03.t03;

/**
 * Created by ara on 27.07.2017.
 */
public interface Patterns {
    // For getPicLinks
    // Picture link pattern with capturing group for first and second link
    // p = Pattern.compile("(?<=[кс][.аеиоу][вх\\s]\\s?)(\\d{1,3})([, ил]+(\\d{1,3}))?");
    static String PIC_LINKS_PATTERN = "(?<=[\u043a\u0441][.\u0430\u0435\u0438\u043e\u0443][\u0432\u0445\\s]\\s?)(\\d{1,3})([, \u0438\u043b]+(\\d{1,3}))?";
    // p = Pattern.compile("[А-ЯЁ][А-ЯЁа-яёa-z\\w\\s\\d\\p{Punct}«»–]*?[!.?]\\s+(?=[А-ЯЁ]|$)");
    static String SENTENCE_PATTERN = "[\u0410-\u042f\u0401][\u0410-\u042f\u0401\u0430-\u044f\u0451a-z\\w\\s\\d\\p{Punct}\u00ab\u00bb–]*?[!.?]\\s+(?=[\u0410-\u042f\u0401]|$)";
    // Мнения ученых
    static String MNENIYA_UCHENYH = "\u041c\u043d\u0435\u043d\u0438\u044f \u0443\u0447\u0435\u043d\u044b\u0445";
    // ">Рис.\\s*?\\d+"
    static String PIC_CAPTIONS = ">\u0420\u0438\u0441.\\s*?\\d+";


}
