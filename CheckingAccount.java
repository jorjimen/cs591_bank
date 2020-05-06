
public class CheckingAccount extends Account{
    // the fee charged to withdraw money from the account
    private double withdrawalFee;
    
    // to set up the checking account
    public CheckingAccount(String currencyType) {
        super(currencyType); 
        setAccountType("checking"); 
    }

    public double getWithdrawalFee() {
        return withdrawalFee;
    }

    public void setWithdrawalFee(double withdrawalFee) {
        this.withdrawalFee = withdrawalFee;
    }

}
