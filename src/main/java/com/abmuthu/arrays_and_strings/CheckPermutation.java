package com.abmuthu.arrays_and_strings;

import java.util.Arrays;

/* Core concept: Have to check if same elements
are present in both the strings. */

public class CheckPermutation {

	// version 1 : using sorting. time: O(nlog n) space: O(1) 
	public boolean isPermuationV1(String str1, String str2) {
		char[] str1CharArray = str1.toCharArray();
		char[] str2CharArray = str2.toCharArray();
		Arrays.sort(str1CharArray);
		Arrays.sort(str2CharArray);
		return new String(str1CharArray).equals(new String(str2CharArray));
	}

	// version 2 : using int[] mapping. time: O(n) space: O(n)
	public boolean isPermuationV2(String str1, String str2) {
		int[] charMap = new int[128];

		if (str1.length() > 128 || str2.length() > 128) {
			System.out.println("Illegal Argument");
		}

		// count the letters in str1
		for (int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			charMap[ch]++;
		}

		// decount the letters and check if count is negative
		for (int i = 0; i < str2.length(); i++) {
			char ch = str2.charAt(i);
			charMap[ch]--;
			if (charMap[ch] < 0) {
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		String str1 = null;
		String str2 = null;
		if (args.length == 2 && args[0] != null && args[1] != null) {
			str1 = args[0];
			str2 = args[1];
		} else {
			System.out.print("Illegal Argument");
		}
		System.out.println(new CheckPermutation().isPermuationV2(str1, str2));
	}
}