import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class SorterTest {

    @ParameterizedTest
    @MethodSource("input")
    void booleanToIntSort(int a, int b, int c, int d, int e) {
        List<Integer> list = new ArrayList<>(List.of(a, b, c, d, e));
        Collections.sort(list);
        Assertions.assertEquals(list.toString(), new BooleanToIntSort().sort(a, b, c, d, e));
    }

    @ParameterizedTest
    @MethodSource("input")
    void diferenceOfAbsolutSort(int a, int b, int c, int d, int e) {
        List<Integer> list = new ArrayList<>(List.of(a, b, c, d, e));
        Collections.sort(list);
        Assertions.assertEquals(list.toString(), new DiferenceOfAbsolutSort().sort(a, b, c, d, e));
    }

    public static Stream<Arguments> input() {

        return inputStream()
                .flatMap(a -> inputStream()
                        .flatMap(b -> inputStream()
                                .flatMap(c -> inputStream()
                                        .flatMap(d -> inputStream()
                                                .map(e -> Arguments.of(a, b, c, d, e))
                                        )
                                )
                        )
                );
    }

    private static Stream<Integer> inputStream() {
        int start = -2;
        int end = 3;
        Stream<Integer> minMaxStream = Stream.of(Integer.MAX_VALUE, Integer.MIN_VALUE);
        return Stream.concat(minMaxStream,
                IntStream.rangeClosed(start, end).boxed());
    }
}