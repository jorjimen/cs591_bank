import java.util.*;

abstract class Account implements BankComponent {
    private final ID id = new ID();

    // the type of account
    private String accountType; 

    // the base currency that all the money in the acount is in the form of 
    private String currencyType; 

    // the total amount of money stored in the account in the base currency 
    // (i.e. if there are $100 total in the account, amount is a Dollar object with value 100) 
    private Currency amount;

    // the fee to open the account
    private double openingFee;

    // the fee to close the account 
    private double closingFee;

    // a collection of all the transactions this account has been involved in 
    private ArrayList<Transaction> transactions; 

    public ID getID() {
        return id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCurrency() {
        return currencyType;
    }

    public void setCurrency(String currencyType) {
        this.currencyType = currencyType;
    }

    public Currency getAmount() {
        return amount;
    }

    public void setAmount(Currency amount) {
        this.amount = amount;
    }

    public double getOpeningFee() {
        return openingFee;
    }

    public void setOpeningFee(double openingFee) {
        this.openingFee = openingFee;
    }

    public double getClosingFee() {
        return closingFee;
    }

    public void setClosingFee(double closingFee) {
        this.closingFee = closingFee;
    }

    // a method that prints all the info and details of the account 
    public void printAccountInfo() {
        System.out.println("Account ID: " + id); 
        System.out.println("Account Type: " + accountType); 
        System.out.println("Base Currency: " + currencyType); 
        System.out.println("Total Amount: " + amount);
        
        // prints all the transactions 
        System.out.println("Transactions: "); 
        for (Transaction t : transactions) {
            System.out.println(t);
        }
        System.out.println(); 
    }

}