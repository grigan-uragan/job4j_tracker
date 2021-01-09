package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MemTrackerSingleFourTest {

    @Test
    public void whenSingleton() {
        TrackerSingleFour one = TrackerSingleFour.getInstance();
        TrackerSingleFour two = TrackerSingleFour.getInstance();
        assertThat(one.equals(two), is(true));
    }
}