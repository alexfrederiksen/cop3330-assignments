package frederiksen_p2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) { 
		Scanner scanner = new Scanner(System.in);

		System.out.print("Would you like to go metric? (Y/n): ");
		char goMetric = scanner.next().charAt(0);

		double bmi;

		if (Character.toLowerCase(goMetric) == 'y') { 
			System.out.print("Enter your weight in kilograms: ");
			double w = scanner.nextDouble();
			System.out.print("Enter your height in meters: ");
			double h = scanner.nextDouble();

			bmi = w / (h * h);
		} else {
			System.out.print("Enter your weight in pounds: ");
			double w = scanner.nextDouble();
			System.out.print("Enter your height in inches: ");
			double h = scanner.nextDouble();

			bmi = (703.0 * w) / (h * h);
		}

		System.out.printf("Your BMI is %f.\n", bmi);

		if (bmi <= 18.5)
			System.out.println("Your underweight.");
		else if (bmi <= 24.9)
			System.out.println("Your normal weight.");
		else if (bmi <= 29.9)
			System.out.println("Your overweight.");
		else
			System.out.println("Your obese.");
	}

}
