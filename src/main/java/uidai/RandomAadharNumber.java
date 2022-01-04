package uidai;

import java.util.Random;

abstract class RandomAadharNumber {
	public static String generateRandomNumber() {
		int len = 12;
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

}
