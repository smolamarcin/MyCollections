package com.smola.model;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String name;
    private double age;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, double age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        return this.name.compareTo(p.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return this.age;
    }
}
