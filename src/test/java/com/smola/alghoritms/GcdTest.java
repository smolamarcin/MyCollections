package com.smola.alghoritms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GcdTest {
    Gcd gcd = new Gcd();
    @Test
    void shouldReturnGreatestDivisorForTwoNumbers() {
        long first = 90;
        long second = 60;
        long expected = 30;
        long actual = gcd.calculateGreatestDivisor(first, second);
        assertEquals(expected,actual);
    }
}