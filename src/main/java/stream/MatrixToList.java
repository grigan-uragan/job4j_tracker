package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> list = Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
