package com.example.test;

public class ThrowC {
	public static void main(String[] args) {
		try{
	        throw new Exception("100");
	        
	    }
	    catch(Exception e){
	        System.out.println(e);
	    }
	}

}
