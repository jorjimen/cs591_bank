import java.util.*;

public class Bank {

    static private Manager manager = new Manager("John Doe", "123456");
    static private ArrayList<Customer> customers = new ArrayList();

    public Bank() {
        persist();
        new Login(this);
    }

    public Manager getManager() {
        return manager;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void persist() {

    }

    public void managerHandler() {
        
    }

    public void userHandler() {
        
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
    }

}