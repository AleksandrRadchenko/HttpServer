package t05;

import lombok.NonNull;

import java.util.*;

/**
 * Distributes students and grades in groups by disciplines.
 */
@SuppressWarnings("WeakerAccess")
public class StudentsDistributor {

//    private HashMap<Discipline, StudentGradesMap> groups = new HashMap<>();
    private EnumMap groups = new EnumMap(Discipline.class);


    /**
     * Adds student to the group of students in discipline. If there is no group for
     * provided descipline, such group will be created. In the created group given student
     * will be associated with empty List of grades.
     * @param discipline non null enum Discipline.
     * @param student non null Student object.
     */
    @SuppressWarnings("WeakerAccess")
    public void addStudentToGroup(@NonNull Discipline discipline, @NonNull Student student) {
        if (groups.containsKey(discipline)) {
            groups.get(discipline).put(student);
        } else {
            groups.put(discipline, new StudentGradesMap(student));
        }
    }
    @SuppressWarnings("WeakerAccess")
    public void addStudentToGroup(@NonNull Discipline discipline, @NonNull Student student, @NonNull List<Number> grades) {
        if (groups.containsKey(discipline)) {
            groups.get(discipline).put(student, grades);
        } else {
            groups.put(discipline, new StudentGradesMap(student, grades));
        }
    }





    @SuppressWarnings("WeakerAccess")
    public Set<Discipline> showAllGroups() {
        return groups.keySet();
    }

    /**
     * Searches for groups to which student belongs.
     * @param student NonNull student.
     * @return a set view of goups, to which student belongs.
     */
    @SuppressWarnings("WeakerAccess")
    public Set<Discipline> showGroups(@NonNull Student student) {
        Set<Discipline> result = new HashSet<>();
        for (Discipline discipline : groups.keySet()) {
            if (groups.get(discipline).containsKey(student)) result.add(discipline);
        }
        return result;
    }


    /**
     * Returns Map which associates discipline with grades list for given student.
     * @param student
     * @return
     */
    public Map<Discipline, List<Number>> showGradesByGoup(@NonNull Student student) {
        Map<Discipline, List<Number>> output = new HashMap<>();
        for (Discipline discipline : Discipline.values()) {
            if ((groups.containsKey(discipline)) && (groups.get(discipline).containsKey(student)))
                output.put(discipline, groups.get(discipline).get(student));
        }
        return output;
    }

    public Map<Discipline, Number> showAverageGradesByGroup(@NonNull Student student) {
        Map<Discipline, Number> output = new HashMap<>();
        Map<Discipline, List<Number>> gradesByGroup = showGradesByGoup(student);
        for (Discipline discipline : gradesByGroup.keySet()) {
            output.put(discipline, averageGrade(discipline, gradesByGroup.get(discipline)));
        }
        return output;
    }

    private double averageGrade(Discipline discipline, List<Number> grades) {
            double output = 0.0;
            for (Number n : grades) output += (double) n;
            return (grades.size() == 0 ? 0 : output / grades.size());
    }
}
