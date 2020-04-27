
public class Manager extends BankUser {

	// a method that prints all the info and details of the manager.
    public void printUserInfo(){
        System.out.println("Manager ID: " + id); 
        System.out.println("Manager name: " + username); 
        System.out.println("Manager password: " + password);
        System.out.println(); 
    }

    // a method that shows the daily report on transactions for that day.
    public void showDailyReport(Date date){

    }

    
}