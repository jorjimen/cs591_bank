import java.util.*;
import java.io.*;

public class PersistanceHandler {

    public PersistanceHandler() {

    }

    public void saveState() {
        File index = new File("StoredData/");
        for (File file : index.listFiles()) {
            if (file != null) {
                if (file.isDirectory()) {
                    for (File inner : file.listFiles()) {
                        inner.delete();
                    }
                    file.delete();
                } else {
                    file.delete();
                }
            }
        }
        Bank bank = Bank.getInstance();
        Manager manager = bank.getManager();
        ArrayList<Customer> customers = bank.getCustomers();
        for (Customer customer : customers) {
            persistCustomer(customer);
        }
    }

    private void persistCustomer(Customer customer) {
        String path = "StoredData/" + customer.getUsername() + "_" + customer.getPassword();
        File file = new File(path);
        file.mkdir();
        String userInfoPath = path + "/accounts.txt";
        File userInfoFile = new File(userInfoPath);
        try {
            FileWriter writer = new FileWriter(userInfoFile);
            int count = 0;
            for (Account account : customer.getAccounts()) {
                writer.write("ACCOUNT " + Integer.toString(count) + "\n");
                writer.write(account.getAccountType() + " " + account.getCurrencyType() + "\n");
                writer.write(account.getAmount().getStringType() + " " + Double.toString(account.getAmount().getValue()) + "\n");
                writer.write("START TRANSACTIONS\n");
                for (Transaction transaction : account.getTransactions()) {
                    if (transaction instanceof Deposit) {
                        writer.write("deposit " + transaction.getValue().getStringType() + " " + Double.toString(transaction.getValue().getValue()) + " " + transaction.getDate().toString());
                    } else if (transaction instanceof Withdrawl) {
                        writer.write("withdrawl " + transaction.getValue().getStringType() + " " + Double.toString(transaction.getValue().getValue()) + " " + transaction.getDate().toString());
                    } else {
                        writer.write("transfer " + transaction.getValue().getStringType() + " " + Double.toString(transaction.getValue().getValue()) + " " + transaction.getDate().toString());
                    }
                    writer.write("\n");
                }
                writer.write("END TRANSACTIONS\n");
                writer.write("");
                count += 1;
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void loadState() {
        File[] files = new File("StoredData/").listFiles();
        for (File file : files) {
            if (!(file.getName().equals(".DS_Store"))) {
                Customer current_customer = new Customer(file.getName().split("_")[0], file.getName().split("_")[1], new Dollar(5));
                current_customer.getAccounts().remove(0);
                current_customer.accounts = parseAccounts(file, current_customer);
                Bank.getInstance().getCustomers().add(current_customer);
            }
        }
    }

    private ArrayList<Account> parseAccounts(File file, Customer customer) {
        ArrayList<Account> new_accounts = new ArrayList<Account>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getPath() + "/accounts.txt"));
            String data = reader.readLine();
            while (data != null) {
                data = reader.readLine();
                String[] split = data.split(" ");
                Account account = new CheckingAccount("dollar");
                switch (split[0]) {
                    case "checkings":
                        account = new CheckingAccount(split[1]);
                        break;
                    case "savings":
                        account = new SavingsAccount(split[1]);
                        break;
                    case "securities":
                        account = new SecuritiesAccount(split[1]);
                        break;
                    case "loans":
                        account = new LoanAccount(split[1]);
                        break;
                }
                data = reader.readLine();
                split = data.split(" ");
                Currency currentValue = new Dollar(1);
                switch (split[0]) {
                    case "dollar":
                        currentValue = new Dollar(Double.parseDouble(split[1]));
                        break;
                    case "euro":
                        currentValue = new Euro(Double.parseDouble(split[1]));
                        break;
                    case "yen":
                        currentValue = new Euro(Double.parseDouble(split[1]));
                        break;
                }
                account.setAmount(currentValue);
                data = reader.readLine();
                if (data.equals("START TRANSACTIONS")) {
                    data = reader.readLine();
                    while (!data.equals("END TRANSACTIONS")) {
                        Transaction transaction = parseTransaction(customer, account, data);
                        account.getTransactions().add(transaction);
                        data = reader.readLine();
                    }
                }
                data = reader.readLine();
                new_accounts.add(account);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        return new_accounts;
    }

    private Transaction parseTransaction(Customer customer, Account account, String line) {
        String[] split = line.split(" ");
        Currency currency = new Dollar(1);
        switch (split[1]) {
            case "dollar":
                currency = new Dollar(Double.parseDouble(split[2]));
                break;
            case "yen":
                currency = new Yen(Double.parseDouble(split[2]));
                break;
            case "euro":
                currency = new Euro(Double.parseDouble(split[2]));
                break;
        }
        if (split[0].equals("deposit")) {
            return new Deposit(account, customer, currency, new Date());
        } else if (split[0].equals("withdrawl")) {
            return new Withdrawl(account, customer, currency, new Date());
        } else {
            return new Transfer(account, customer, currency, new Date(), account);
        }
    }
}