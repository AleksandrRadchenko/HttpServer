import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by ara on 22.07.2017.
 */
public class QuickSortTest {
    private Integer[] ints = {7,3,2,8,5};
    private Integer[] ints2 = {1,2,3,4,5,6,7,8,10,9};
    private Integer[] ints3 = {10,9,8,7,6,5,4,3,2,1};
    private Integer[] ints4 = {10,9,8,7,6,5,4,3,2,1,25};
    @Test
    public void sortTest() throws Exception {
        QuickSort.sort(ints);
        Integer[] expected = {2, 3, 5, 7, 8};
        assertThat(expected, Is.is(ints));
        for (Integer anInt : ints) {
            System.out.print(anInt + ", ");
        }
        System.out.println();
    }

    @Test
    public void sortTest2() throws Exception {
        QuickSort.sort(ints2);
        Integer[] expected = {1,2,3,4,5,6,7,8,9,10};
        assertThat(expected, Is.is(ints2));
        for (Integer anInt : ints2) {
            System.out.print(anInt + ", ");
        }
        System.out.println();
    }

    @Test
    public void sortTest3() throws Exception {
        QuickSort.sort(ints3);
        Integer[] expected = {1,2,3,4,5,6,7,8,9,10};
        assertThat(expected, Is.is(ints3));
        for (Integer anInt : ints3) {
            System.out.print(anInt + ", ");
        }
        System.out.println();
    }

    @Test
    public void sortTest4() throws Exception {
        QuickSort.sort(ints4);
        Integer[] expected = {1,2,3,4,5,6,7,8,9,10,25};
        assertThat(expected, Is.is(ints4));
        for (Integer anInt : ints4) {
            System.out.print(anInt + ", ");
        }
        System.out.println();
    }
}