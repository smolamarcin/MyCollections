package com.smola.alghoritms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    BinarySearch binarySearch = new BinarySearch();

    @Test
    void shouldReturnIndexOfElementToFind() {
        int[] array = {10,11,20,33,40,55,65,76,87};
        int toFind = 87;
        int foundIndex = binarySearch.binarySearch(array, toFind);
        assertEquals(8,foundIndex);
    }

    @Test
    void shouldReturnNegativeValue_whenElementDoesNotExistInStructure() {
        int[] array = {1,2,3,4,5,6,7,8};
        int toFind = 33;
        int foundIndex = binarySearch.binarySearch(array, toFind);
        assertEquals(-1,foundIndex);
    }
}