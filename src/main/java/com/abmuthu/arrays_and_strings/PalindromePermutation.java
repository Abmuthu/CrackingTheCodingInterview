package com.abmuthu.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;
/*
	Core Concept: Predict if the string can become a palindrome by
				  checking the count of the characters
*/
public class PalindromePermutation {

	// version 1: using hashmap. time: O(n) space: O(n)
	public boolean canStringBecomePalindromeV1(String input) {
		if (input.length() == 1) {
			return true;
		}
		Map<Character, Integer> myMap = new HashMap<>();
		// populating map with characters and their count
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (myMap.containsKey(ch)) {
				myMap.put(ch, (myMap.get(ch) + 1));
			} else {
				myMap.put(ch, 1);
			}
		}

		// if even count of every character must be even
		int oddCount = 0;
		for (Character ch : myMap.keySet()) {
			if ((myMap.get(ch) % 2) != 0) {
				oddCount++;
			}
		} 

		if ((input.length() % 2 == 0) && (oddCount == 0)) {
			return true;
		} else if ((input.length() % 2 != 0) && (oddCount == 1)) {
			return true;
		} else {
			return false;
		}
	} 

	public static void main (String[] args) {
		String input = null;
		if (args.length == 1 && args[0] != null) {
			input = args[0];
		} else {
			throw new IllegalArgumentException();
		}
		System.out.println(new PalindromePermutation().canStringBecomePalindromeV1(input));
	}
}