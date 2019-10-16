public class Problem {
    public static class Operation {
        public interface Operator {
            int eval(int a, int b);
        }

        private String name;
        private Operator operator;

        public Operation(String name, Operator operator) {
            this.name = name;
            this.operator = operator;
        }

        public int eval(int a, int b) {
            return operator.eval(a, b);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private int operand1;
    private int operand2;
    private Operation operation;

    public Problem(int operand1, int operand2, Operation operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    public int eval() {
        return operation.eval(operand1, operand2);
    }

    @Override
    public String toString() {
        return operand1 + " " + operation + " " + operand2;
    }
}
