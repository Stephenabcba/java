import java.util.Random;


public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;

    private static int numAccounts;
    private static double totalDeposit;

    public BankAccount() {
        numAccounts++;
        this.accountNumber = getRandomAccountNumber();
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void depositChecking(double amount) {
        this.checkingBalance += amount;
        totalDeposit += amount;
    }

    public void depositSaving(double amount) {
        this.savingsBalance += amount;
        totalDeposit += amount;
    }

    public void withdrawChecking(double amount) {
        if (amount > this.checkingBalance) {
            System.out.println("Insufficient funds.");
        } else {
            this.checkingBalance -= amount;
            totalDeposit -= amount;
        }
    }

    public void withdrawSavings(double amount) {
        if (amount > this.savingsBalance) {
            System.out.println("Insufficient funds.");
        } else {
            this.savingsBalance -= amount;
            totalDeposit -= amount;
        }
    }

    public void showTotalMoney() {
        double total = this.savingsBalance + this.checkingBalance;
        System.out.println("Total money: " + total);
    }

    private static String getRandomAccountNumber() {
        String accNum = "";
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            accNum += rand.nextInt(10);
        }
        return accNum;
    }
}