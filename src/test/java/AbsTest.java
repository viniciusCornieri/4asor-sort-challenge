import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class AbsTest {

    @ParameterizedTest
    @MethodSource("input")
    void abs(long a) {
        Assertions.assertEquals(Math.abs(a), new DiferenceOfAbsolutSort().abs(a));
    }

    public static Stream<Arguments> input() {
        return  Stream.concat(inputStream(), Stream.of(Integer.MAX_VALUE, Integer.MIN_VALUE)).map(a -> Arguments.of(a));
    }

    private static Stream<Long> inputStream() {
        int start = -10;
        int end = 10;
        return LongStream.rangeClosed(start, end)
                .boxed();
    }
}