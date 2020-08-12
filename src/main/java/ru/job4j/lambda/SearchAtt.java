package ru.job4j.lambda;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchAtt {
    public static List<Attachment> filter(List<Attachment> attachments, String field) {
        Predicate<Attachment> predicate;
        if ("name".equals(field)) {
            predicate = attachment -> attachment.getName().contains("bug");
        } else {
            predicate = attachment -> attachment.getSize() > 2;
        }
        return attachments.stream().filter(predicate).collect(Collectors.toList());
    }

}
