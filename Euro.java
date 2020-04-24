
// Public class for the Euro representation
// Extends the Currency abstract class

public class Euro extends Currency {

    // Contains the symbol of the Euro
    private final String symbol = "€";

    // class constructor
    public Euro(double value) {
        super(value);
    }

    // Returns this currency, converted into another currency object.
    public Currency convertTo(String currency) {
        switch (currency) {
            case "dollar":
                return new Dollar(this.getValue() * 1.07);
            case "yen":
                return new Yen(this.getValue() * 116.27906);
            default:
                return this;
        }
    }

    // returns the symbol for this currency
    public String getSymbol() {
        return symbol;
    }

    // Euro toString() method
    public String toString() {
        return symbol + super.toString();
    }

}