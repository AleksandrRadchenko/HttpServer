package t05;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Record {
    private Student student;
    private ArrayList<Number> grades;

    public void addGrade(@NonNull Student student, @NonNull Number grade) {

    }
}
