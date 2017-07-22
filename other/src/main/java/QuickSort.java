@SuppressWarnings("WeakerAccess")
public class QuickSort {
    public static <T extends Comparable<T>> void sort(T... array) {
        sort0(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void sort0(T[] array, int start, int end) {
        if (start < end) {
            T median = array[(start + end) / 2];
            int i = start;
            int j = end;
            while (i < j) {
                while (array[i].compareTo(median) < 0)
                    i++;
                while (array[j].compareTo(median) > 0)
                    j--;
                swap(array, i, j);
            }
            sort0(array, start, i - 1);
            sort0(array, j + 1, end);
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        assert i >= 0 && i < array.length && j >= 0 && j < array.length;
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}
