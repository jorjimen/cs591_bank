import java.util.*;
public class LoanAccount extends Account {
    // a collection that stores all of the loans that the holder of 
    // the account has taken out
    private ArrayList<Loan> loans;

    public LoanAccount() {
        setAccountType("loan"); 
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    // overrides method of parent class to also print loans
    public void printAccountInfo() {
        super.printAccountInfo();
        System.out.println("Loans: "); 
        for (Loan l : loans) {
            System.out.println(l); 
        }
    }

}