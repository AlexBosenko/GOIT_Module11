import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorTest {
    public static void main(String[] args) {
        List<String> names = List.of("John", "Igor", "Pete", "Alex", "Andrew", "Peter", "Harry", "Gregor", "Zack", "William", "Bonny");

        //Task 1
        String orderedNames = CollectorUtils.evenOrderString(names);
        System.out.println("Task 1 result : " + orderedNames);

        //Task 2
        List<String> reverseOrderedNames = CollectorUtils.reverseList(names);
        System.out.println("Task 2 result : " + reverseOrderedNames);

        //Task 3
        String[] stringNumbers = new String[]{"200, 155", "1, 2, 0, 7, -1", "4, 5", "45, 10, 54", "100"};
        List<Integer> numbers = CollectorUtils.getNumbersFromStrings(stringNumbers);

        StringJoiner numberString = new StringJoiner(", ");
        for (Integer number : numbers) {
            numberString.add(number.toString());
        }
        System.out.println("Task 3 result : " + numberString);

        //Task 4
        Stream<Long> streamRandom = Stream.iterate(0L, CollectorUtils::randomNext);
        System.out.println("Task 4 result : ");
        streamRandom.limit(20)
                .peek(System.out::println)
                .collect(Collectors.toList());

        //Task 5
        List<String> namesFirst = List.of("John", "Igor", "Pete", "Alex", "Andrew");
        List<String> namesSecond = List.of("Peter", "Harry", "Gregor", "Zack");

        Stream<String> zipped = CollectorUtils.zip(namesFirst.stream(), namesSecond.stream());
        System.out.println("Task 5 result : " + zipped.collect(Collectors.toList()));
    }
}
