import java.util.*; 

public class StockMarket implements BankComponent {
    private final ID id = new ID();
    private ArrayList<Stock> stocks; 

    public StockMarket(ArrayList<Stock> stocks) {
        this.stocks = stocks; 
    }

    public ID getID() {
        return id;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }



}