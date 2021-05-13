package com.company;

public class SecondSmallest {

	public static void main(String[] args) {

		System.out.println(secondSmallest2n(new int[]{-17,4,2,7,1,9,8,4,3,0,-1}));

	}


	public static int secondSmallest2n(int[] arr) {

		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;

		for (int value : arr) {

			if (value < smallest) {
				smallest = value;
			}
		}
		for (int value : arr) {

			if(value < secondSmallest && value != smallest) {
				secondSmallest = value;
			}
		}
		return secondSmallest;
	}

	public static int findSecondSmallestElement(int[] arr) {

		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;

		for (int element : arr) {
			if (element < smallest) { // TODO Jeśli element tablicy jest mniejszy od najmniejszego
				secondSmallest = smallest; // TODO Przypisz najmniejszy do drugiego najmniejszego
				smallest = element; // TODO Przypisz obecny element tablicy do najmniejszego
			} else if (element < secondSmallest) { // TODO Jeśli natomiast element tablicy jest mniejszy od drugiego najmniejszego
				secondSmallest = element; // TODO To przypisz wartość elementu tablicy do drugiego najmniejszego
			}
		}
		return secondSmallest;
	}

}
