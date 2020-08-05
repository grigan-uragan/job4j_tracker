package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class TrackerSingleOneTest {
    @Test
    public void whenSingleton() {
        TrackerSingleOne one = TrackerSingleOne.INSTANCE;
        TrackerSingleOne two = TrackerSingleOne.INSTANCE;
        assertThat(one.equals(two), is(true));
    }
}