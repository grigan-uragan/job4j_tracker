package ru.job4j.lambda;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchAtt {
    public static List<Attachment> filter(List<Attachment> attachments, Predicate<Attachment> predicate) {
        return attachments.stream().filter(predicate).collect(Collectors.toList());
    }
}
