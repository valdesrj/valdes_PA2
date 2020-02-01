// This method decrypts a four digit number using the following steps:
//  1. Swap the second digit with the fourth.
//  2. Swap the first digit with the third.
//  3. If the encrypted digit is less than 7 add 10 to the digit,
//     else do nothing.
//  4. Finally subtract 7.
//
//  NOTE: Step 3. was derived by observing the pattern from encryption.
//        After the modulus step the pattern was obvious.

public class Decrypter {
	
	public static int[] decrypt(int[] encryptData, int size) {
		int[] decryptData = new int[size]; 
		
		// Swap the second and fourth digits and assign to decrypted array.
		int temp = encryptData[1];
		decryptData[1] = encryptData[3];
		decryptData[3] = temp;
		
		// Swap the first and third digits and assign to decrypted array.
		temp = encryptData[0];
		decryptData[0] = encryptData[2];
		decryptData[2] = temp;
		
		// Final steps to decrypt as stated above.
		for (int i = 0; i < size; i++) {
			if (decryptData[i] < 7) {
				decryptData[i] += 10;
			}
			decryptData[i] -= 7;
		}
				
		return decryptData;
	}

}
