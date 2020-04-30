import java.util.*;

public class Customer extends BankUser {

	public Customer(String username, String password) {
        super(username, password);
    }

    ArrayList<Account> accounts;

	// a method that prints all the info and details of the customer.
    public void printUserInfo(){
        System.out.println("Customer ID: " + super.getID());
        System.out.println("Customer name: " + super.getUsername()); 
        System.out.println("Customer password: " + super.getPassword());
        System.out.println(); 
    }

    // a method that creates a savings or checking account.
    public void createAccount(String accountType, String currencyType, Currency amount){
        Account newAccount;
        switch (accountType) {
            case "savings":
                newAccount = new SavingsAccount();
                break;
            case "loan":
                newAccount = new LoanAccount();
                break;
            case "securities":
                newAccount = new SecuritiesAccount();
                break;
            default:
                System.out.println("We don't support this kind of account now.");
                return;
        }
        if(checkEnoughFee(newAccount.getOpeningFee())){
            newAccount.setCurrencyType(currencyType);
            newAccount.setAmount(amount);
            accounts.add(newAccount);
        }else{
            System.out.println("Doesn't have enough money to pay the fee of creating account.");
        }
        return;
    }

    // a method that close a savings or checking accout.
    public void closeAccount(String accountType){

    }

    // a method checks whether the customer can pay the fee.
    public boolean checkEnoughFee(double requireFee){
        return true;
    }

	// a method that requests a loan.
    public void requestLoan(){

    }

    // a method that shows transactions of the user.
    public void showTransaction(){

    }

    // a method that shows current balances of the user.
    public void showCurrentBalances(){

    }

}