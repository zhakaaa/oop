public class Main {
    public static void main(String[] args) {
        Account account = new Account(1);
        account.deposit(100);
        Account account2 = new Account(1);
        account2.deposit(100);

        Bank bank = new Bank();
        bank.addAccount(account);
        CheckingAccount chk = new CheckingAccount(2);
        SavingsAccount sc = new SavingsAccount(3);

        sc.deposit(500);
        chk.deposit(100);
        chk.deposit(100);
        chk.deposit(100);
        bank.addAccount(sc);
        bank.addAccount(chk);
        bank.print();
        bank.update();
        bank.print();

    }
}