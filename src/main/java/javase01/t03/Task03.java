package javase01.t03;

import java.util.*;

@SuppressWarnings("WeakerAccess")
public class Task03 {
    /**
     * Prints table with keySet as first column and values as second column.
     * @param map map of Doubles to print
     */
    @SuppressWarnings("WeakerAccess")
    public void printAsTable(Map<Double, Double> map) {
        for (Map.Entry<Double, Double> entry : map.entrySet()) {
            System.out.printf(new Locale("ru"), "%f | %f%n", entry.getKey(), entry.getValue());
        }
    }

    /**
     * Calculates values of F(x) = tg(2x)-3 for each x on [a, b] with step h.
     * @param a beginning of x interval,
     * @param b end of x interval,
     * @param h step.
     * @return TreeMap with x as keys and F(x) as values.
     * @throws IllegalArgumentException if b > a, or h <= 0.
     */
    @SuppressWarnings("WeakerAccess")
    public Map<Double, Double> F(double a, double b, double h) throws IllegalArgumentException {
        if (!(a < b && h > 0)) {
            throw new IllegalArgumentException("Please, review arguments. Should be a < b and h > 0.");
        }
        Map<Double, Double> f = new TreeMap<>();
            for (double i = a; i <= b; i += h) {
                f.put(i, Math.tan(2 * i) - 3);
            }
        return f;
    }
}
