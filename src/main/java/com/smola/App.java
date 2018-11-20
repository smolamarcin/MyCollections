package com.smola;

import com.smola.array.MarcinArrayListImpl;
import com.smola.model.Person;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        MarcinList<Person> people = new MarcinArrayListImpl<>();
        people.add(new Person("Marcin"));
        people.add(new Person("Artem"));
        people.add(new Person("Mateusz"));
        people.add(new Person("Asia"));
        printList(people);
        for (Person person : people) {
            if (person.getName().equals("Artem")){
                people.remove(person);
            }
        }
        printList(people);
    }

    private static void printList(MarcinList<Person> list) {
        list.forEach(System.out::println);
    }
}
