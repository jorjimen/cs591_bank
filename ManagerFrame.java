import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class ManagerFrame extends JFrame implements ActionListener {
    private Bank bank;
    private JPanel panel = new JPanel(new GridLayout(3, 1));
    private JLabel messageLabel = new JLabel("Service Select: "); 
    private JButton generateReport = new JButton("Generate Report");
    private JButton checkCustomer = new JButton("Check on a Customer"); 
    private JButton checkLoan = new JButton("Check Loan Requests"); 
    private JButton adjustStocks = new JButton("Adjust Stocks"); 
    private JButton logOut = new JButton("Log Out"); 

    public ManagerFrame(Bank bank) {
        this.bank = bank; 

        panel.add(messageLabel);
        panel.add(generateReport);
        panel.add(checkCustomer);
        panel.add(checkLoan);
        panel.add(adjustStocks);
        panel.add(logOut); 
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        generateReport.addActionListener(this);
        checkCustomer.addActionListener(this);
        checkLoan.addActionListener(this);
        adjustStocks.addActionListener(this);
        logOut.addActionListener(this);

        add(panel, BorderLayout.CENTER);
        setTitle("Bank Login");
        setSize(500, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == generateReport) {
            JOptionPane.showMessageDialog(rootPane, "Generate Report button clicked");
        } else if (ae.getSource() == checkCustomer) {
            JOptionPane.showMessageDialog(rootPane, "Check Customer button clicked");
        } else if (ae.getSource() == checkLoan) {
            JOptionPane.showMessageDialog(rootPane, "Check Loan button clicked");
        } else if (ae.getSource() == adjustStocks) {
            JOptionPane.showMessageDialog(rootPane, "Adjust Stocks button clicked");
        } else if (ae.getSource() == logOut) {
            JOptionPane.showMessageDialog(rootPane, "You have logged out.");
        }

    }

}