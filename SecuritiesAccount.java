import java.util.*;
public class SecuritiesAccount extends Account {
    // a collection that stores all the stocks owned 
    private ArrayList<Stock> stocks; 

    // a collection that stores all the open positions 
    private ArrayList<Stock> openPositions;

    public SecuritiesAccount(String currencyType) {
        super(currencyType); 
        setAccountType("securities"); 
    }

    public boolean buy(Stock stock, int numShares) {
        boolean transactionSuccessful = false; 
        if (getAmount().getValue() >= stock.getCurrentPrice().getValue()*numShares) { // if account has enough money to buy stock
            Currency convertedCurrency = stock.getCurrentPrice().convertTo(getCurrencyType()); 
            double totalAmount = getAmount().getValue() - convertedCurrency.getValue()*numShares; // deduct price of total purchase from account's balance

            Currency updatedCurrency = new Dollar(totalAmount); 
            switch(getCurrencyType()) {
                case "euro":
                    updatedCurrency = new Euro(totalAmount);
                case "yen": 
                    updatedCurrency = new Yen(totalAmount); 
            }
            setAmount(updatedCurrency); // update the account's new balance
            stocks.add(stock); // add the stock to the account's stocks
            transactionSuccessful = true; 
        } else {
            System.out.println("This account does not have enough money for this transaction"); 
        }
        return transactionSuccessful; 
    }

    public boolean sell(Stock stock, int numShares) {
        boolean transactionSuccessful = false; 
        if (stocks.contains(stock)) { // if the account actually owns the stock attempted to be sold
            Currency convertedCurrency = stock.getCurrentPrice().convertTo(getCurrencyType()); 
            double totalAmount = getAmount().getValue() + convertedCurrency.getValue()*numShares; // add price of total sale to account's balance

            Currency updatedCurrency = new Dollar(totalAmount); 
            switch(getCurrencyType()) {
                case "euro":
                    updatedCurrency = new Euro(totalAmount);
                case "yen": 
                    updatedCurrency = new Yen(totalAmount); 
            }
            setAmount(updatedCurrency); // update the account's new balance
            stocks.remove(stock); // add the stock to the account's stocks
            transactionSuccessful = true; 
        } else {
            System.out.println("This account does not own this stock."); 
        }
        return transactionSuccessful; 
    }


}