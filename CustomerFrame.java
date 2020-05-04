
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class CustomerFrame extends JFrame implements ActionListener {
    private Bank bank;
    private Customer customer; 
    private JPanel panel = new JPanel(new GridLayout(3, 1));
    private JLabel messageLabel = new JLabel("Service Select: "); 
    private JButton viewAccount = new JButton("View Account Details");
    private JButton deposit = new JButton("Make a Deposit"); 
    private JButton withdraw = new JButton("Make a Withdrawl"); 
    private JButton requestLoan = new JButton("Request a Loan"); 
    private JButton tradeStocks = new JButton("Trade Stocks"); 
    private JButton logOut = new JButton("Log Out"); 

    public CustomerFrame(Bank bank, Customer customer) {
        this.bank = bank; 
        this.customer = customer; 
        
        JLabel welcomeLabel = new JLabel("Welcome " + customer.getUsername() + "!"); 
        panel.add(welcomeLabel); 
        panel.add(messageLabel);
        panel.add(viewAccount);
        panel.add(deposit);
        panel.add(withdraw);
        panel.add(requestLoan);
        panel.add(tradeStocks);
        panel.add(logOut);  
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        viewAccount.addActionListener(this);
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        requestLoan.addActionListener(this);
        tradeStocks.addActionListener(this);
        logOut.addActionListener(this);

        add(panel, BorderLayout.CENTER);
        setTitle("Customer Login");
        setSize(500, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == viewAccount) {
            this.dispose();
            new CustomerAccountsFrame(this,customer);
        } else if (ae.getSource() == deposit) {
            JOptionPane.showMessageDialog(rootPane, "Deposit button clicked");
        } else if (ae.getSource() == withdraw) {
            JOptionPane.showMessageDialog(rootPane, "Withdraw button clicked");
        } else if (ae.getSource() == requestLoan) {
            JOptionPane.showMessageDialog(rootPane, "Request Loan button clicked");
        } else if (ae.getSource() == tradeStocks) {
            JOptionPane.showMessageDialog(rootPane, "Trade Stocks button clicked");
        } else if (ae.getSource() == logOut) {
            JOptionPane.showMessageDialog(rootPane, "You have logged out.");
        }

    }

}