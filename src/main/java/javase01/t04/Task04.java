package javase01.t04;

@SuppressWarnings("WeakerAccess")
public class Task04 {
    /**
     * Determines max value of (a_1 + a_2n, a_2 + a_2n-1, ..., a_n + a_n+1) for a_1, a_2, ..., a_m input arguments.
     * @param args varargs of double, one or more.
     * @return maximum value of [a_i + a_2n-i+1]
     * @throws IllegalArgumentException if no args are provided.
     */
    public double max(double... args) throws IllegalArgumentException {
        if (args.length > 1) {
            double max = args[0] + args[args.length - 1];
            for (int i = 1; i < args.length / 2; i++) {
                if (args[i] + args[args.length - i - 1] > max) max = args[i] + args[args.length - i - 1];
            }
            return max;
        } else if (args.length == 1) {
            return args[0];
        } else {
            throw new IllegalArgumentException("Please, provide at least one argument (type = double).");
        }
    }
}
