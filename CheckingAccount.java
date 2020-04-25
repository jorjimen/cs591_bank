
public class CheckingAccount extends Account{
    // the fee charged to withdraw money from the account
    private double withdrawalFee;

    public CheckingAccount() {
        setAccountType("checking"); 
    }

    public double getWithdrawalFee() {
        return withdrawalFee;
    }

    public void setWithdrawalFee(double withdrawalFee) {
        this.withdrawalFee = withdrawalFee;
    }

}