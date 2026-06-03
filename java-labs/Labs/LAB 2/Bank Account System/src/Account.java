public class Account {
    private double balance;
    private int accountNumber;

    public Account(int accountNumber) {
        balance = 0.0;
        this.accountNumber = accountNumber;
    }

    public void deposit(double sum){
        balance += sum;
        int countOfTransactions = CheckingAccount.getCountOfTransactions();
        countOfTransactions++;
        CheckingAccount.setCountOfTransactions(countOfTransactions);

        if(countOfTransactions > CheckingAccount.getFreeTransactions()){
            balance -= 0.02;
        }
    }

    public void withdraw(double sum){
        if(balance >= sum){
            balance -= sum;
            if(CheckingAccount.getCountOfTransactions() > CheckingAccount.getFreeTransactions()){
                balance -= 0.02;
            }

            int countOfTransactions = CheckingAccount.getCountOfTransactions();
            countOfTransactions++;
            CheckingAccount.setCountOfTransactions(countOfTransactions);
        }

        else System.out.println("Balance = " + balance);
    }

    public void transfer(double amount, Account destination){
        if(balance >= amount){
            destination.balance += amount;
            withdraw(amount);
            if(CheckingAccount.getCountOfTransactions() > CheckingAccount.getFreeTransactions()){
                balance -= 0.02;
            }
        }
        else System.out.println("Transfer cancelled! Insufficient balance! Balance = " + balance);
    }

    public double getBalance() {return balance;}
    public void setBalance(double balance) {this.balance = balance;}
    public int getAccountNumber() {return accountNumber;}

    public String toString(){
        return "Current Balance: " + getBalance() + ", Account Number: " + getAccountNumber();
    }

    public final void print(){
        System.out.println(toString());
    }

    public Account(){};
}
