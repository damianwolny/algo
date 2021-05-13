package com.company;

/**
 * Find the max sum subarray of fixed size L
 * <p>
 * Example input :
 * [4,2,1,7,8,1,2,8,1,0]
 */
public class MaxSubarraySum {

	public static void main(String[] args) {

		System.out.println(findMaxSumSubarray2(new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0}, 3));
	}

	public static int findMaxSumSubarray(int[] arr, int k) {

		int maxValue = Integer.MIN_VALUE;
		int currentWindowSum = 0; // TODO suma z okienka w którym obecnie jesteśmy

		for (int i = 0; i < arr.length; i++) {
			currentWindowSum += arr[i]; // TODO dodaj do zmiennej currentWindowSum wartość z tabeli pod indeksem i
			if (i >= k - 1) { // TODO sprawdz czy okienko jest juz zadeklarowanej wielkosci
				maxValue = Math.max(maxValue, currentWindowSum); // TODO wybierz najwiekszą wartość
				currentWindowSum -= arr[i - (k - 1)]; // TODO przesuń okienko o 1 w prawo
			}
		}

		return maxValue;
	}

	public static int findMaxSumSubarray2(int[] arr, int k) {

		int windowSum = 0;
		int maxSum = 0;
		int start = 0;
		int end = 0;

		while (end < k) {
			windowSum += arr[end++];
		}

		while (end < arr.length) {
			windowSum += arr[end++] - arr[start++];
			maxSum = Math.max(maxSum, windowSum);
		}

		return maxSum;
	}
}
