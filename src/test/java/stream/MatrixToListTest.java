package stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void whenSquareMatrix() {
        Integer[][] matrix = new Integer[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = MatrixToList.matrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4 , 5, 6, 7, 8, 9);
        assertThat(result, is(expected));

    }

    @Test
    public void whenNoSquareMatrix() {
        Integer[][] matrix = new Integer[][]{
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };
        List<Integer> result = MatrixToList.matrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4 , 5, 6, 7, 8, 9);
        assertThat(result, is(expected));

    }

}