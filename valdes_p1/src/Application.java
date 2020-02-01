/**
 * This application reads a four-digit integer entered by the user,
 * encrypts the integer and prints to standard output.
 * It also reads an encrypted four-digit integer, decrypts the integer
 * and prints to standard output.
 */

import java.util.Scanner;

public class Application {
	
	public static final int DATA_LENGTH = 4;
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		// Read a 4 digit integer from the user.
		int[] data = readUserData("Please enter a four-digit integer to encrypt: ");
		
		// Encrypt the user's value using Encrypter.encrypt().
		int[] encryptedData = Encrypter.encrypt(data, DATA_LENGTH);
		
		// Print the encrypted value to standard output.
		System.out.print("The encrypted integer is: ");
		for (int i = 0; i < DATA_LENGTH; i++) {
			System.out.print(encryptedData[i]);
		}
		System.out.println();
		
		// Decrypt the user's value using Decrypter.decrypt().
		data = readUserData("Please enter a four-digit integer to decrypt: ");
		int[] decryptedData = Decrypter.decrypt(data, DATA_LENGTH);
		
		// Print the decrypted value to standard output.
		System.out.print("The decrypted integer is: ");
		for (int i = 0; i < DATA_LENGTH; i++) {
			System.out.print(decryptedData[i]);
		}
		
	}
	
	// Method to read user input.
	// The input is read as a String and its length is checked to the
	// requirement. Also the input is checked for numbers only. The prompt
	// repeats until the user correctly enters the String. The String's
	// characters are then converted to integers and returned as an integer
	// array.
	public static int[] readUserData(String prompt) {
		boolean done = false;
		String inputString;
		int[] inputData = new int[DATA_LENGTH];
		
		do {
		    System.out.printf("%s", prompt);
		    inputString = input.nextLine();
		    if (inputString.matches("[0-9]+") && inputString.length() == DATA_LENGTH)
			    done = true;
		} while (!done);
		
		for (int i = 0; i < DATA_LENGTH; i++) {
			inputData[i] = inputString.charAt(i) - '0';
		}
			
		return inputData;
	}

}
