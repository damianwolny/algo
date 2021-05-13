package com.company;

public class SmallestSubarrayGivenSum {

	public static void main(String[] args) {

		int[] input  = new int[] {4,2,2,7,8,1,2,8,10};
		int targetSum = 8;

		System.out.println(smallestSubarray(8, input));

	}

	public static int smallestSubarray(int targetSum, int[] arr) {

		int minWindowSize = Integer.MAX_VALUE; // TODO Minimalna wielkość okienka, zainicjalizowana MAX, bo będziemy ją zmniejszać
		int currentWindowSum = 0; // TODO suma z okienka w którym obecnie jesteśmy
		int windowStart = 0; // TODO indeks od którego przesuwamy okno

		for (int i = 0; i < arr.length; i++) {

			currentWindowSum += arr[i]; // TODO dodaj do zmiennej currentWindowSum wartość z tabeli pod indeksem i

			while (currentWindowSum >= targetSum) { // TODO jeśli wartość z okienka jest większa lub taka jak szukana
				minWindowSize = Math.min(minWindowSize, i - windowStart + 1); // TODO wybierz najmniejszą wartość
				currentWindowSum -= arr[windowStart]; // TODO odejmij pierwszą wartość od obecnej wartosći okienka
				windowStart++; // TODO przesuń okienko
			}
		}
		return minWindowSize;
	}

}
