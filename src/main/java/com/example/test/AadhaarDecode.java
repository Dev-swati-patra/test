package com.example.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class AadhaarDecode {
	public static void main(String[] args) {
		String inputFilePath = "C:\\Users\\NICSI\\Downloads\\mp_aadhaars_encoded.txt";
		String outputFilePath = "C:\\Users\\NICSI\\Downloads\\aadhar_decoded.txt";

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
			String encodedLine;
			int lineNumber = 1;

			while ((encodedLine = reader.readLine()) != null) {
				try {
					byte[] decodedBytes = Base64.getDecoder().decode(encodedLine);
					String decodedValue = new String(decodedBytes);

					writer.write("Line " + lineNumber + ": " + decodedValue);
					writer.newLine();

					System.out.println("Decoded Line " + lineNumber + ": " + decodedValue);
					lineNumber++;
				} catch (IllegalArgumentException e) {
					System.err.println("Invalid Base64 data on line " + lineNumber);
				}
			}

			System.out.println("Decoding completed. Decoded values saved to " + outputFilePath);
		} catch (IOException e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}
}
