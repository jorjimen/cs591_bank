
// Public class for the Euro representation
// Extends the Currency abstract class

public class Yen extends Currency {

    // Contains the symbol of the Yen
    private final String symbol = "¥";

    // class constructor
    public Yen(double value) {
        super(value);
    }

    // Returns this currency, converted into another currency object.
    public Currency convertTo(String currency) {
        if (currency.equals("dollar")) {
            return new Dollar(this.getValue() * 0.0093);
        } else if (currency.equals("euro")) {
            return new Euro(this.getValue() * 0.0086);
        } else {
            return this;
        }
    }

    // returns the symbol for this currency
    public String getSymbol() {
        return symbol;
    }

    // Yen toString() method
    public String toString() {
        return symbol + super.toString();
    }
    
}