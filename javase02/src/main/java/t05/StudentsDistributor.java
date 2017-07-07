package t05;

import lombok.NonNull;

import java.util.*;

/**
 * Distributes students and grades in groups by disciplines.
 */
@SuppressWarnings("WeakerAccess")
public class StudentsDistributor {

    private HashMap<Discipline, StudentGradesMap> groups = new HashMap<>();


    /**
     * Adds student to the group of students in discipline. If there is no group for
     * provided descipline, such group will be created. In the created group given student
     * will be associated with empty List of grades.
     * @param discipline non null enum Discipline.
     * @param student non null Student object.
     * @return true if added successfully. Returns false if discipline's group contains provided student already.
     */
    @SuppressWarnings("WeakerAccess")
    public boolean addToGroup(@NonNull Discipline discipline, @NonNull Student student) {
        if (groups.containsKey(discipline)) {
            return groups.get(discipline).put(student);
        } else {
            groups.put(discipline, new StudentGradesMap(student));
            return true;
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



}
