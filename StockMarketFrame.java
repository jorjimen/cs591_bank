import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class StockMarketFrame extends JFrame {
    private Bank bank; 
    private JTable table = new JTable();
    private JLabel titleLabel = new JLabel("Stock Market"); 
    private JPanel panel = new JPanel(new GridLayout(3, 1));

    public StockMarketFrame(Bank bank) {
        this.bank = bank; 
        String[] columns = new String[] {"NAME", "TICKER", "PRICE", "# SHARES"}; 
        Object[][] data = new Object[bank.getStockMarket().getStocks().size()][4]; 
        int i = 0; 
        for (Stock s : bank.getStockMarket().getStocks()) {
            data[i][0] = s.getName(); 
            data[i][1] = s.getTicker(); 
            data[i][2] = s.getCurrentPrice(); 
            data[i][3] = s.getVolume(); 
            i++; 
        }
        this.table = new JTable(data,columns); 
        panel.add(titleLabel); 
        panel.add(new JScrollPane(table)); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        add(panel, BorderLayout.CENTER); 
        setTitle("Stock Market Details"); 
        setSize(600, 500); 
        setVisible(true); 
        

    }
    
}