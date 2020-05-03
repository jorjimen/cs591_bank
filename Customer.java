
import java.util.*;

public class Customer extends BankUser {

    ArrayList<Account> accounts = new ArrayList<Account>();
    AccountFactory accountFactory = new AccountFactory();

	public Customer(String username, String password, Currency startingValue) {
        super(username, password);
        CheckingAccount firstAccount = new CheckingAccount("dollar");
        firstAccount.setAmount(new Dollar(500.0));
        firstAccount.deposit(new Deposit(firstAccount, this, startingValue, new Date()));
        openAccount(firstAccount);
    }

    // method for opening an account
    public void openAccount(Account account) {
        accounts.add(account);
    }

    // get all accounts
    public ArrayList<Account> getAllAccounts() {
        return accounts;
    }

    // gets an account by index
    public Account getAccountByIndex(int i) {
        return accounts.get(i);
    }

    // close an account
    public boolean closeAccount(int i){
        Account toClose = accounts.get(i);
        if (toClose.getAmount().getValue() + toClose.getClosingFee().getValue() < 0) {
            return false;
        } else {
            toClose.setAmount(new Dollar(toClose.getAmount().getValue() + toClose.getClosingFee().getValue()).convertTo(toClose.getCurrencyType()));
            accounts.remove(i);
            return true;
        }
    }

    // delete account
    public boolean deleteAccount(String accountNum){
        int index = findAccount(accountNum);
        accounts.remove(index);
        return true;
    }

    // return account index
    public int findAccount(String accountNum){
        int length = accounts.size();
        for(int i=0;i<length;i++){
            if(accounts.get(i).getID().toString().equals(accountNum)){
                return i;
            }
        }
        return -1;
    }

	// a method that requests a loan.
    public boolean requestLoan(Currency amount, String collateral){
        int index = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) instanceof LoanAccount) {
                index = i;
            }
        }
        if (index != -1) {
            LoanAccount loanAccount = (LoanAccount) accounts.get(index);
            loanAccount.addLoan(new Loan(amount, this, new Date(), collateral));
            return true;
        } else {
            return false;
        }
    }

    // a method that shows transactions of the user.
    public ArrayList<Transaction> showTransactionForAccountAtIndex(int i){
        return accounts.get(i).getTransactions();
    }

    // gets all the transactions associated with a user
    public ArrayList<Transaction> getAllTransactions() {
        ArrayList<Transaction> allTransactions = new ArrayList<Transaction>();
        for (Account acc : accounts) {
            allTransactions.addAll(acc.getTransactions());
        }
        return allTransactions;
    }

    // a method that shows current balances of the user.
    public Currency showCurrentBalances(String currencyType){
        double value = 0;
        for (Account account : accounts) {
            Currency balance = account.getAmount();
            value += balance.convertTo(currencyType).getValue();
        }
        switch (currencyType) {
            case "dollar":
                return new Dollar(value);
            case "yen":
                return new Yen(value);
            case "euro":
                return new Euro(value);
        }
        return new Dollar(value);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }


    public int getCheckingNum(){
        ArrayList<Account> accounts = this.getAccounts();
        int count = 0;
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getAccountType().equals("checking")){
                count++;
            }
        }
        return count;
    }



    public int getSavingNum() {
        ArrayList<Account> accounts = this.getAccounts();
        int count = 0;
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getAccountType().equals("savings")){
                count++;
            }
        }
        return count;
    }

    public int getSecurititesNum() {
        ArrayList<Account> accounts = this.getAccounts();
        int count = 0;
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getAccountType().equals("securities")){
                count++;
            }
        }
        return count;
    }

    public int getLoanNum() {
        ArrayList<Account> accounts = this.getAccounts();
        int count = 0;
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getAccountType().equals("loan")){
                count++;
            }
        }
        return count;
    }
}