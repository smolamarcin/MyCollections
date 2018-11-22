package com.smola.alghoritms;

public class Gcd {
    long calculateGreatestDivisor(long first, long second){
        while (second != 0){
            long rem = first % second;
            first = second;
            second = rem;
        }
        return first;
    }
}
