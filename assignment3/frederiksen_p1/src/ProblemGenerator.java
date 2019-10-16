import java.security.SecureRandom;

public class ProblemGenerator {
    public enum Type {
        OnlyAddition,
        OnlySubtraction,
        OnlyMultiplication,
        OnlyDivision,
        Any
    }

    private Type type;
    private int difficulty;

    private SecureRandom random;

    private static final Problem.Operation ADDITION = new Problem.Operation("plus", (a, b) -> a + b);
    private static final Problem.Operation SUBTRACTION = new Problem.Operation("minus", (a, b) -> a - b);
    private static final Problem.Operation MULTIPLICATION = new Problem.Operation("times", (a, b) -> a * b);
    private static final Problem.Operation DIVISION = new Problem.Operation("divided by", (a, b) -> a / b);

    public ProblemGenerator(Type type, int difficulty) {
        this.type = type;
        this.difficulty = difficulty;

        random = new SecureRandom();
    }

    private Problem.Operation getOperation(Type type) {
        switch(type) {
            case OnlyAddition:
                return ADDITION;
            case OnlySubtraction:
                return SUBTRACTION;
            case OnlyMultiplication:
                return MULTIPLICATION;
            case OnlyDivision:
                return DIVISION;
            default:
                // ANY case
                return getOperation(Type.values()[random.nextInt(4)]);
        }
    }

    private Problem.Operation getOperation() {
        return getOperation(type);
    }

    private int generateNumber() {
        return random.nextInt((int) Math.pow(10, difficulty) - 1) + 1;
    }

    public Problem generate() {
        int operand1 = generateNumber();
        int operand2 = generateNumber();
        Problem.Operation operation = getOperation();

        return new Problem(operand1, operand2, operation);
    }
}
