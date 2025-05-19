package com.example.test;

import java.util.Scanner;

public class Bubble {
	public static void bubbleSort(int[] ar) {
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = 1; j < ar.length - i; j++) {
				if (ar[j - 1] > ar[j]) {
					int t = ar[j - 1];
					ar[j - 1] = ar[j];
					ar[j] = t;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ar[] = new int[5];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = sc.nextInt();
		}
		bubbleSort(ar);
		for (int i = 0; i < ar.length; i++) {

			System.out.print(ar[i] + " ");
		}
	}

//	    static void hakuna(int[] arr) {  
//	        int n = arr.length;   
//	        int temp = 0;  
//	         for(int i=0; i < n; i++){  
//	                 for(int j=1; j < (n-i); j++){  
//	                          if(arr[j-1] > arr[j]){  
//	                                 //swap elements  
//	                                 temp = arr[j-1];  
//	                                 arr[j-1] = arr[j];  
//	                                 arr[j] = temp;  
//	                         }  
//	                 }  
//	         }  
//	    }  
}
