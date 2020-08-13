package stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public static Map<String, Student> collect(List<Student> students,
                                               Predicate<Student> predicate) {
        return students.stream()
                        .filter(predicate)
                        .collect(Collectors.toMap(Student::getSurname,
                                student -> student, (v1, v2) -> v1 = v2));
    }
}
