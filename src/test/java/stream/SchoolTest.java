package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        List<Student> result = School.collect(students,
                student -> student.getScore() > 70);
        List<Student> expected = Arrays.asList(
                new Student(80, "Lisova"),
                new Student(90, "Vilkov"),
                new Student(100, "Vilkova")
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
        List<Student> result = School.collect(students,
                student -> student.getScore() <= 70
                && student.getScore() > 50);
        List<Student> expected = Arrays.asList(
                new Student(60, "Sidorova"),
                new Student(70, "Lisov")
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
        List<Student> result = School.collect(students,
                student -> student.getScore() <= 50
                        && student.getScore() > 0);
        List<Student> expected = Arrays.asList(
                new Student(10, "Ivanov"),
                new Student(20, "Ivanova"),
                new Student(30, "Petrov"),
                new Student(40, "Petrova"),
                new Student(50, "Sidorov")
        );
        assertThat(result, is(expected));
    }

}