package com.company;

public class TrappingRainWater {

	public static int trap(int[] height) {

		int totalAmount = 0;
		if (height == null || height.length == 0) {
			return totalAmount;
		}

		//TODO przygotuj tablice najwiekszych wartosci od lewej
		int[] leftHighest = new int[height.length + 1];
		leftHighest[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			leftHighest[i] = Math.max(leftHighest[i-1], height[i]);
		}

		// TODO przygotuj tablice największych wartości od prawej
		int[] rightHighest = new int[height.length + 1];
		rightHighest[height.length - 1] = height[height.length - 1];

		for (int i = height.length - 2; i >= 0; i--) {
			rightHighest[i] = Math.max(rightHighest[i + 1], height[i]);
		}

		// TODO obliczenia czyli odejmij jedno od drugiego i jeszcze minus wysokosc slupka
		for (int i = 0; i < height.length; i++) {
			totalAmount += Math.min(rightHighest[i], leftHighest[i]) - height[i];
		}

		return totalAmount;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {

		int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

		System.out.println("Maximum water that "
				+ "can be accumulated is "
				+ trap(arr));
	}
}
