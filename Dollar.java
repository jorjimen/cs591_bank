
// Public class for the Dollar representation
// Extends the Currency abstract class

public class Dollar extends Currency {

    // Contains the symbol of the Dollar
    private final String symbol = "$";

    // class constructor
    public Dollar(double value) {
        super(value);
    }

    // Returns this currency, converted into another currency object.
    public Currency convertTo(String currency) {
        switch (currency) {
            case "euro":
                return new Euro(this.getValue() * 0.93);
            case "yen":
                return new Yen(this.getValue() * 107.59);
            default:
                return this;
        }
    }

    // returns the symbol for this currency
    public String getSymbol() {
        return symbol;
    }

    // Dollar toString() method
    public String toString() {
        return "$" + super.toString();
    }

}