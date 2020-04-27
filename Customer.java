import java.util.*;

public class Customer extends BankUser {

	ArrayList<Account> accounts;

	// a method that prints all the info and details of the customer.
    public void printUserInfo(){
        System.out.println("Customer ID: " + id); 
        System.out.println("Customer name: " + username); 
        System.out.println("Customer password: " + password);
        System.out.println(); 
    }

    // a method that creates a savings or checking account.
    public void createAccount(String accountType){
    	
    }

    // a method that close a savings or checking accout.
    public void closeAccount(String accountType){

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