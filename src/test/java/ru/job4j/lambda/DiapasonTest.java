package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DiapasonTest {

    @Test
    public void whenLinearFunction() {
        List<Double> result = Diapason.func(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11d, 13d, 15d, 17d);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = Diapason.func(5, 8, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(25d, 36d, 49d, 64d);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> result = Diapason.func(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32d, 64d, 128d, 256d);
        assertThat(result, is(expected));
    }
}