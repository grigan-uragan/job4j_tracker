package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("Image1", 100),
                new Attachment("Image2", 34),
                new Attachment("Image3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment at1, Attachment at2) {
                return at1.getSize() - at2.getSize();
            }
        };

        attachments.sort(comparator);
        System.out.println(attachments);

        Comparator<Attachment> nameComp = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        attachments.sort(nameComp);
        System.out.println(attachments);

    }
}
