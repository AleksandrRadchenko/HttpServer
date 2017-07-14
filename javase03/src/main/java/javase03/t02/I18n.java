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
        if ("ru".equals(i18n.userInput)) i18n.currentLocale = new Locale("ru");
        if ("en".equals(i18n.userInput)) i18n.currentLocale = new Locale("en");
        ResourceBundle questions = ResourceBundle.getBundle("Questions", i18n.currentLocale);
        for (String q : questions.keySet()) {
            System.out.println(q);
        }

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
