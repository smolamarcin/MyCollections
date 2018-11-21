package com.smola.stack;

import com.smola.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarcinStackImplTest {
    MarcinStackImpl<String> stack = new MarcinStackImpl();
    @Test
    void addingElementsShouldIncreaseSIze() {
        stack.push("Marcin");

        assertEquals(1,stack.size());
    }

    @Test
    void lastAddedElementShouldBeFirst() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        String poll = stack.poll();
        assertEquals("C", poll);
        assertEquals(2,stack.size());
    }
}