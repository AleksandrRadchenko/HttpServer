package javase01.t01;

import java.security.InvalidParameterException;
import java.util.Locale;

/**
* Finds the least number (n) of the sequence of elements, which satisfies M condition.
* Prints this number and all elements a_i, where i = 1, 2, ..., n.
* a_n = 1 / (n + 1)^2, M : a_n < E.
* Accept positive real number E as command line argument.
*/

public class Task02 {
	private Task02() {}

	public static void main(String[] args) {
		String[] args_temp = {"0.003"};
		printResult(calcN(checkArgs(args_temp)));
	}

	public static void calcAndPrintN(String[] args) {
		printResult(calcN(checkArgs(args)));
	}

    /**
     * Checks whether args contain acceptable E.
     *
     * @param args args[0] should be positive real number.
     * @return contents of args[0] in form of double.
     * @throws InvalidParameterException if empty or non-positive number is provided.
     * @throws NumberFormatException if args can't be parsed.
     */
    private static double checkArgs(String[] args) throws InvalidParameterException, NumberFormatException {
		if (args.length == 0) {
			throw new InvalidParameterException("Please, provide correct epsilon argument");
		}
		double result = 0.0d;
		try {
			result = Double.parseDouble(args[0]);
			if (result < Double.MIN_VALUE) {
				throw new InvalidParameterException("Epsilon should be positive double");
			}
			System.out.printf("E=%f%n", result);
			return result;
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Epsilon should be positive double");
		}
	}

	/**
	* Calculate n. Algorithm time complexity O(1)
	* @param E positive real number
	* @return long n
	*/
    private static long calcN (double E) {
		return (long) (1.0/Math.sqrt(E));
	}

	/**
	* Prints n and all elements a_i = 1 / (i + 1)^2, where i = 1, 2, ... , n;
	* @param n positive integer
	*/
    private static void printResult (long n) {
		n = n == 0 ? 1 : n;
		System.out.printf("Number of the least element, which satisfies M condition: %d%n", n);
		System.out.print("Elements: ");
		Locale ruLocale = new Locale("ru");
		for (int i = 1; i < n; i++) {
			System.out.printf(ruLocale, "a_%d=%f, ", i, 1/Math.pow(i + 1, 2));
		}
		System.out.printf(ruLocale,"a_%d=%f", n, 1/Math.pow(n + 1, 2));
		System.out.println();
	}
}
