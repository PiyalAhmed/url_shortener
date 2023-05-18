package com.piyal.url_shortener.helper;

public class Base62Helper {
	private static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int OUTPUT_LENGTH = 6;
	private static final long MAX_COMBINATIONS = (long) Math.pow(CHARACTERS.length(), OUTPUT_LENGTH);
	public static String encodeToBase62(Long sequenceNumber) {
		if (sequenceNumber < 0 || sequenceNumber >= MAX_COMBINATIONS) {
			throw new IllegalArgumentException("Invalid sequence number.");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < OUTPUT_LENGTH; i++) {
			int index = (int) (sequenceNumber % CHARACTERS.length());
			sb.insert(0, CHARACTERS.charAt(index));
			sequenceNumber /= CHARACTERS.length();
		}
		return sb.toString();
	}
	
	public static Long decodeFromBase62(String encodedString) {
		long decodedValue = 0L;
		int power = 0;
		
		for (int i = encodedString.length() - 1; i >= 0; i--) {
			char c = encodedString.charAt(i);
			int value = CHARACTERS.indexOf(c);
			decodedValue += (value * Math.pow(62, power));
			power++;
		}
		return decodedValue;
	}
}
