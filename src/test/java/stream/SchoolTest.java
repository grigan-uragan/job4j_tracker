package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SchoolTest {

    @Test
    public void whenStudentForA() {
        List<Student> students = Arrays.asList(
                new Student(10, "Ivanov"),
                new Student(20, "Ivanova"),
                new Student(30, "Petrov"),
                new Student(40, "Petrova"),
                new Student(50, "Sidorov"),
                new Student(60, "Sidorova"),
                new Student(70, "Lisov"),
                new Student(80, "Lisova"),
                new Student(90, "Vilkov"),
                new Student(100, "Vilkova")
        );
        Map<String, Student> result = School.collect(students,
                student -> student.getScore() >= 70);
        Map<String, Student> expected = Map.of(
                "Lisov", new Student(70, "Lisov"),
                "Lisova", new Student(80, "Lisova"),
                "Vilkov", new Student(90, "Vilkov"),
                "Vilkova",  new Student(100, "Vilkova")

        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentForB() {
        List<Student> students = Arrays.asList(
                new Student(10, "Ivanov"),
                new Student(20, "Ivanova"),
                new Student(30, "Petrov"),
                new Student(40, "Petrova"),
                new Student(50, "Sidorov"),
                new Student(60, "Sidorova"),
                new Student(70, "Lisov"),
                new Student(80, "Lisova"),
                new Student(90, "Vilkov"),
                new Student(100, "Vilkova")
        );
        Map<String, Student> result = School.collect(students,
                student -> student.getScore() < 70
                && student.getScore() >= 50);
        Map<String, Student> expected = Map.of(
                "Sidorov", new Student(50, "Sidorov"),
                "Sidorova", new Student(60, "Sidorova")
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentForC() {
        List<Student> students = Arrays.asList(
                new Student(10, "Ivanov"),
                new Student(20, "Ivanova"),
                new Student(30, "Petrov"),
                new Student(40, "Petrova"),
                new Student(50, "Sidorov"),
                new Student(60, "Sidorova"),
                new Student(70, "Lisov"),
                new Student(80, "Lisova"),
                new Student(90, "Vilkov"),
                new Student(100, "Vilkova")
        );
        Map<String, Student> result = School.collect(students,
                student -> student.getScore() < 50
                        && student.getScore() > 0);
        Map<String, Student> expected = Map.of(
                "Ivanov",  new Student(10, "Ivanov"),
                "Ivanova", new Student(20, "Ivanova"),
                "Petrov", new Student(30, "Petrov"),
                "Petrova", new Student(40, "Petrova")
        );
        assertThat(result, is(expected));
    }

}