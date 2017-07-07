package t05;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StudentTest {

    private Student s1, s2, s3, s4, s5, s6likeS1;
    private StudentsDistributor sd, sd1;

    @Before
    public void setInitialData() throws Exception {
        s1 = new Student("Vasya1", 19);
        s2 = new Student("Vasya2", 18);
        s3 = new Student("Vasya3", 21);
        s4 = new Student("Vasya4", 22 );
        s5 = new Student("Vasya5", 19);
        s6likeS1 = new Student("Vasya1", 19);
        sd = new StudentsDistributor();
        //Populating group with discipline-student-grades
        sd1 = new StudentsDistributor();
        sd1.addStudentToGroup(Discipline.MATH, s1, Arrays.asList(3, 5, 4, 2));
        sd1.addStudentToGroup(Discipline.HISTORY, s1, Arrays.asList(2.3, 3.7, 1.2));
        sd1.addStudentToGroup(Discipline.HISTORY, s2, Arrays.asList(4.7, 4.5, 4.9, 5.0));
        sd1.addStudentToGroup(Discipline.HISTORY, s3, Arrays.asList(1.1, 1.5));
        sd1.addStudentToGroup(Discipline.LANG, s2, Arrays.asList(4.6, 4.0, 4.4));
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
        assertTrue("Student(name=Vasya1, age=19)".equals(s1.toString()));
    }

    @Test
    public void addStudentToGroup() throws Exception {
        sd.addStudentToGroup(Discipline.MATH, s1);
        assertTrue((sd.showAllGroups().contains(Discipline.MATH)) && (sd.showAllGroups().size() == 1));
        assertTrue("Student(name=Vasya1, age=19)".equals(s1.toString()));
    }

    @Test
    public void addStudentToGroupTwoTimes() throws Exception {
        sd.addStudentToGroup(Discipline.MATH, s1);
        sd.addStudentToGroup(Discipline.MATH, s1);
        assertTrue((sd.showAllGroups().contains(Discipline.MATH)) && (sd.showAllGroups().size() == 1));
        assertTrue("Student(name=Vasya1, age=19)".equals(s1.toString()));
    }

    @Test
    public void showAllGroups() throws Exception {
        sd.addStudentToGroup(Discipline.MATH, s1);
        sd.addStudentToGroup(Discipline.HISTORY, s1);
        ArrayList<Discipline> listForSorting = new ArrayList<>(sd.showAllGroups());
        Collections.sort(listForSorting);
        assertTrue("[HISTORY, MATH]".equals(listForSorting.toString()));
    }

    @Test
    public void showGroups() throws Exception {
        sd.addStudentToGroup(Discipline.MATH, s1);
        sd.addStudentToGroup(Discipline.HISTORY, s1);
        sd.addStudentToGroup(Discipline.HISTORY, s2);
        sd.addStudentToGroup(Discipline.HISTORY, s3);
        sd.addStudentToGroup(Discipline.LANG, s2);
        ArrayList<Discipline> listForSorting = new ArrayList<>(sd.showGroups(s1));
        Collections.sort(listForSorting);
        assertTrue("[HISTORY, MATH]".equals(listForSorting.toString()));
        listForSorting = new ArrayList<>(sd.showGroups(s2));
        Collections.sort(listForSorting);
        assertTrue("[HISTORY, LANG]".equals(listForSorting.toString()));
    }

    @Test
    public void showGradesByGoup() throws Exception {
        String expectedString = "{MATH=[3, 5, 4, 2], HISTORY=[2.3, 3.7, 1.2]}";
        String actualString = sd1.showGradesByGoup(s1).toString();
            assertTrue(expectedString.equals(actualString));
        expectedString = "{LANG=[4.6, 4.0, 4.4], HISTORY=[4.7, 4.5, 4.9, 5.0]}";
        actualString = sd1.showGradesByGoup(s2).toString();
            assertTrue(expectedString.equals(actualString));
        expectedString = "{HISTORY=[1.1, 1.5]}";
        actualString = sd1.showGradesByGoup(s3).toString();
            assertTrue(expectedString.equals(actualString));
        System.out.println("Student's " + s1.getName() + " grades by groups: " + sd1.showGradesByGoup(s1));
        System.out.println("Student's " + s2.getName() + " grades by groups: " + sd1.showGradesByGoup(s2));
        System.out.println("Student's " + s3.getName() + " grades by groups: " + sd1.showGradesByGoup(s3));
    }

    @Test
    public void showAverageGradesByGoup() throws Exception {
        assertTrue("{LANG=4.333333333333333, HISTORY=4.775}".equals(sd1.showAverageGradesByGroup(s2).toString()));
    }


}