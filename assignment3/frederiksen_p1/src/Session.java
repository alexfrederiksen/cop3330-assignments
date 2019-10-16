import java.util.Scanner;

public class Session {
    private static final int PROBLEM_COUNT = 10;

    private static final MessagePool CORRECT_MSGS = new MessagePool(
            new String[]{
                    "Very good!",
                    "Excellent!",
                    "Nice work!",
                    "Keep up the good work!"
            });

    private static final MessagePool INCORRECT_MSGS = new MessagePool(
            new String[]{
                    "No. Please try again.",
                    "Wrong. Try once more.",
                    "Don’t give up!",
                    "No. Keep trying."
            });

    private int totalCorrect;
    private Scanner scanner;


    public Session(Scanner scanner) {
        this.scanner = scanner;
        totalCorrect = 0;
    }

    private int promptInt(int min, int max) {
        int in;
        do {
            System.out.printf("Enter an integer (%d - %d): ", min, max);
            in = scanner.nextInt();
        } while (in < min || in > max);

        return in;
    }

    private int promptInt() {
        System.out.print("Enter an integer: ");
        return scanner.nextInt();
    }

    private ProblemGenerator.Type promptType() {
        System.out.println("\n### Select problem type ###");
        System.out.println("  1. Addition");
        System.out.println("  2. Subtraction");
        System.out.println("  3. Multiplication");
        System.out.println("  4. Division");
        System.out.println("  5. Any\n");

        int i = promptInt(1, 5);

        return ProblemGenerator.Type.values()[i - 1];
    }

    private int promptDifficulty() {
        System.out.println("\n### Select your difficulty ###\n");
        return promptInt(1, 4);
    }

    public void start() {
        int difficulty = promptDifficulty();
        ProblemGenerator.Type type = promptType();

        ProblemGenerator gen = new ProblemGenerator(type, difficulty);

        run(gen);
    }

    private int promptProblem(int number, Problem problem) {
        System.out.printf("\n### Problem %d / %d ###\n", number, PROBLEM_COUNT);
        System.out.printf("  What is %s?\n\n", problem);

        return promptInt();
    }

    private void run(ProblemGenerator gen) {
        for (int i = 0; i < PROBLEM_COUNT; i++) {
            Problem problem = gen.generate();

            int answer = promptProblem(i + 1, problem);

            boolean correct = answer == problem.eval();

            if (correct) {
                totalCorrect++;
                System.out.printf("\n# %s #\n\n", CORRECT_MSGS.fetchRandom());
            } else {
                System.out.printf("\n# %s #\n\n", INCORRECT_MSGS.fetchRandom());
            }
        }
    }

    public float computeScore() {
        return (float) totalCorrect / 10;
    }

}
