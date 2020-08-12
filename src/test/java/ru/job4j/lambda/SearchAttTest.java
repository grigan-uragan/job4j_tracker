package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchAttTest {
    @Test
    public void whenSearchByName() {
        Attachment one = new Attachment("one", 1);
        Attachment two = new Attachment("bugTwo", 2);
        Attachment three = new Attachment("three", 3);
        Attachment four = new Attachment("bugFour", 4);
        Attachment five = new Attachment("five", 5);
        List<Attachment> attachmentList = Arrays.asList(
                one, two, three, four, five
        );
        List<Attachment> result = SearchAtt.filter(attachmentList, attachment -> attachment.getName().contains("bug"));
        List<Attachment> expected = Arrays.asList(
                two, four
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenSearchBySize() {
        Attachment one = new Attachment("one", 1);
        Attachment two = new Attachment("bugTwo", 2);
        Attachment three = new Attachment("three", 3);
        Attachment four = new Attachment("bugFour", 4);
        Attachment five = new Attachment("five", 5);
        List<Attachment> attachmentList = Arrays.asList(
                one, two, three, four, five
        );
        List<Attachment> result = SearchAtt.filter(attachmentList, attachment -> attachment.getSize() > 2);
        List<Attachment> expected = Arrays.asList(
                three, four, five
        );
        assertThat(result, is(expected));
    }

}