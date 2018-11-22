package com.smola;

import com.smola.model.Employee;
import com.smola.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Marcin"));
        people.add(new Person("Artem"));
        people.add(new Person("Mateusz"));
        people.add(new Person("Asia"));
//        printList(people);
//        System.out.println(people.get(2));
//        printList(people);
//        System.out.println(people.get(2));
        List<Integer> itns = new ArrayList<>();
        itns.add(1);
        itns.add(2);
        itns.add(3);
        itns.add(4);
        itns.add(5);
        itns.add(6);
        printList(itns);
        for (Integer itn : itns) {
            if(itn % 2 == 0){
                itns.removeIf(e->e == 2);
            }
        }
        printList(itns);
        Map<Double, List<Person>> collect = people.stream().collect(Collectors.groupingBy(e -> e.getAge()));

    }

    private static void printList(List<?> list) {
        System.out.println(list);
    }
}
