package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MemTrackerSingleTwoTest {

    @Test
    public void whenSingleton() {
        TrackerSingleTwo one = TrackerSingleTwo.getInstance();
        TrackerSingleTwo two = TrackerSingleTwo.getInstance();
        assertThat(one.equals(two), is(true));
    }

}