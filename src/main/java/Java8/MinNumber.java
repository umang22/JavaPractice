package Java8;

import java.util.stream.IntStream;

public class MinNumber {
    public static void main(String[] args) {
        int[] numbers = {4, 5, 13, 3, 10};
        IntStream.of(numbers).min().ifPresent(System.out::println);
        IntStream.of(numbers).max().ifPresent(System.out::println);
        IntStream.of(numbers).average().ifPresent(System.out::println);
        IntStream.of(numbers).average().ifPresent(System.out::println);
        IntStream.of(numbers).average().ifPresent(System.out::println);
        IntStream.of(numbers).average().ifPresent(System.out::println);
        IntStream.of(numbers).average().ifPresent(System.out::println);
        IntStream.of(numbers).average().ifPresent(System.out::println);
           // comment added in submodule main branch
    }

}
