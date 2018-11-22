package com.smola.jav8inaction;

import com.smola.model.Person;
import javafx.print.Collation;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class JavaEight {
    @Test
    void sorting() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Marcin",18));
        people.add(new Person("Marcin",19));
        people.add(new Person("Marcin",20));
        people.add(new Person("Asia",20.5));
        people.add(new Person("Basia",20.3));
        people.add(new Person("asdad",20));

        List<Person> collect = people.stream().sorted((o1, o2) -> {
            if (o1.getAge() > o2.getAge()){
                return 1;
            }
            if (o1.getAge() < o2.getAge()){
                return -1;
            }
            return 0;
        }).collect(toList());
        System.out.println(collect);
        List<String> collect1 = people.stream()
                .map(Person::getName)
                .map(e -> e.split(""))
                .flatMap(e->Arrays.stream(e))
                .distinct()
                .collect(toList());
        System.out.println(collect1);
    }

    @Test
    void shouldReturnAllPairsOfNumbers() {

        List<Integer> firstList = Arrays.asList(1,2,3);
        List<Integer> secondList = Arrays.asList(3,4);


        List<int[]> list = firstList.stream().
                flatMap(i -> secondList.stream()
                        .filter(j->(i+j)%3 ==0)
                        .map(j -> new int[]{i, j}))
                .collect(toList());
        System.out.println(list);

        List<String> empty = new ArrayList<>();
        List<String> blabla = Arrays.asList("Marcin","Ala","asdasd");
        System.out.println(empty);
        blabla.stream().filter(e->e.contains("a")).map(e->e +empty.size()).map(e->empty.add(e)).forEach(System.out::println);
        System.out.println(empty);
        blabla.stream().anyMatch(e->e.contains("A"));
        String s = blabla.stream().filter(e -> e.contains("a")).findAny().orElse("Nie znaleziono");
        System.out.println(s);

        List<Integer> integers = Arrays.asList(23,23,55,1,99,101,2);
        Optional<Integer> reduce = integers.stream().reduce((a, b) -> Integer.max(a, b));


        System.out.println(reduce.orElse(-1));
        System.out.println(integers.stream().max(Integer::compareTo).orElse(-1));
    }
}
