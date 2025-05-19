package com.example.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class cat implements Comparable<String> {
	String s = "bvc";

	@Override
	public int compareTo(String o) {
		if (this.s.equals(o)) {
			return 0;
		}
		return 1;
	}
}

public class ArrayTest {
	public static void main(String[] args) {
//		cat cat = new cat();
//		String ss = "avc";
//		System.out.println(cat.compareTo(ss));
//		String str = "Rakesh";
//		str = str + String.join(" +", Collections.nCopies(5, " Swain"));
//		String newString = "Swati Rekha" + String.join("+", " smruti", " happy", " ff ", " f ");
//		System.out.println("------------ " + str);
//		System.out.println("------------ " + newString);
//		System.out.println(BigDecimal.ZERO);
//		String[] arr= {"apple","orange","grape"};
//		List<String> list=Arrays.asList(arr);
//		System.out.println(Arrays.toString(arr));
//		list.add(0, "nuts");
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		List<Integer> num = list.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(num);

	}

}
