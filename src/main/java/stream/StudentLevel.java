package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((x, y) -> Integer.compare(y.getScore(), x.getScore()))
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}
