package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel CurrentBalanceHeadingLabel, CurrentBalanceLabel;
    JButton MainPageButton;

    String pinNums;
    BalanceEnquiry(String pinNum){
        super("Balance Enquiry");

        this.pinNums = pinNum;

        JLabel BalanceEnquiryLabel = new JLabel("BALANCE ENQUIRY");
        BalanceEnquiryLabel.setBounds(660, 10, 200, 30);
        BalanceEnquiryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(BalanceEnquiryLabel);

        ImageIcon BankImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image BankImage2 = BankImage1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon BankImage3 = new ImageIcon(BankImage2);
        JLabel BankImage = new JLabel(BankImage3);
        BankImage.setBounds(660,50,130,130);
        add(BankImage);

        CurrentBalanceHeadingLabel = new JLabel("Your Current Balance is : ");
        CurrentBalanceHeadingLabel.setBounds(430, 250, 300, 30);
        CurrentBalanceHeadingLabel.setFont(new Font("System", Font.BOLD, 23));
        add(CurrentBalanceHeadingLabel);

        CurrentBalanceLabel = new JLabel();
        CurrentBalanceLabel.setBounds(430, 290, 400, 30);
        CurrentBalanceLabel.setFont(new Font("System", Font.BOLD, 20));
        CurrentBalanceLabel.setForeground(Color.red);
        add(CurrentBalanceLabel);

        int Balance = 0;
        try{
            Connections BalanceEnquiryConnection = new Connections();
            ResultSet BalanceEnquiryResultSet = BalanceEnquiryConnection.statement.executeQuery("select * from bank where pin = '"+pinNums+"'");
            while(BalanceEnquiryResultSet.next()){
                if(BalanceEnquiryResultSet.getString("type").equals("Deposit")){
                    Balance += Integer.parseInt(BalanceEnquiryResultSet.getString("amount_deposit"));
                } else {
                    Balance -= Integer.parseInt(BalanceEnquiryResultSet.getString("amount_deposit"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        CurrentBalanceLabel.setText("Rs." + " " + Balance);

        MainPageButton = new JButton("MAIN PAGE");
        MainPageButton.setBounds(800,700,200,35);
        MainPageButton.setFont(new Font("Raleway", Font.BOLD, 15));
        MainPageButton.setBackground(Color.BLACK);
        MainPageButton.setForeground(Color.WHITE);
        MainPageButton.addActionListener(this);
        add(MainPageButton);

        RectangleBox panel = new RectangleBox();
        add(panel);

        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        new MainAtm(pinNums);
        setVisible(false);
    }

    public static class RectangleBox extends JPanel{
        @Override
        protected void paintComponent(Graphics graphics){
            super.paintComponents(graphics);

            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.setStroke(new BasicStroke(5));

            graphics.setColor(Color.BLACK);
            graphics.drawRect(400, 50, 700, 730);
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
