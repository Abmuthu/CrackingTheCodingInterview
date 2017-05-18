package com.abmuthu.arrays_and_strings;

/*
	Core concept: Traverse backwards and maintain right pointer
*/

public class URLify {

	public String replaceSpaces(String str, int originalLength) {
		char[] strAsChar = str.toCharArray();
		int lastPointer = strAsChar.length - 1;
		for (int i = originalLength - 1; i > 0; i--) {
			// if not space move to position pointed by last pointer
			if (strAsChar[i] != ' ') {
				strAsChar[lastPointer] = strAsChar[i];
				lastPointer--;
			} else {
				strAsChar[lastPointer--] = '0';
				strAsChar[lastPointer--] = '2';
				strAsChar[lastPointer--] = '%'; 
			}
		}
		return new String(strAsChar);
	}

	public static void main(String[] args) {
		String input = null;
		int originalLength = -1;
		if (args.length == 2 && args[0] != null) {
			input = args[0];
			originalLength = Integer.parseInt(args[1]);
		} else {
			System.out.println("Illegal Argument");
		}
		System.out.println(new URLify().replaceSpaces(input, originalLength));
	}
}