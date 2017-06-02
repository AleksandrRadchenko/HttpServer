package javase01.t01;

public class Task02 {
	public static void main (String[] args) {
		System.out.println(checkArgs(args));
	}

	static double checkArgs(String[] args) {
		if (args.length == 0) {
			System.out.println("Please, provide correct epsilon argument");
			System.exit(0);
		}
		double result = 0.0d;
		try {
			result = Double.parseDouble(args[0]);
			if (result < Double.MIN_VALUE) {
				System.out.println("Epsilon should be positive double");
				System.exit(0);
			}
		} catch (NumberFormatException e) {
			System.out.println("Epsilon should be positive double (parsing exception)");
			System.exit(0);
		}
		return result;
	}
}
