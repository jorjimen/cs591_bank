import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class ManagerFrame extends JFrame implements ActionListener {
    private Bank bank;
    private JPanel panel = new JPanel(new GridLayout(3, 1));
    private JLabel messageLabel = new JLabel("Service Select: "); 
    private JButton registerCustomer = new JButton("Register a New Customer"); 
    private JButton generateReport = new JButton("Generate Report");
    private JButton checkCustomer = new JButton("Check on a Customer"); 
    private JButton adjustStocks = new JButton("Adjust Stocks"); 
    private JButton advanceDate = new JButton("Advance Date");
    private JButton logOut = new JButton("Log Out"); 

    public ManagerFrame(Bank bank) {
        this.bank = bank; 

        panel.add(messageLabel);
        panel.add(registerCustomer); 
        panel.add(generateReport);
        panel.add(checkCustomer);
        panel.add(adjustStocks);
        panel.add(logOut); 
        panel.add(advanceDate);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        registerCustomer.addActionListener(this);
        generateReport.addActionListener(this);
        checkCustomer.addActionListener(this);
        adjustStocks.addActionListener(this);
        logOut.addActionListener(this);
        advanceDate.addActionListener(this);

        add(panel, BorderLayout.CENTER);
        setTitle("Manager Login");
        setSize(600, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == registerCustomer) { // done! 
            CustomerRegistrationFrame frame = new CustomerRegistrationFrame(bank); 
        } else if (ae.getSource() == generateReport) { // done! 
            generateBankReport(); 
        }else if (ae.getSource() == checkCustomer) { // done! 
            CustomerInfoFrame frame = new CustomerInfoFrame(bank); 
        } else if (ae.getSource() == adjustStocks) {
            ManagerStockFrame frame = new ManagerStockFrame(bank); 
        } else if (ae.getSource() == logOut) {
            JOptionPane.showMessageDialog(rootPane, "You have logged out.");
        } else if (ae.getSource() == advanceDate) {
            JOptionPane.showMessageDialog(rootPane, "Date has been advanced forward to " + Bank.date.toString());
            Bank.pushDate();
        }
    }

    public void generateBankReport() {
        StringBuilder str = new StringBuilder(); 
        str.append("BANK REPORT OF ALL TRANSACTIONS \n"); 
        str.append("Number of Customers: " + bank.getCustomers().size() + "\n\n"); 

        for (Customer c : bank.getCustomers()) {
            str.append("Customer: " + c.getUsername() + "\n"); 
            for (Transaction t : c.getAllTransactions()) {
                str.append(t.toString() + "\n"); 
            }
            str.append("\n\n"); 
        }

        PersistanceHandler p = new PersistanceHandler();
        p.persistReport(str.toString());
        JOptionPane.showMessageDialog(rootPane, str.toString());

    }

}