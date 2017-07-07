package t05;

import lombok.NonNull;

import java.util.*;

/**
 * Wrapped HashMap that associates student with grades List.
 * Used to split StudentDistributor into more readable parts.
 */
public class StudentGradesMap {
    private HashMap<Student, List<Number>> map = new HashMap<>();
    //Constructors
    @SuppressWarnings("WeakerAccess")
    public StudentGradesMap(@NonNull Student student) {
        //noinspection unchecked
        map.put(student, Collections.EMPTY_LIST);
    }
    @SuppressWarnings("WeakerAccess")
    public StudentGradesMap(@NonNull Student student, @NonNull List<Number> grades) {
        //noinspection unchecked
        map.put(student, grades);
    }

    //Methods

    /**
     * Associates Empty list with the specified student in this map.
     * @param student student with whom Empty list is associated.
     */
    @SuppressWarnings("WeakerAccess")
    public void put(@NonNull Student student) {
        if (map.containsKey(student)) {
            System.out.printf(new Locale("ru"), "Student %s is in group already%n", student.getName());
        } else {
            //noinspection unchecked
            map.put(student, Collections.EMPTY_LIST);
        }
    }
    /**
     * Associates grades list with the specified student in this map.
     * If some list of grades associated with student already, grades will
     * be added to this existent grades list.
     * @param student student with whom grades list should be associated.
     */
    @SuppressWarnings("WeakerAccess")
    public void put(@NonNull Student student,@NonNull List<Number> grades) {
        if (map.containsKey(student)) {
            map.get(student).addAll(grades);
        } else {
            map.put(student, grades);
        }
    }


    //Standard Map methods

    @SuppressWarnings("WeakerAccess")
    public Set<Student> keySet() {
        return map.keySet();
    }
    @SuppressWarnings({"WeakerAccess", "SuspiciousMethodCalls"})
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }
    @SuppressWarnings({"WeakerAccess", "SuspiciousMethodCalls"})
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }
    @SuppressWarnings({"WeakerAccess", "SuspiciousMethodCalls"})
    public List<Number> get(Object key) {
        return map.get(key);
    }
    public int size() {
        return map.size();
    }
}
