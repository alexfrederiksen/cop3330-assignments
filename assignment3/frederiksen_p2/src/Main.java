public class Main {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000f);
        SavingsAccount saver2 = new SavingsAccount(3000f);

        System.out.println("Interest rate set to 0.04.\n");

        SavingsAccount.modifyInterestRate(0.04f);
        for (int i = 0; i < 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();

            System.out.printf("Saver 1: $%f    Saver 2: $%f\n",
                              saver1.getSavingsBalance(),
                              saver2.getSavingsBalance());
        }

        SavingsAccount.modifyInterestRate(0.05f);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("\nInterest rate changed to 0.05.\n");
        System.out.printf("Saver 1: $%f    Saver 2: $%f\n",
                              saver1.getSavingsBalance(),
                              saver2.getSavingsBalance());
    }
}
