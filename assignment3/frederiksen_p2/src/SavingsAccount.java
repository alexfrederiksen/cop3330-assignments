public class SavingsAccount {
    private static float annualInterestRate;

    private float savingsBalance;

    public SavingsAccount(float savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        savingsBalance += (savingsBalance * annualInterestRate) / 12;
    }

    public static void modifyInterestRate(float annualInterestRate) {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public float getSavingsBalance() {
        return savingsBalance;
    }
}
