import java.util.Vector;

public class Bank {
    Vector<Account> accounts = new Vector<Account>();

    public void update(){
        for(Account account : accounts){
            if(account instanceof SavingsAccount savingsAccount){
                savingsAccount.addInterest();
            }
            else if(account instanceof CheckingAccount checkingAccount){
                checkingAccount.deductFee();
            }
        }
    }

    public void print(){
        for (Account account : accounts){
            account.print();
        }
    }

    public void addAccount(Account account){
        accounts.add(account);
    }
}
