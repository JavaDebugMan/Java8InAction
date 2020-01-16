package lambdasinaction.chap5;

import lambdasinaction.chap4.*;

import java.util.stream.*;
import java.util.*;

import static java.util.stream.Collectors.summingInt;
import static lambdasinaction.chap4.Dish.menu;

public class Reducing {

    public static void main(String... args) {

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

        Integer integer = menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum).orElse(0);
        System.out.println(integer);
        System.out.println("Number of calories:" + calories);

        int i = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("iiii->" + i);

        int sum1 = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("sum1--------->" + sum1);
    }
}
