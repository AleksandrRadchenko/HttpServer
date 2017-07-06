package t05;

import lombok.NonNull;

import java.util.*;

/**
 * Distributes students in groups by disciplines.
 */
public class StudentsDistributor {
    private HashMap<Discipline, ArrayList<Student>> groups = new HashMap<>();

    /**
     * Adds provided student to the group of students in discipline. If there is no group for
     * provided descipline, such group will be created.
     * @param discipline non null enum Discipline.
     * @param student non null Student object.
     * @return true if added successfully. Returns false if discipline's group contains provided student already.
     */
    public boolean addToGroup(@NonNull Discipline discipline, @NonNull Student student) {
        if (groups.containsKey(discipline)) {
            if (groups.get(discipline).contains(student)) {
                System.out.printf(new Locale("ru"),"Student %s is in group %s already%n", student.getName(), discipline);
                return false;
            } else {
                groups.get(discipline).add(student);
                return true;
            }
        } else {
            groups.put(discipline, new ArrayList<>(Collections.singletonList(student)));
            return true;
        }
    }
}
