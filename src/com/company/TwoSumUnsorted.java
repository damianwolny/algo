package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
// TODO https://www.callicoder.com/two-sum-problem/
public class TwoSumUnsorted {



		// Time complexity: O(n)
		private static int[] findTwoSum(int[] nums, int target) {
			Map<Integer, Integer> numMap = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				if (numMap.containsKey(complement)) {
					return new int[] { numMap.get(complement), i };
				} else {
					numMap.put(nums[i], i);
				}
			}
			return new int[] {};
		}


	// Time complexity: O(n*log(n))
	private static int[] findTwoSum_Sorting(int[] nums, int target) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			if(nums[left] + nums[right] == target) {
				return new int[] {nums[left], nums[right]};
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return new int[] {};
	}

	public static int[] twoSum3(int[] numbers, int target) {

		int left = 0;
		int right = numbers.length-1;
		int[] result = new int[2];

		if(numbers == null || numbers.length < 2) {
			return result;
		}

		while(left<right) {

			if (numbers[left] + numbers[right] == target) {
				result[0] = left;
				result[1] = right;
			} else if(numbers[left] + numbers[right] < target){
				left++;
			} else {
				right--;
			}

		}
		return result;

	}

	public static void main(String[] args) {

			int[] t = new int[] {2,7,11,15};

		System.out.println(Arrays.toString(twoSum3(t, 9)));
	}
}
