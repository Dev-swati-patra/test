package com.example.test;

public class Singleton {
	private static Singleton objSingleton;

	private Singleton() {
		System.out.println("singleton instance created....");

	}

	public static Singleton getObj() {
		if (objSingleton == null) {
			objSingleton = new Singleton();

		}
		return objSingleton;

	}
}
class Demo{
	public static void main(String args[]) {
		Singleton s1=Singleton.getObj();
		Singleton s2=Singleton.getObj();
	}
}
