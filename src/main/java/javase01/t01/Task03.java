package javase01.t01;

import static java.lang.Math.*;
import java.util.*;

@SuppressWarnings("WeakerAccess")
public class Task03 {
    @SuppressWarnings("WeakerAccess")
    public void printAsTable(Map<Double, Double> map) {
        for (Map.Entry<Double, Double> entry : map.entrySet()) {
            System.out.printf(new Locale("ru"), "%f | %f%n", entry.getKey(), entry.getValue());
        }
    }

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
