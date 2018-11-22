package com.smola.alghoritms;

public class BinarySearch {
    int binarySearch(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int medium = (left + right) / 2;
            if (arr[medium] == toFind) {
                return medium;
            } else if (arr[left] <= toFind) {
                left = medium + 1;
            } else {
                right = medium - 1;
            }
        }
        return -1;
    }
}
