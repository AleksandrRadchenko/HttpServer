package t05;

import java.util.Locale;

@SuppressWarnings("WeakerAccess")
public class Task05 {
    /**
     * Prints two-diagonal square matrix with 1 on diagonals.
     * @param n matrix dimension - positive integer.
     */
    @SuppressWarnings("WeakerAccess")
    public void printMatrix(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Please provide positive integer.");
        } else {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.printf(new Locale("ru"),"%d ", ((i == j)|(n - i +1 == j)) ? 1 : 0);
                }
                System.out.println();
            }
        }
    }
}
