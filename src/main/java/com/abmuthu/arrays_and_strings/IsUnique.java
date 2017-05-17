package com.abmuthu.arrays_and_strings;

import java.util.Set;
import java.util.HashSet;

public class IsUnique {

	// version 1 : using HashSet
	public boolean areCharactersUniqueV1(String inp) {
		Set<Character> charSet = new HashSet<>();
		for (int i = 0; i < inp.length(); i++) {
			char ch = inp.charAt(i);
			if (charSet.contains(ch)) {
				return false;
			} else {
				charSet.add(ch);
			}
		}
		return true;
	}

	// version 2 : using int[] mapping of 128 characters
	public boolean areCharactersUniqueV2(String inp) {
		if (inp.length() > 128) {
			return false;
		}
		int[] charMap = new int[128];
		for (int i = 0; i < inp.length(); i++) {
			char ch = inp.charAt(i);
			if (charMap[ch] != 0) {
				return false;
			} else {
				charMap[ch]++;
			}
		}
		return true;

	}

	// version 3 : using int variable to store (supports < 32 letters) 
	public boolean areCharactersUniqueV3(String inp) {
		// supporting only 26 characters
		if (inp.length() > 26) {
			return false;
		}
		int storeVariable = 0;
		for (int i = 0; i < inp.length(); i++) {
			int chVal = inp.charAt(i) - 'a';
			// check if chVal's encoded value is stored/visited
			if (((1 << chVal) & storeVariable) != 0) {
				return false;
			} else {
				// add encoded chVal's bit to already stored/visited bits
				storeVariable = 1 << chVal | storeVariable;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		String input = null;
		if (args.length == 1 && args[0] != null) {
			input = args[0];
		} else {
			System.out.println("IllegalArgument");
		}
		System.out.println(new IsUnique().areCharactersUniqueV3(input));
	}
}