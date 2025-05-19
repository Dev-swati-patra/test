
package com.example.test;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.test.repo.StudentRepo;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		String s = "sandeep", ss = "";
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
//			if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
//				ss += s.charAt(i);
//			}
			set.add(s.charAt(i));
		}
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int arr[] = new int[a.length - 1];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 3) {
				arr[k] = a[i];
				k++;
			}

		}
		System.out.println(set);
	}

	@Autowired
	private StudentRepo repo;

	@Override
	public void run(String... args) throws java.lang.Exception {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void run(String... args) throws Exception {
////		Student std1 = new Student("Smuti", "Patra", "smruti@gmail.com");
////		repo.save(std1);
//	}

}
