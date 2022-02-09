public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount();
        BankAccount ba2 = new BankAccount();
        ba1.depositChecking(300.0);
        ba1.depositChecking(700.0);
        ba2.depositChecking(500.0);
        ba2.depositChecking(300.0);
        ba1.withdrawChecking(100.0);
        ba1.withdrawSavings(100.0);
        ba1.showTotalMoney();
        ba2.showTotalMoney();
    }
}