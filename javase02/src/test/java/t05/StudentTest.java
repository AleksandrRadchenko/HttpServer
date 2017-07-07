package t05;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StudentTest {

    private Student s1, s2, s3, s4, s5, s6likeS1;
    private StudentsDistributor sd;

    @Before
    public void setInitialData() throws Exception {
        s1 = new Student("Vasya", 19);
        s2 = new Student("Vasya2", 18);
        s3 = new Student("Vasya3", 21);
        s4 = new Student("Vasya4", 22 );
        s5 = new Student("Vasya5", 19);
        s6likeS1 = new Student("Vasya", 19);
        sd = new StudentsDistributor();
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

    @Test
    public void addStudentToGroup() throws Exception {
        boolean result = sd.addToGroup(Discipline.MATH, s1);
        assertTrue(result);
        assertTrue((sd.showAllGroups().contains(Discipline.MATH)) && (sd.showAllGroups().size() == 1));
        assertTrue("Student(name=Vasya, age=19)".equals(s1.toString()));
    }

    @Test
    public void addStudentToGroupTwoTimes() throws Exception {
        boolean result = sd.addToGroup(Discipline.MATH, s1);
        boolean result2 = sd.addToGroup(Discipline.MATH, s1);
        assertTrue(result);
        assertFalse(result2);
        assertTrue((sd.showAllGroups().contains(Discipline.MATH)) && (sd.showAllGroups().size() == 1));
        assertTrue("Student(name=Vasya, age=19)".equals(s1.toString()));
    }

    @Test
    public void showAllGroups() throws Exception {
        sd.addToGroup(Discipline.MATH, s1);
        sd.addToGroup(Discipline.HISTORY, s1);
        ArrayList<Discipline> listForSorting = new ArrayList<>(sd.showAllGroups());
        Collections.sort(listForSorting);
        assertTrue("[MATH, HISTORY]".equals(listForSorting.toString()));
    }

    @Test
    public void showGroups() throws Exception {
        sd.addToGroup(Discipline.MATH, s1);
        sd.addToGroup(Discipline.HISTORY, s1);
        sd.addToGroup(Discipline.HISTORY, s2);
        sd.addToGroup(Discipline.HISTORY, s3);
        sd.addToGroup(Discipline.LANG, s2);
        ArrayList<Discipline> listForSorting = new ArrayList<>(sd.showGroups(s1));
        Collections.sort(listForSorting);
        assertTrue("[HISTORY, MATH]".equals(listForSorting.toString()));
        listForSorting = new ArrayList<>(sd.showGroups(s2));
        Collections.sort(listForSorting);
        assertTrue("[HISTORY, LANG]".equals(listForSorting.toString()));
    }


//    @Test
//    public void test() throws Exception {
//        ArrayList<String> list = new ArrayList<>(Arrays.asList("LANG", "HISTORY", "MATH"));
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);
//    }

}