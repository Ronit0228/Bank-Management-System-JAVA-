package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JTextField WithdrawEnterAmountTextField;
    JButton WithdrawBackButton, WithdrawButton;
    JPasswordField WithdrawPassField;

    String pinNums;
    Withdraw(String pinNum) {
        super("Withdraw Amount");

        this.pinNums = pinNum;

        JLabel WithdrawLabel = new JLabel("WITHDRAW");
        WithdrawLabel.setBounds(680, 10, 200, 30);
        WithdrawLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(WithdrawLabel);

        ImageIcon BankImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image BankImage2 = BankImage1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon BankImage3 = new ImageIcon(BankImage2);
        JLabel BankImage = new JLabel(BankImage3);
        BankImage.setBounds(660,50,130,130);
        add(BankImage);

        JLabel EnterPinLabel = new JLabel("ENTER YOUR PIN : ");
        EnterPinLabel.setBounds(430, 250, 300, 30);
        EnterPinLabel.setFont(new Font("System", Font.BOLD, 23));
        add(EnterPinLabel);

        WithdrawPassField = new JPasswordField(10);
        WithdrawPassField.setBounds(430, 290, 400, 30);
        WithdrawPassField.setFont(new Font("System", Font.BOLD, 17));
        add(WithdrawPassField);

        JLabel EnterWithdrawAmountLabel = new JLabel("ENTER WITHDRAW AMOUNT");
        EnterWithdrawAmountLabel.setBounds(430, 370, 400, 30);
        EnterWithdrawAmountLabel.setFont(new Font("System", Font.BOLD, 23));
        add(EnterWithdrawAmountLabel);

        JLabel WithdrawInformationNoteLabel = new JLabel("( Please Double Check Your Amount before Click the Withdraw Button. )");
        WithdrawInformationNoteLabel.setBounds(430, 410, 800, 20);
        WithdrawInformationNoteLabel.setFont(new Font("Arial", Font.BOLD, 15));
        WithdrawInformationNoteLabel.setForeground(Color.red);
        add(WithdrawInformationNoteLabel);

        JLabel WithdrawInformationNote2Label = new JLabel("( Maximum Withdrawal Amount is 30,000. )");
        WithdrawInformationNote2Label.setBounds(430, 440, 800, 20);
        WithdrawInformationNote2Label.setFont(new Font("Arial", Font.BOLD, 15));
        WithdrawInformationNote2Label.setForeground(Color.red);
        add(WithdrawInformationNote2Label);

        WithdrawEnterAmountTextField = new JTextField();
        WithdrawEnterAmountTextField.setBounds(430,480,500, 30);
        WithdrawEnterAmountTextField.setFont(new Font("System", Font.BOLD, 20));
        WithdrawEnterAmountTextField.setForeground(Color.red);
        add(WithdrawEnterAmountTextField);

        WithdrawBackButton = new JButton("BACK");
        WithdrawBackButton.setBounds(470,700,200,35);
        WithdrawBackButton.setFont(new Font("Raleway", Font.BOLD, 15));
        WithdrawBackButton.setBackground(Color.BLACK);
        WithdrawBackButton.setForeground(Color.WHITE);
        WithdrawBackButton.addActionListener(this);
        add(WithdrawBackButton);

        WithdrawButton = new JButton("WITHDRAW");
        WithdrawButton.setBounds(780,700,200,35);
        WithdrawButton.setFont(new Font("Raleway", Font.BOLD, 15));
        WithdrawButton.setBackground(Color.BLACK);
        WithdrawButton.setForeground(Color.WHITE);
        WithdrawButton.addActionListener(this);
        add(WithdrawButton);

        RectangleBox panel = new RectangleBox();
        add(panel);

        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static class RectangleBox extends JPanel {
        protected void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.setStroke(new BasicStroke(5));

            g.setColor(Color.BLACK);
            g.drawRect(400, 50, 700, 730);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == WithdrawButton) {
            String PasswordDB = new String (WithdrawPassField.getPassword());
            String WithdrawalAmountDB = WithdrawEnterAmountTextField.getText();
            Date WithdrawalDate = new Date();
            try{
                if(WithdrawalAmountDB.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Enter the Withdrawal Amount.");
                } else {
                    Connections WithdrawConnection = new Connections();
                    try{
                        ResultSet WithdrawResultSet = WithdrawConnection.statement.executeQuery("select * from bank where pin = '"+pinNums+"'");

                        if(pinNums.equals(PasswordDB)){
                            int Balance = 0;
                            while(WithdrawResultSet.next()){
                                if(WithdrawResultSet.getString("type").equals("Deposit")){
                                    Balance += Integer.parseInt(WithdrawResultSet.getString("amount_deposit"));
                                } else {
                                    Balance -= Integer.parseInt(WithdrawResultSet.getString("amount_deposit"));
                                }
                            }
                            if((Balance < Integer.parseInt(WithdrawalAmountDB))) {
                                JOptionPane.showMessageDialog(null, "Insufficient Balance in Your Account.");
                            }

                            WithdrawConnection.statement.executeUpdate("insert into bank values('"+pinNums+"', '"+WithdrawalDate+"', 'Withdrawal', '"+WithdrawalAmountDB+"')");
                            JOptionPane.showMessageDialog(null, "Rs." +WithdrawalAmountDB+ " " + "Debit Successfully");
                            setVisible(false);
                            new MainAtm(pinNums);
                        } else{
                            JOptionPane.showMessageDialog(null, "Enter the Correct Pin");
                        }
                    } catch (SQLException sqlException){
                        throw new RuntimeException(sqlException);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(actionEvent.getSource() == WithdrawBackButton) {
            new MainAtm(pinNums);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
