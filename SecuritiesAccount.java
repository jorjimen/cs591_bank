import java.util.*;
public class SecuritiesAccount extends Account {
    // a collection that stores all the stocks owned 
    private ArrayList<Stock> stocks; 

    // a collection that stores all the open positions 
    private ArrayList<Stock> openPositions;

    public SecuritiesAccount() {
        setAccountType("securities"); 
    }

}