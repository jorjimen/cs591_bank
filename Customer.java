
public class Customer extends BankUser {

	// a method that prints all the info and details of the customer.
    public void printUserInfo(){
        System.out.println("Customer ID: " + id); 
        System.out.println("Customer name: " + username); 
        System.out.println("Customer password: " + password);
        System.out.println(); 
    }

}