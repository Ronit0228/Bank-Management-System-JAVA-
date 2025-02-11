package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatementDetails extends JFrame implements ActionListener {
    JButton BackButton;

    String pinNums;

    MiniStatementDetails(String pinNum){
        super("MINI STATEMENTS DETAILS");

        this.pinNums = pinNum;

        JLabel MiniStatementDetailsLabel = new JLabel("MINI STATEMENT DETAILS");
        MiniStatementDetailsLabel.setBounds(620, 10, 300, 30);
        MiniStatementDetailsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(MiniStatementDetailsLabel);

        ImageIcon BankImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image BankImage2 = BankImage1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon BankImage3 = new ImageIcon(BankImage2);
        JLabel BankImage = new JLabel(BankImage3);
        BankImage.setBounds(580,50,130,130);
        add(BankImage);

        JLabel BankNameLabel = new JLabel("GROW BANK");
        BankNameLabel.setBounds(730, 100, 300, 35);
        BankNameLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(BankNameLabel);

        JLabel CardNumberLabel = new JLabel();
        CardNumberLabel.setBounds(430, 220, 600, 30);
        CardNumberLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(CardNumberLabel);

        JLabel StatementsLabel = new JLabel();
        StatementsLabel.setBounds(430, 280, 600, 370);
        StatementsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(StatementsLabel);

        JLabel TotalBalance = new JLabel();
        TotalBalance.setBounds(430, 660, 600, 25);
        TotalBalance.setFont(new Font("Arial", Font.BOLD, 18));
        add(TotalBalance);

        try {
            Connections MiniStatementDetailsConnection = new Connections();
            ResultSet MiniStatementResultSetFromLogin = MiniStatementDetailsConnection.statement.executeQuery("select * from login where pin_number = '"+pinNums+"'");

            while (MiniStatementResultSetFromLogin.next()){
                CardNumberLabel.setText("Card Number : " + MiniStatementResultSetFromLogin.getString("card_number"));
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        try {
            int Balance = 0;
            Connections MiniStatementDetailsConnection2 = new Connections();
            ResultSet MiniStatementResultSetFromBank = MiniStatementDetailsConnection2.statement.executeQuery("select * from bank where pin = '"+pinNums+"'");

            while(MiniStatementResultSetFromBank.next()){
                StatementsLabel.setText(StatementsLabel.getText() + "<html>"+MiniStatementResultSetFromBank.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+MiniStatementResultSetFromBank.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+MiniStatementResultSetFromBank.getString("amount_deposit")+ "<br><br><html>");

                if(MiniStatementResultSetFromBank.getString("type").equals("Deposit")){
                    Balance += Integer.parseInt(MiniStatementResultSetFromBank.getString("amount_deposit"));
                } else {
                    Balance -= Integer.parseInt(MiniStatementResultSetFromBank.getString("amount_deposit"));
                }
            }
            TotalBalance.setText("Total Balance is " + " " + Balance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        BackButton = new JButton("Back");
        BackButton.setBounds(800,700,200,35);
        BackButton.setFont(new Font("Raleway", Font.BOLD, 15));
        BackButton.setBackground(Color.BLACK);
        BackButton.setForeground(Color.WHITE);
        BackButton.addActionListener(this);
        add(BackButton);

        RectangleBox panel = new RectangleBox();
        add(panel);

        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);

    }

    public static class RectangleBox extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics){
            super.paintComponent(graphics);

            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.setStroke(new BasicStroke(5));

            graphics.setColor(Color.BLACK);
            graphics.drawRect(400, 50, 700, 730);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == BackButton) {
            new MainAtm(pinNums);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new MiniStatementDetails("");
    }
}
