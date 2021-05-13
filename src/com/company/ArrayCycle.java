package com.company;

import java.util.Arrays;

public class ArrayCycle {

	public static void main(String[] args) {

		int[] arr = {1, 3, 0, 4, 1};
		System.out.println(findCircle(arr, 0));

	}

	public static int countCycles(int[] data) {

		int[] counters = new int[data.length]; // TODO nowa tabela o wielkości bazowej
		int index = 0;
		int count = 0;
		while (counters[index] == 0) { // TODO dopóki
			counters[index] = count++;
			index = data[index];
		}
		return count - counters[index];
	}

	public static int countCyclesBurn(int[] data) {

		int index = 0;
		int count = 0;
		while (data[index] >= 0) {
			int tmp = data[index];
			data[index] = -(++count);
			index = tmp;
			System.out.println(Arrays.toString(data));
		}
		return count + data[index] + 1;
	}

	private static int findCircle(int[] nums, int start) {
		int slow = nums[start];
		int fast = nums[nums[start]];
		int sSoFar = 1;
		if(slow == fast)
			return -1;
		while(slow!=fast) {
			slow = nums[slow];
			sSoFar++;
			fast = nums[nums[fast]];
			System.out.println("SLOW: " + slow);
			System.out.println("FAST: " + fast);
		}
		return sSoFar;
	}
}
