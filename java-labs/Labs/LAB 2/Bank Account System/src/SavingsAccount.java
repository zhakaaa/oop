public class SavingsAccount extends Account {
    private static final double interestRate = 1.15;

    public SavingsAccount(int accountNumber){
        super(accountNumber);
    }

    public void addInterest(){
        double balance = getBalance();           // Важно получать баланс внутри метода.
        balance = balance * interestRate;
        setBalance(balance);                     // Важно также изменить баланс базового класса.
        System.out.println(balance);
    }

    public static double getInterest(){
        return interestRate;
    }

    @Override public String toString(){
        return "Current Balance: " + getBalance() + ", Account Number: " + getAccountNumber() + " Interest rate is: " + getInterest();
    }
}
