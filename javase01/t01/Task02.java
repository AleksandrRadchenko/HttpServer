package javase01.t01;

/**
* Finds the least number of the sequence elements, which satisfies M condition.
* Prints this number and all elements a_i, where i = 1, 2, ..., n.
* a_n = 1 / (n + 1)^2, M : a_n < E.
* Accept positive real number E as command line argument.
*/

public class Task02 {
	private Task02() {}
	public static void main (String[] args) {
		printResult(calcN(checkArgs(args)));
	}

	/**
	* Checks whether args contain acceptable E. Stops execution in any other case.
	* @param args args[0] should be positive real number
	* @return double contents of args[0] if it parses to double
	*/

	private static double checkArgs(String[] args) {
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
			System.out.println("Epsilon should be positive double (NumberFormatException)");
			System.exit(0);
		}
		System.out.printf("E=%f%n", result); 
		return result;
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
		System.out.printf("Number of the least element, wich satisfies M condition: %d%n", n);
		System.out.print("Elements: ");
		for (int i = 1; i < n; i++) {
			System.out.printf("a_%d=%f, ", i, 1/Math.pow(i + 1, 2));
		}
		System.out.printf("a_%d=%f", n, 1/Math.pow(n + 1, 2));
		System.out.println();
	}
}
