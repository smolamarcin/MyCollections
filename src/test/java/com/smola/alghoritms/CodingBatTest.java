package com.smola.alghoritms;

import com.sun.deploy.util.ArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CodingBatTest {
    CodingBat codingBat = new CodingBat();

    @Test
    void shouldRotateArrayToLeft() {
        int[] nums = {3, 2, 1, 3};
        int max = Arrays.stream(nums).max().getAsInt();
        Arrays.stream(nums).boxed().collect(Collectors.groupingBy(e->e));
        Arrays.stream(nums).filter(e->e == Arrays.stream(nums).max().getAsInt()).count();
        int length = Arrays.stream(nums).filter(e -> e == max).toArray().length;
        IntStream sorted = Arrays.stream(nums).sorted();
        long maxSum = Arrays.stream(nums).mapToLong(i -> i).sorted().skip(Math.max(0, nums.length - 4)).sum();
        long minSum = Arrays.stream(nums).mapToLong(i -> i).sorted().limit(4).sum();
        System.out.println(minSum + " " + maxSum);
        int[] actual = codingBat.reverse(nums);
        IntStream.of(nums[0], nums[1]).max();
        Arrays.stream(nums).max();
        Stream.of(1, 2, 3).max(Integer::compare);
        staircase(6);
    }

    static void staircase(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int countOfSpaces = i;
            for (int j = 0; j < countOfSpaces; j++) {
                stringBuilder.append(" ");
            }
            int hashCount = n - i;
            for (int j = 0; j < hashCount; j++) {
                stringBuilder.append("#");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }
}