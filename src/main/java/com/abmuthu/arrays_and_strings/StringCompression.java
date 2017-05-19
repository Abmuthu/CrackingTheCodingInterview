package com.abmuthu.arrays_and_strings;

/*
	Core concept: Count if previous character is same else
				  note down count and previous character.
*/

public class StringCompression {

	// version 1 : time: O(n) space: O(1)
	public String compressedStringV1(String input) {
		if (input.length() == 1) {
			return input;
		} 

		int count = 0;
		String output = "";
		int i = 0;
		for (i = 1; i < input.length(); i++) {
			if (input.charAt(i) == input.charAt(i - 1)) {
				count++;
			} else {
				output += input.charAt(i - 1) + "" + (count + 1) + "";
				count = 0;
			}
		}

		if (input.charAt(i - 1) != input.charAt(i - 2)) {
			output += input.charAt(i - 1) + "1";
		} else {
			output += input.charAt(i - 1) + "" + (count + 1) + "";
		}

		return output.length() >= input.length() ? input : output;
	}

	public static void main(String[] args) {
		String input = "";
		if (args.length == 1 && args[0].length() != 0 && args[0] != null) {
			input = args[0];
		} else {
			throw new IllegalArgumentException();
		}

		System.out.println(new StringCompression().compressedStringV1(input));
	}
}