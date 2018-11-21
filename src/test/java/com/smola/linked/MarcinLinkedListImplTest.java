package com.smola.linked;

import com.smola.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarcinLinkedListImplTest {
    private MarcinLinkedListImpl<String> marcinLinkedList;
    @BeforeEach
    void setUp() {
        marcinLinkedList = new MarcinLinkedListImpl();
    }

    @Test
    void shouldIncreaseSizeWhenAddedNewElement() {
        marcinLinkedList.add("A");
        assertEquals(1,marcinLinkedList.size());
    }

    @Test
    void firstAddedElement_shouldBeHead() {
        marcinLinkedList.add("A");
        String head = marcinLinkedList.getHead();
        assertEquals("A",head);
    }

    @Test
    void shouldLinkAddedElements() {
        String first = "A";
        marcinLinkedList.add(first);
        String second = "B";
        marcinLinkedList.add(second);

        String head = marcinLinkedList.getHead();
        assertEquals(first,head);
        assertTrue(marcinLinkedList.contains(second));
        assertEquals(2,marcinLinkedList.size());
    }

    @Test
    void shouldReturnIndexOfElement() {
        String first = "A";
        marcinLinkedList.add(first);
        String second = "B";
        marcinLinkedList.add(second);

        int index = marcinLinkedList.indexOf(second);
        assertEquals(1,index);
    }

    @Test
    void shouldThrowException_whenNoDemanIndex() {
        String first = "A";
        marcinLinkedList.add(first);

        RuntimeException expectedException = assertThrows(RuntimeException.class, () -> {
            marcinLinkedList.indexOf("sadad");
        });

        assertEquals("Index does not exist.",expectedException.getMessage());
    }

    @Test
    void shouldRemoveHead_whenOneElementInList() {
        String first = "A";
        marcinLinkedList.add(first);
        marcinLinkedList.remove(first);

        assertEquals(0,marcinLinkedList.size());
        assertNull(marcinLinkedList.getHead());
    }

    @Test
    void shouldRemoveNode_inTheMiddleOfList() {
        String first = "A";
        marcinLinkedList.add(first);
        String second = "B";
        marcinLinkedList.add(second);
        String third = "B";
        marcinLinkedList.add(third);
        assertTrue(marcinLinkedList.remove(second));

        assertEquals(2,marcinLinkedList.size());
        assertEquals(0,marcinLinkedList.indexOf(first));
        assertEquals(1,marcinLinkedList.indexOf(third));
    }

    @Test
    void shouldChangeHead_whenDeleteFirstElement() {
        String first = "A";
        marcinLinkedList.add(first);
        String second = "B";
        marcinLinkedList.add(second);
        String third = "B";
        marcinLinkedList.add(third);

        assertTrue(marcinLinkedList.remove(first));
        assertEquals(second,marcinLinkedList.getHead());
        assertEquals(2,marcinLinkedList.size());
        assertEquals(0,marcinLinkedList.indexOf(second));
    }

    @Test
    void shouldCleanList() {
        String first = "A";
        marcinLinkedList.add(first);
        String second = "B";
        marcinLinkedList.add(second);
        String third = "B";
        marcinLinkedList.add(third);

        marcinLinkedList.clear();

        assertEquals(0,marcinLinkedList.size());
        assertNull(marcinLinkedList.getHead());
        assertNull(marcinLinkedList.getTail());

        marcinLinkedList.forEach(Assertions::assertNull);
    }

    @Test
    void shouldReturnObjectOnSpecificIndex() {
        String first = "A";
        marcinLinkedList.add(first);
        String second = "B";
        marcinLinkedList.add(second);
        String third = "B";
        marcinLinkedList.add(third);


        String found = marcinLinkedList.get(1);
        assertEquals(second,found);
    }

    @Test
    void shouldRemoveObjectOnSPecificIndex() {
        String first = "A";
        marcinLinkedList.add(first);
        String second = "B";
        marcinLinkedList.add(second);
        String third = "B";
        marcinLinkedList.add(third);

        marcinLinkedList.remove(1);

        assertEquals(2,marcinLinkedList.size());
        assertEquals(first,marcinLinkedList.get(0));
        assertEquals(third,marcinLinkedList.get(1));
    }
}