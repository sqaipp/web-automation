package com.automation.utils;

import com.automation.helper.DataGetter;
import com.github.javafaker.Faker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateUtils {
	private static final Faker faker = new Faker();
	private static final DataGetter dataGetter = new DataGetter();

	private GenerateUtils() {
	}

	/**
	 * Generates a random phone number with a specific prefix.
	 */
	public static String generateRandomPhoneNumber() {
		// Generate a random number between 100,000,000 and 900,000,000
		int randomNumber = generateRandomNumber(100000000, 900000000);
		dataGetter.setPhoneNumber(formatPhoneNumber("08", randomNumber));
		return dataGetter.getPhoneNumber();
	}

	/**
	 * Generates a password for the forgot password feature.
	 * This method generates a random number between 100,000 and 900,000,
	 * prefixes it with "Klik", and stores it in the DataGetter object.
	 *
	 * @return The generated password
	 */
	public static String passwordForgot() {
		// Generate a random number between 100,000 and 900,000
		int randomNumber = generateRandomNumber(100000, 900000);
		// Store the generated password in the DataGetter object
		dataGetter.setPassForgot("Klik" + randomNumber);
		// Return the generated password
		return dataGetter.getPassForgot();
	}

	/**
	 * Retrieves the password generated for the forgot password feature.
	 *
	 * @return The stored password
	 */
	public static String getPasswordForgot() {
		// Return the stored password from the DataGetter object
		return dataGetter.getPassForgot();
	}

	/**
	 * Retrieves the phone number stored in the DataGetter object.
	 *
	 * @return The stored phone number
	 */
	public static String getPhoneNumber() {
		return dataGetter.getPhoneNumber();
	}

	/**
	 * Retrieves the name stored in the DataGetter object.
	 *
	 * @return The stored name
	 */
	public static String getName() {
		return dataGetter.getName();
	}

	/**
	 * Generates a random number between a minimum and maximum value.
	 *
	 * @param min The minimum value of the range (inclusive)
	 * @param max The maximum value of the range (inclusive)
	 * @return A random number between min and max
	 */
	private static int generateRandomNumber(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	/**
	 * Formats a phone number with a specific prefix.
	 *
	 * @param prefix The prefix to be added to the phone number
	 * @param number The phone number to be formatted
	 * @return The formatted phone number in the format "prefixxxxxxxxx"
	 */
	private static String formatPhoneNumber(String prefix, int number) {
		return prefix + String.format("%08d", number);
	}

	/**
	 * Generates a random full name using the Faker library.
	 *
	 * @return a randomly generated full name
	 */
	public static String generateRandomName() {
		// Store the generated name in the DataGetter object
		dataGetter.setName(faker.name()
				.fullName());
		return dataGetter.getName();
	}

	/**
	 * Generates a random email address using the Faker library.
	 *
	 * @return a randomly generated email address
	 */
	public static String generateRandomEmail() {
		// Use the Faker library to generate a random email address
		dataGetter.setEmailAddress(faker.internet()
								  .emailAddress());
		return dataGetter.getEmailAddress();
	}

	/**
	 * Returns the generated email address.
	 *
	 * @return the generated email address
	 */
	public static String getEmailAddress() {
		return dataGetter.getEmailAddress();
	}

	/**
	 * Writes a phone number to a file.
	 *
	 * @param phoneNumber The phone number to write.
	 * @param filePath    The path of the file to write to.
	 * @throws IOException If an I/O error occurs.
	 */
	public static void writePhoneNumberToFile(String phoneNumber, String filePath) throws IOException {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
			bufferedWriter.write(phoneNumber);
		}
	}

	/**
	 * Returns a string representation of the current date and time in the format "yyyy/MM/dd HH:mm:ss".
	 *
	 * @return a string representing the current date and time
	 */
	public static String setDateTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return now.format(formatter);
	}

	/**
	 * Returns a string representation of the current time in the format "HH:mm:ss".
	 *
	 * @return a string representing the current time
	 */
	public static String setTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		return now.format(formatter);
	}

}
