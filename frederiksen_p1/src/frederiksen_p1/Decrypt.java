package frederiksen_p1;

import java.util.Scanner;

public class Decrypt {
	
	public static void main(String[] args) { 
		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt(); 

		int[] digits = new int[4];

		int p = 1;
		for (int i = 3; i >= 0; i--) {
			digits[i] = (data / p) % 10;
			p *= 10;
		}

		// swap 1st and 3rd
		int x = digits[0];
		digits[0] = digits[2];
		digits[2] = x;

		// swap 2nd and 4th
		x = digits[1];
		digits[1] = digits[3];
		digits[3] = x;

		// sub 7 and mod 10
		for (int i = 0; i < 4; i++)
			digits[i] = (digits[i] - 7 + 10) % 10;

		for (int i = 0; i < 4; i++)
			System.out.print(digits[i]);

		System.out.println("");

	}

}
