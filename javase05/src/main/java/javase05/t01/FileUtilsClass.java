package javase05.t01;

/**
 * Class to show current directory when main method runs. Used to investigate codeship.com environment.
 */
public class FileUtilsClass {
    public static void main(String[] args) {
        getCurrentDirectory();
    }

    public static void getCurrentDirectory() {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
    }
}
