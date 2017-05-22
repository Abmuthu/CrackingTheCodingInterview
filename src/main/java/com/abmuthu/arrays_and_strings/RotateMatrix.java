package com.abmuthu.arrays_and_strings;



public class RotateMatrix {

	// version 1: copy 1st row to last column and so on. time: O(n^2) space: O(n^2)
	public int[][] rotateMatrixV1(int[][] image) {
		int[][] rotatedImage = new int[image.length][image.length];
		for (int rowIndex = 0; rowIndex < image.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < image.length; columnIndex++) {
				rotatedImage[columnIndex][image.length - rowIndex - 1] = image[rowIndex][columnIndex];
			}
		}
		return rotatedImage;
	}

	// version 2: Pending.

	public static void main(String[] args) {
		int[][] testImage = {{7, 8, -1}, {4, 6, 2}, {11, 9, 5}};
		System.out.println("Original matrix");
		for (int i = 0; i < testImage.length; i++) {
			for (int j = 0; j < testImage.length; j++) {
				System.out.print(testImage[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("rotated matrix");
		testImage = new RotateMatrix().rotateMatrixV1(testImage);
		for (int i = 0; i < testImage.length; i++) {
			for (int j = 0; j < testImage.length; j++) {
				System.out.print(testImage[i][j] + " ");
			}
			System.out.println();
		}
	}
}