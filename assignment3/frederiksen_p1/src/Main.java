import java.util.Scanner;

public class Main {
    private static final float SCORE_THRESHOLD = 0.75f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Session session = new Session(scanner);

            System.out.println("\n### Welcome to math training ###\n");

            session.start();

            float score = session.computeScore();

            if (score >= SCORE_THRESHOLD) {
                System.out.println("\nCongratulations, you are ready to go to the next level!");
            } else {
                System.out.println("\nPlease ask your teacher for extra help.");
            }
        }
    }
}
