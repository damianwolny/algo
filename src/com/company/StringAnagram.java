package com.company;

import java.util.Arrays;

public class StringAnagram {

	public static void main(String[] args) {
		String s = "anagram";
		String s2 = "nagaramx";

		isAnagram2(s,s2);
	}


	public static boolean isAnagram(String s, String t) {


		if (s.length() != t.length()) {
			return false;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		return Arrays.equals(str1, str2);
	}

	public static boolean isAnagram2(String s, String t) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
		for (int i : alphabet) if (i != 0) return false;
		return true;
	}
}
