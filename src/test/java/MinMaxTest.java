import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class MinMaxTest {

    @ParameterizedTest
    @MethodSource("input")
    void min(int a, int b) {
        Assertions.assertEquals(Math.min(a, b), new DiferenceOfAbsolutSort().min(a, b));
    }

    @ParameterizedTest
    @MethodSource("input")
    void max(int a, int b) {
        Assertions.assertEquals(Math.max(a, b), new DiferenceOfAbsolutSort().max(a, b));
    }

    public static Stream<Arguments> input() {
        return  inputStream().flatMap(a -> inputStream().map(b -> Arguments.of(a, b)));
    }

    private static Stream<Integer> inputStream() {
        int start = -10;
        int end = 10;
        return Stream.concat(Stream.of(Integer.MAX_VALUE, Integer.MIN_VALUE + 1), IntStream.rangeClosed(start, end)
                .boxed());
    }
}