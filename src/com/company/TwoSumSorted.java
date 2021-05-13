package com.company;

import java.util.Arrays;

public class TwoSumSorted {

	static int[] twoSum(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;
		int result[] = new int[2];

		while (start < end) {

			int sum = nums[start] + nums[end];
			if (sum == target) {
				result[0] = start;
				result[1] = end;
				break;
			} else if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		int nums[] = new int[]{-3, 2, 3, 3, 6, 8, 15};

		System.out.println(Arrays.toString(twoSum(nums, 6)));
	}
}
