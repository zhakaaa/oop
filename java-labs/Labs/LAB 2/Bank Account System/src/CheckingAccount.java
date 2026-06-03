public class CheckingAccount extends Account {

    private static int countOfTransactions;
    private static final int freeTransactions = 5;

    public CheckingAccount(int accountNumber){
        super(accountNumber);
    }

    public void deductFee() {
        double balance = getBalance();
        balance -= 0.02;
        setBalance(balance);
    }

    public static int getCountOfTransactions() {
        return countOfTransactions;
    }
    public static void setCountOfTransactions(int countOfTransaction) {
        countOfTransactions = countOfTransaction;
    }

    public static int getFreeTransactions() {
        return freeTransactions;
    }

    @Override public String toString(){
        return "Current Balance: " + getBalance() + ", Account Number: " + getAccountNumber() + " Number of transactions: " + getCountOfTransactions();
    }
}

