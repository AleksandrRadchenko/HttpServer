package javase03.t02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18n {
    private String userInput = "";
    private Locale currentLocale = Locale.getDefault();

    public static void main(String[] args) {
        I18n i18n = new I18n();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // Reading language
            while (!"en".equals(i18n.userInput) && !"ru".equals(i18n.userInput) && !"s".equals(i18n.userInput)) {
                System.out.print("Please, choose language ('en' for English, 'ru' for Russian, 's' to stop): ");
                i18n.userInput = br.readLine();
            }
            if ("ru".equals(i18n.userInput)) i18n.currentLocale = new Locale("ru");
            if ("en".equals(i18n.userInput)) i18n.currentLocale = new Locale("en");

            //  --- Block where encoding is chosen using getBytes method and String constructor; ---
            ResourceBundle questions = ResourceBundle.getBundle("t02.I18n.Questions", i18n.currentLocale);
            for (String q : questions.keySet()) {
//                if (!q.equals("q0")) System.out.println(i18n.getResourceInUTF(questions, q));
                if (!q.equals("qNumberPrompt")) System.out.println(questions.getString(q));
            }
            //  --- Block where encoding is chosen using getBytes method and String constructor; ---

            // Reading for question number
            i18n.userInput = "";
            int userInputInt = 0;
            while (!(userInputInt > 0 && userInputInt < questions.keySet().size())) {
                System.out.print(questions.getString("qNumberPrompt"));
                i18n.userInput = br.readLine();
                userInputInt = Integer.parseInt(i18n.userInput);
            }

            // Printing answer
            ResourceBundle answers = ResourceBundle.getBundle("t02.I18n.Answers", i18n.currentLocale);
            System.out.println(answers.getString("a" + userInputInt));

        } catch (MissingResourceException | IOException | NumberFormatException exception) {
            System.out.println(exception);
        }
    }
}