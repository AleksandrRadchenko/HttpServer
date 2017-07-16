package javase03.t02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {
    private String userInput = "";
    Locale currentLocale = Locale.getDefault();

    public static void main(String[] args) {
        I18n i18n = new I18n();
        i18n.readUserInput();
// Default locale for testing
//        i18n.currentLocale = new Locale("ru");

//  --- Block where encoding is chosen in UTF8Control class. ---
        if ("ru".equals(i18n.userInput)) i18n.currentLocale = new Locale("ru");
        if ("en".equals(i18n.userInput)) i18n.currentLocale = new Locale("en");
        ResourceBundle questions = ResourceBundle.getBundle("t02.I18n.Questions", i18n.currentLocale, new UTF8Control());
        for (String q : questions.keySet()) {
            System.out.println(questions.getString(q));
        }
//  --- Block where encoding is chosen in UTF8Control class. ---


//  --- Block where encoding is chosen using getBytes method and String constructor; ---
//        ResourceBundle questions = ResourceBundle.getBundle("t02.I18n.Questions", i18n.currentLocale);
//        try {
//            for (String q : questions.keySet()) {
//                System.out.println(new String(questions.getString(q).getBytes("ISO-8859-1"), "UTF-8"));
//            }
//        } catch (UnsupportedEncodingException e) {
//            System.out.println(e);
//        }
//  --- Block where encoding is chosen using getBytes method and String constructor; ---
    }

    private void readUserInput() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (!"en".equals(userInput) && !"ru".equals(userInput) && !"s".equals(userInput)) {
                System.out.print("Please, choose language ('en' for English, 'ru' for Russian, 's' to stop): ");
                userInput = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
