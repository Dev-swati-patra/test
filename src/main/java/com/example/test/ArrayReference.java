package com.example.test;

public class ArrayReference {
	int n;

	public static void main(String[] args) {
		ArrayReference[] ar = new ArrayReference[3];
		ArrayReference ob = new ArrayReference();
		ar[0] = new ArrayReference();
		ar[0].n = 10;
		ar[1] = new ArrayReference();
		ar[1].n = 20;
		ar[2] = new ArrayReference();
		ar[2].n = 30;
		for (ArrayReference arrayReference : ar) {
			System.out.println(arrayReference.n);
		}
		
	}

}
