package com.abmuthu.arrays_and_strings;

/*
	Core concept: Compare each character of two strings using two
				  seperate pointers.
*/

public class OneAway {

	// assumption: str2 is the transformation of str1. time: O(n) space: O(1)
	public boolean isOneEditAwayV1(String str1, String str2) {
		if ((str1.length() - str2.length()) > 1) {
			return false;
		}
		if (str1.length() == str2.length()) {
			int replaceCount = 0;
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i)) {
					replaceCount++;
				}
			}
			return replaceCount == 1;
		} else if (str1.length() > str2.length()) {
			int largeStringPointer = 0;
			int smallStringPointer = 0;
			int removeCount = 0;
			while (smallStringPointer < str2.length()) {
				if (str1.charAt(largeStringPointer) == str2.charAt(smallStringPointer)) {
					smallStringPointer++;
				} else {
					removeCount++;
				}
				largeStringPointer++;
			}
			return removeCount + (str1.length() - largeStringPointer) == 1;
		} else {
			return isOneEditAwayV1(str2, str1);
		}
	}

	public static void main(String[] args) {
		String str1 = null;
		String str2 = null;
		if (args.length == 2 && args[0] != null && args[1] != null 
			&& args[0].length() > 0 && args[1].length() > 0) {
			str1 = args[0];
			str2 = args[1];
		} else {
			throw new IllegalArgumentException();
		}

		System.out.println(new OneAway().isOneEditAwayV1(str1, str2));
	}
}