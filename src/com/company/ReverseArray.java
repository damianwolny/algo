package com.company;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {

		char[] string = new char[] {'1', '2', '3', '4'};

		reverse(string);

		System.out.println(Arrays.toString(string));

	}


	public static void reverse(char[] string) {

		int slow = 0;
		int fast = string.length-1;

			while(slow <fast) {
				char temp = string[slow];
				string[slow] = string[fast];
				string[fast] = temp;
				slow++;
				fast--;
			}
	}
}
