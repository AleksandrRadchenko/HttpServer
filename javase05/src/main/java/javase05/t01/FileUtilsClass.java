package javase05.t01;

public class FileUtilsClass {
    public static void main(String[] args) {
        getCurrentDirectory();
    }

    public static void getCurrentDirectory() {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
    }
}
