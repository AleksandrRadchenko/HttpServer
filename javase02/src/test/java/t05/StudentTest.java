package t05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StudentTest {

    private Student s1, s2, s3, s4, s5, s6likeS1;
    @Before
    public void setInitialData() throws Exception {
        s1 = new Student("Vasya", 19);
        s2 = new Student("Vasya2", 18);
        s3 = new Student("Vasya3", 21);
        s4 = new Student("Vasya4", 22 );
        s5 = new Student("Vasya5", 19);
        s6likeS1 = new Student("Vasya", 19);
    }

    @Test
    public void getName() throws Exception {
        assertTrue("Vasya2".equals(s2.getName()));
    }

    @Test
    public void getAge() throws Exception {
        assertTrue(22 == s4.getAge());
    }

    @Test
    public void equals() throws Exception {
        assertTrue(s6likeS1.equals(s1));
        assertFalse(s3.equals(s2));
    }

    @Test
    public void toStringTest() throws Exception {
        assertTrue("Student(name=Vasya, age=19)".equals(s1.toString()));
    }

}