
// Abstract class Transacation: Implementation for the different transactions at the user/customer level
// Implements the BankComponent interface

import java.util.Date;

abstract public class Transaction implements BankComponent {

    // private data members for any Transaction
    private final Account account;
    private final BankUser user;
    private final Currency value;
    private final Date date;
    private final ID id = new ID();

    // constructor for a transaction
    public Transaction(Account account, BankUser user, Currency value, Date date) {
        this.account = account;
        this.user = user;
        this.value = value;
        this.date = date;
    }

    // getter methods for a transaction

    public Account getAccount() {
        return account;
    }

    public BankUser getUser() {
        return user;
    }

    public Currency getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public ID getID() {
        return id;
    }

    // returns directly the value of the currency as a double (not the currency object itself)
    public double getValueAsDouble() {
        return value.getValue();
    }

    // returns the Class type of the Currency associated with this transaction
    public Class<? extends Currency> getCurrencyType() {
        return value.getClass();
    }

    // toString() implementation for a Transaction
    public String toString() {
        String strRepr = "(" + this.getID() + ")" + ": " + value + " (" + date.toString() + ")";
        return strRepr;
    }

}