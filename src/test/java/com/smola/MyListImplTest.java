package com.smola;

import com.smola.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyListImplTest {
    private MyListImpl<Person> myList = new MyListImpl<>();

    @Test
    void shouldReturnTrue_whenAddedElementToList() {
        Person person = new Person("Marcin");
        boolean added = myList.add(person);
        assertTrue(added);
        assertEquals(1, myList.size());
    }

    @Test
    void sizeShouldEqualToZero_whenListWasCleaned() {
        Person person = new Person("Marcin");
        myList.add(person);
        myList.clear();
        assertEquals(0, myList.size());
    }

//    @Test
//    void referencesShouldBeNulled_whenListWasCleaned() {
//        Person person = new Person("Marcin");
//        myList.add(person);
//        myList.clear();
//        myList.forEach(Assertions::assertNull);
//    }


    @Test
    void shouldIncreaseArraySize_whenAddedMultipleElements() {
        for (int i = 0; i < 32; i++) {
            myList.add(new Person(String.valueOf(i)));
        }
        assertEquals(32,myList.size());
    }
}