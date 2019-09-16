package frederiksen_p3;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) { 
		Scanner scanner = new Scanner(System.in);

		String[] topics = new String[] {
			"Biking instead of driving",
			"Existentialism",
			"Value of individuals lives (Kantian)",
			"Violent media = violent people",
			"How much truth do we need"
		};

		int[][] ratings = new int[5][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("Rate the topic, \"%s\", from 1 (least important) to 10 (most important: ", topics[j]);
				ratings[j][i] = scanner.nextInt();
				//ratings[j][i] = 0;

			}
		}

		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < 5; i++) {
			System.out.printf(" %-40s ", topics[i]);

			int sum = 0;
			for (int j = 0; j < 10; j++) {
				sum += ratings[i][j];
				System.out.printf(" %2d ", ratings[i][j]);
			}

			System.out.printf(" : AVG: %f", (double) sum / 10);
			System.out.println("");

			if (sum >= max) {
				max = sum;
				maxIndex = i;
			}

			if (sum <= min) {
				min = sum;
				minIndex = i;
			}
		}

		System.out.printf("\nThe topic with the most points was \"%s\" with %d points.\n", topics[maxIndex], max);
		System.out.printf("The topic with the least points was \"%s\" with %d points.\n", topics[minIndex], min);
	}

}
