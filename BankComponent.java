
public interface BankComponent {

    ID id = new ID();

    default ID getID() {return id;}

}