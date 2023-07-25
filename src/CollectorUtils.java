import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorUtils {
    private static final long A = 25214903917L;
    private static final int C = 11;
    private static final long M = (long) Math.pow(2, 48);

    public static long next(long seed) {
        return (A * seed + C) % M;
    }
    public static String evenOrderString(List<String> str) {
        AtomicInteger order = new AtomicInteger(0);

        String result = str.stream()
                .map(s -> order.addAndGet(1) + ". " + s)
                .filter(s -> order.get() % 2 != 0)
                .collect(Collectors.joining(", "));

        return result;

    }

    public static List<String> reverseList(List<String> str) {
        List<String> result = str.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return result;
    }

    public static List<Integer> getNumbersFromStrings(String[] stringNumbers) {
        List<Integer> result = Arrays.stream(stringNumbers)
                .flatMap(s -> Stream.of(s.split(",\\s*")))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        return result;
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Stream.Builder<T> builder = Stream.builder();

        Iterator<T> firstIter = first.iterator();
        Iterator<T> secondIter = second.iterator();

        while (firstIter.hasNext() && secondIter.hasNext()) {
            builder.add(firstIter.next());
            builder.add(secondIter.next());
        }

        return builder.build();
    }
}
