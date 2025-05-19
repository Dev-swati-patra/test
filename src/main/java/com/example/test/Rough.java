package com.example.test;

public class Rough {
	// spiral Matrix
	static void spiralM() {
		int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int lft = 0, top = 0, btm = 4, rght = 4;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------");
		while (top != btm && rght != lft) {
			for (int i = lft; i <= rght; i++) {
				System.out.print(matrix[top][i] + " ");

			}
			top++;
			System.out.println();
			for (int i = top; i <= btm; i++) {
				System.out.print(matrix[i][rght] + " ");

			}
			rght--;
			System.out.println();
			for (int i = rght; i >= lft; i--) {
				System.out.print(matrix[btm][i] + " ");

			}
			btm--;
			System.out.println();
			for (int i = btm; i >= top; i--) {
				System.out.print(matrix[i][lft] + " ");

			}
			lft++;
			System.out.println();

		}

	}

	public static void main(String[] args) {
//		int count = 0;
//		int[] list = { 6, 4, 4, 2, 2, 1, 9, 1, 2 };
//		Arrays.sort(list);
//		for (int i = 0; i < list.length; i++) {
//			for (int j = i + 1; j < list.length; j++)
//				if (list[i] == list[j]) {
//
//					count++;
//				}
//		}
//		System.out.println(count);
//		spiralM();
//		Runtime r = Runtime.getRuntime();
//		Process rr = r.exec("notepad");
		String s = "Tata Consultancy Service", ss = "";
		String[] str = s.split(" ");

		for (int i = 0; i < str.length; i++) {
			ss += str[i].substring(0, 1);
		}
		System.out.println(ss);
//		System.out.println(str[0].substring(0, 1).concat(str[1].substring(0, 1)));

	}

}
