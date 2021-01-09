package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MemTrackerSingleThreeTest {

    @Test
    public void whenSingleton() {
        TrackerSingleThree one = TrackerSingleThree.getInstance();
        TrackerSingleThree two = TrackerSingleThree.getInstance();
        assertThat(one.equals(two), is(true));
    }
}