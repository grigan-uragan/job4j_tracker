package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "First Order"));
        Map<String, Order> map =  OrderConvert.process(orders);
        assertThat(map.get("1"), is(new Order("1", "First Order")));
    }
}