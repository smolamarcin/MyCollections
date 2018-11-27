package com.smola;

import com.smola.model.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsExercises {
    @Test
    void treeMap() {
        Map<String,String> tree_map1=new TreeMap<String,String>();

        // Put elements to the map
        tree_map1.put("C1", "Red");
        tree_map1.put("C2", "Green");
        tree_map1.put("C3", "Black");
        tree_map1.put("C4", "White");
        tree_map1.put("C5", "Blue");
        System.out.println(tree_map1);
        Map<String,String> newTreeMap = new TreeMap<>(tree_map1);
    }

    @Test
    void mutableObjectTreeMap() {
        Map<Person,String> map = new TreeMap<>();
        Person marcin = new Person("Marcin");
        map.put(marcin,"Marcin");
        map.put(new Person("Artem"),"Artem");
        map.put(new Person("A"),"A");
        map.put(new Person("B"),"B");
        map.put(new Person("C"),"C");
        map.put(new Person("Asia"),"Asia");
        map.put(new Person("Marysia"),"Marysia");
        System.out.println(map);
        String a = map.remove(new Person("A"));
        System.out.println(map);
        System.out.println(map.get(new Person("Marcin")));
        System.out.println(map);
    }

    @Test
    void removingFromLinkedList() {
        List<String> names = new LinkedList<>();
        names.add("A");
        names.add("A");
        names.add("A");
        names.add("A");
        names.add("B");
        names.removeIf(e->e.equals("A"));
    }

    @Test
    void arrayList() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(1,"D");
        list.add(2,"E");
        list.add(2,"F");
        list.add(2,"G");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }

    @Test
    void hashSet() {
        NavigableSet<String> set = new TreeSet<>();
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("Aaa");
        set.add("Abb");
        set.add("Acc");
        set.add("Accd");
        set.add("E");
        set.add("F");
        set.add("FF");
        set.add("G");
        set.remove("B");
        set.removeIf(e->e.length() == 2);
        set.add("G");
        SortedSet<String> strings = set.subSet("B",true, "G",true);
        set.add("G");

        // greatest elements on string longer than 2
        List<Integer> siema = new ArrayList<>();
        List<String> S = new ArrayList<>();
        S.stream().filter(e->
            e.charAt(0) == 'a').filter(e->e.length() == 3).collect(Collectors.toList());
        double v = siema.stream().mapToInt(e -> e.intValue()).average().orElse(-1);
        String s = set.stream().filter(e -> e.length() > 2).max(String::compareTo).get();

    }

    @Test
    void breakingHashCOdeCOntract() {
        Person personWoHashcode = new Person("Marcin");
        Map<Person, String> myMap= new HashMap<>();
        myMap.put(personWoHashcode,"Siemanko");
        System.out.println(myMap.get(new Person("Marcin")));

    }


}

