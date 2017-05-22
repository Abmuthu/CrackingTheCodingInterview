package com.abmuthu.arrays_and_strings;

/*
	Core concept : Remember which rows and columns have zero in it.
*/

public class ZeroMatrix {

	// version 1: using two arrays(size m and n). time: O(m * n) space: O(m + n)
	public void makeZeroesV1(int[][] matrix) {
		boolean[] mRows = new boolean[matrix.length];
		boolean[] nColumns = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for ( int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					mRows[i] = true;
					nColumns[j] = true;
				}
			}
		}


		// redundant steps. could be improved.	
		for (int i = 0; i < mRows.length; i++) {
			if (mRows[i]) {
				for (int j = 0; j < nColumns.length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < nColumns.length; i++) {
			if (nColumns[i]) {
				for (int j = 0; j < mRows.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}

	}

	// version 2: using int and bit operations. time: O(n) space: O(1)
	public void makeZeroesV2(int[][] matrix) {
		int row = 0;
		int column = 0;

		for (int i = 0; i < matrix.length; i++) {
			for ( int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row = row | (1 << i);
					column = column | (1 << ((matrix[0].length-1) - j));
				}
			}
		}

		System.out.println("row" + row);
		System.out.println("Column" + column);

		int pointer = 1;
		for (int i = 0; i < matrix.length; i++) {
			if ((row & pointer) != 0) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
			pointer = pointer << 1;
		}

		pointer = 1;
		for (int i = matrix[0].length - 1; i >= 0; i--) {
			if ((column & pointer) != 0) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
			pointer = pointer << 1;
		}


	}

	public static void main(String[] args) {
		int[][] myArr = {{1, 0, 3}, {0, -1, 4}, {7, 8, 9}};
		System.out.println("Original matrix");
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr.length; j++) {
				System.out.print(myArr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("zeroed matrix");
		new ZeroMatrix().makeZeroesV2(myArr);
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr.length; j++) {
				System.out.print(myArr[i][j] + " ");
			}
			System.out.println();
		}
	}
} 