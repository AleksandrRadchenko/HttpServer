package javase01.t01;

import java.io.*;
import java.util.*;

public class Task03 {
	private static final double a, b, h;
	Map resultMap = new HashMap<Double, Double>();
	public static void main (String[] args) {
		readDataFromUser();
		checkInputedData();
		calcFunctionFValues();
		System.out.printf("a=%f, b=%f, h=%f%n", a, b, h);
	}
	static void calcFunctionFValues() {

	}
	private static double funcionF(double x) {
		return Math.tan(2 * x) + 3;
	}

	private static void readDataFromUser() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.printf("Please, enter a: ");
			a = Double.parseDouble(br.readLine());
			System.out.printf("Please, enter b: ");
			b = Double.parseDouble(br.readLine());
			System.out.printf("Please, enter h: ");
			h = Double.parseDouble(br.readLine());
		} catch (IOException e) {
			System.out.printf("%nIOexception is thrown. Do smth :) %nError: %s%n", e);
			System.exit(0);
		} catch (NumberFormatException|NullPointerException e) {
			System.out.printf("%nYou should enter real number.%nError: %s%n", e);
			System.exit(0);
		}
	}
	
	private static void checkInputedData() {
		if (!(a < b && h > 0)) {
			System.out.printf("%nPlease, review arguments. Should be a < b and h > 0.%n");
			System.exit(0);
		}
	}

}
