package t05;

import lombok.NonNull;

import java.util.*;

public class StudentGradesMap {
    private HashMap<Student, List<Number>> map = new HashMap<>();

    @SuppressWarnings("WeakerAccess")
    public StudentGradesMap(Student student) {
        //noinspection unchecked
        map.put(student, Collections.EMPTY_LIST);
    }

    public void addGrade(@NonNull Student student, @NonNull Number grade) {
        if (map.containsKey(student)) {
            map.get(student).add(grade);
        }
    }

    /**
     * Associates Empty list with the specified student in this map.
     * @param student student with whom Empty list is associated.
     * @return true. Returns false if keySet contains student already.
     */
    @SuppressWarnings("WeakerAccess")
    public boolean put(Student student) {
        if (map.containsKey(student)) {
            System.out.printf(new Locale("ru"), "Student %s is in group already%n", student.getName());
            return false;
        } else {
            //noinspection unchecked
            map.put(student, Collections.EMPTY_LIST);
            return true;
        }
    }


    //Standard Map methods further

    @SuppressWarnings("WeakerAccess")
    public Set<Student> keySet() {
        return map.keySet();
    }
    @SuppressWarnings("WeakerAccess")
    public List<Number> put(Student student, List<Number> grades) {
        return map.put(student, grades);
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
