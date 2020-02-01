
public class Encrypter {
	
	// This method encrypts a four digit number using the following steps:
	//  1. Replace each digit with the result of adding 7.
	//  2. Obtain the remainder after dividing by 10 using modulus.
	//  3. Swap the first digit with the third.
	//  4. Swap the second digit with the fourth.
	public static int[] encrypt(int[] origData, int size) {
		int[] encryptData = new int[size];
		
		// First steps to encrypt as stated above.
		for (int i = 0; i < size; i++) {
			origData[i] += 7;
			origData[i] %= 10;
		}
		
		// Swap the first and third digits and assign to encrypted array.
		int temp = origData[0];
		encryptData[0] = origData[2];
		encryptData[2] = temp;
		
		// Swap the second and fourth digits and assign to encrypted array.
		temp = origData[1];
		encryptData[1] = origData[3];
		encryptData[3] = temp;
		
		return encryptData;
	}

}
