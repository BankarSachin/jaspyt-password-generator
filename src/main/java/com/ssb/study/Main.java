package com.ssb.study;

import org.jasypt.util.text.AES256TextEncryptor;

public class Main {

	public static void main(String[] args) {
		String secretKey = System.getenv("JASYPT_ENCRYPTOR_PASSWORD");
		final String encryptedPassword = encryptPassword("",secretKey);
		System.out.println(" App Password encrypted " + encryptedPassword);
		final String descryptedPassword = decryptPassword(encryptedPassword, secretKey);
		System.out.println(" App Password plaintext " + descryptedPassword);
	}

	public static String encryptPassword(String password, String secretKey) {
		AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
		textEncryptor.setPassword(secretKey);
		return textEncryptor.encrypt(password);
	}

	public static String decryptPassword(String encryptedPassword, String secretKey) {
		AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
		textEncryptor.setPassword(secretKey);
		return textEncryptor.decrypt(encryptedPassword);
	}
}
