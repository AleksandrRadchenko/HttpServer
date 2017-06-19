package javase01.t01;

@SuppressWarnings("WeakerAccess")
public class Task04 {
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
