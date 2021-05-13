package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class HighestAverageScore {

	public static String getHighestAvgScore(String [][] arr) {

		return  Arrays.stream(arr)
				.collect(Collectors.groupingBy(a -> a[0], Collectors.averagingInt(a -> Integer.parseInt(a[1]))))
				.entrySet()
				.stream()
				.max(Comparator.comparingDouble(Map.Entry::getValue))
				.get()
				.getKey();
	}

	public static void main(String[] args) {

		String [][] scores = {{"jerry","65"},{"bob","91"}, {"jerry","23"}, {"Eric","83"}} ;

		System.out.println(getHighestAvgScore(scores));

	}
}
