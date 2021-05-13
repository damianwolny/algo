package com.company;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        int[] arr = {2,3,1,2,4,3};

        System.out.println(minSubArrayLen(7, arr));

    }

    public static int minSubArrayLen(int targetSum, int[] nums) {


        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowValue = 0;
        int windowStart = 0;

        for (int i = 0; i < nums.length; i++) {

            currentWindowValue+=nums[i];

            while (currentWindowValue>=targetSum) {
                minWindowSize = Math.min(minWindowSize, i - windowStart + 1);
                currentWindowValue -= nums[windowStart];
                windowStart++;
            }

        }
        return minWindowSize;
    }
}
