package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class JobTest {

    @Test
    public void whenGreatName() {
        Job first = new Job("Alpha", 10);
        Job second = new Job("Beta", 10);
        Comparator<Job> comparator = new JobGreatName();
        int result = comparator.compare(first, second);
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenGreatPriority() {
        Job first = new Job("Alpha", 100);
        Job second = new Job("Beta", 10);
        Comparator<Job> comparator = new JobGreatPriority();
        int result = comparator.compare(first, second);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenDescPriority() {
        Job first = new Job("Alpha", 100);
        Job second = new Job("Beta", 10);
        Comparator<Job> comparator = new JobDescPriority();
        int result = comparator.compare(first, second);
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenDescName() {
        Job first = new Job("Alpha", 10);
        Job second = new Job("Beta", 10);
        Comparator<Job> comparator = new JobDescName();
        int result = comparator.compare(first, second);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenNameEqualsGreatPriority() {
        Job first = new Job("Alpha", 100);
        Job second = new Job("Alpha", 10);
        Comparator<Job> comparator = new JobGreatName().thenComparing(new JobGreatPriority());
        int result = comparator.compare(first, second);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenPriorityEqualsGreatName() {
        Job first = new Job("Alpha", 10);
        Job second = new Job("Gamma", 10);
        Comparator<Job> comparator = new JobGreatPriority().thenComparing(new JobGreatName());
        int result = comparator.compare(first, second);
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenNameEqualsDescPriority() {
        Job first = new Job("Alpha", 100);
        Job second = new Job("Alpha", 10);
        Comparator<Job> comparator = new JobGreatName().thenComparing(new JobDescPriority());
        int result = comparator.compare(first, second);
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenPriorityEqualsDescName() {
        Job first = new Job("Alpha", 10);
        Job second = new Job("Alphaz", 10);
        Comparator<Job> comparator = new JobGreatPriority().thenComparing(new JobDescName());
        int result = comparator.compare(first, second);
        assertThat(result, greaterThan(0));
    }
}