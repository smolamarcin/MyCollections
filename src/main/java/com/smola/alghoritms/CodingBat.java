package com.smola.alghoritms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CodingBat {
    int[] reverse(int[] nums){
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums,i,nums.length -1 -i);
        }
        Arrays.stream(nums).limit(2).reduce(0,(a,b)->a+b);
        return Arrays.stream(nums).map(e->2).toArray();
    }

    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
        for (int num : nums) {
            
        }

    }
}
