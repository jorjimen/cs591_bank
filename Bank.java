import java.util.*;

public class Bank {

    private static Bank single_instance = null; 
    static private Manager manager = new Manager("John Doe", "123456");
    static private ArrayList<Customer> customers = new ArrayList();

    private Bank() {
        persist();
        new Login(this);
    }

    public static Bank getInstance() {
        if (single_instance == null) {
            single_instance = new Bank(); 
        }
        single_instance.addCustomers();
        return single_instance;
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

    // a method to add a few customers to the bank to start off with 
    public void addCustomers() {
        Currency currency1 = new Dollar(120.00); 
        Currency currency2 = new Euro(140.00); 
        Currency currency3 = new Yen(160.00); 

        Customer customer1 = new Customer("Priya Kumari", "123", currency1);
        Customer customer2 = new Customer("Jorge Jimenez", "123", currency2); 
        Customer customer3 = new Customer("Ziyu Shen", "123", currency3); 

        customers.add(customer1); 
        customers.add(customer2); 
        customers.add(customer3); 
    }

}