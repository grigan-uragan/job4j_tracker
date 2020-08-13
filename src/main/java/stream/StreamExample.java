package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, -2, 10, -4, 5));
        List<Integer> result = list.stream()
                .filter(val -> val > 0)
                .collect(Collectors.toList());
    }
}
