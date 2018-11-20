package com.smola.linked;

import com.smola.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarcinLinkedListImplTest {
    private MarcinLinkedListImpl<Person> marcinLinkedList;
    @BeforeEach
    void setUp() {
        marcinLinkedList = new MarcinLinkedListImpl();
    }

    @Test
    void shouldIncreaseSizeWhenAddedNewElement() {
        marcinLinkedList.add(new Person("A"));
        assertEquals(1,marcinLinkedList.size());
    }

    @Test
    void firstAddedElement_shouldBeHead() {
        marcinLinkedList.add(new Person("A"));
        Person head = marcinLinkedList.getHead();
        assertEquals("A",head.getName());
    }

    @Test
    void shouldLinkAddedElements() {
        Person firstPerson = new Person("A");
        marcinLinkedList.add(firstPerson);
        Person secondPerson = new Person("B");
        marcinLinkedList.add(secondPerson);

        Person head = marcinLinkedList.getHead();
        assertEquals(firstPerson,head);
        assertTrue(marcinLinkedList.contains(secondPerson));
        assertEquals(2,marcinLinkedList.size());
    }

    @Test
    void shouldReturnIndexOfElement() {
        Person firstPerson = new Person("A");
        marcinLinkedList.add(firstPerson);
        Person secondPerson = new Person("B");
        marcinLinkedList.add(secondPerson);

        int index = marcinLinkedList.indexOf(secondPerson);
        assertEquals(1,index);
    }

    @Test
    void shouldThrowException_whenNoDemanIndex() {
        Person firstPerson = new Person("A");
        marcinLinkedList.add(firstPerson);

        RuntimeException expectedException = assertThrows(RuntimeException.class, () -> {
            marcinLinkedList.indexOf(new Person("Xasdasdsd"));
        });

        assertEquals("Index does not exist.",expectedException.getMessage());
    }

    @Test
    void shouldRemoveHead_whenOneElementInList() {
        Person firstPerson = new Person("A");
        marcinLinkedList.add(firstPerson);

        marcinLinkedList.remove(firstPerson);

        assertEquals(0,marcinLinkedList.size());
        assertNull(marcinLinkedList.getHead());
    }

    @Test
    void shouldRemoveNode_inTheMiddleOfList() {
        Person firstPerson = new Person("A");
        Person secondPerson = new Person("B");
        Person thirdPerson = new Person("C");
        marcinLinkedList.add(firstPerson);
        marcinLinkedList.add(secondPerson);
        marcinLinkedList.add(thirdPerson);

        assertTrue(marcinLinkedList.remove(secondPerson));

        assertEquals(2,marcinLinkedList.size());
        assertEquals(0,marcinLinkedList.indexOf(firstPerson));
        assertEquals(1,marcinLinkedList.indexOf(thirdPerson));
    }

    @Test
    void shouldChangeHead_whenDeleteFirstElement() {
        Person firstPerson = new Person("A");
        Person secondPerson = new Person("B");
        Person thirdPerson = new Person("C");
        marcinLinkedList.add(firstPerson);
        marcinLinkedList.add(secondPerson);
        marcinLinkedList.add(thirdPerson);

        assertTrue(marcinLinkedList.remove(firstPerson));
        assertEquals(secondPerson,marcinLinkedList.getHead());
        assertEquals(2,marcinLinkedList.size());
        assertEquals(0,marcinLinkedList.indexOf(secondPerson));
        assertEquals(1,marcinLinkedList.indexOf(thirdPerson));
    }

    @Test
    void shouldCleanList() {
        Person firstPerson = new Person("A");
        Person secondPerson = new Person("B");
        Person thirdPerson = new Person("C");
        marcinLinkedList.add(firstPerson);
        marcinLinkedList.add(secondPerson);
        marcinLinkedList.add(thirdPerson);

        marcinLinkedList.clear();

        assertEquals(0,marcinLinkedList.size());
        assertNull(marcinLinkedList.getHead());
        assertNull(marcinLinkedList.getTail());

        marcinLinkedList.forEach(Assertions::assertNull);
    }

    @Test
    void shouldReturnObjectOnSpecificIndex() {
        Person firstPerson = new Person("A");
        Person secondPerson = new Person("B");
        Person thirdPerson = new Person("C");
        marcinLinkedList.add(firstPerson);
        marcinLinkedList.add(secondPerson);
        marcinLinkedList.add(thirdPerson);


        Person found = marcinLinkedList.get(1);
        assertEquals(secondPerson,found);
    }

    @Test
    void shouldRemoveObjectOnSPecificIndex() {
        Person firstPerson = new Person("A");
        Person secondPerson = new Person("B");
        Person thirdPerson = new Person("C");
        marcinLinkedList.add(firstPerson);
        marcinLinkedList.add(secondPerson);
        marcinLinkedList.add(thirdPerson);

        marcinLinkedList.remove(1);

        assertEquals(2,marcinLinkedList.size());
        assertEquals(firstPerson,marcinLinkedList.get(0));
        assertEquals(thirdPerson,marcinLinkedList.get(1));
    }
}