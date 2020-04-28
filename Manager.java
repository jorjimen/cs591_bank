
import java.util.Date;

public class Manager extends BankUser {

	public Manager(String username, String password) {
        super(username, password);
    }

    // a method that prints all the info and details of the manager.
    public void printUserInfo(){
        System.out.println("Manager ID: " + super.getID()); 
        System.out.println("Manager name: " + super.getUsername()); 
        System.out.println("Manager password: " + super.getPassword());
        System.out.println(); 
    }

    // a method that shows the daily report on transactions for that day.
    public void showDailyReport(Date date){

    }

    
}