package com.smola;

import com.smola.model.Person;
import javafx.print.Collation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    }
}
