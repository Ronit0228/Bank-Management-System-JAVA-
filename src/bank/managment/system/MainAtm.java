package bank.managment.system;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAtm extends JFrame implements ActionListener {
    JButton DepositButton, CashWithdrawButton, FastCashButton, MiniStatementButton, PinChangeButton, BalanceEnquiryButton, ExitButton;

    String pinNums;
    public MainAtm(String pinNum){
        super("TRANSACTION");

        this.pinNums = pinNum;

        JLabel DepositLabel = new JLabel("TRANSACTION");
        DepositLabel.setBounds(680, 10, 200, 30);
        DepositLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(DepositLabel);

        ImageIcon BankImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image BankImage2 = BankImage1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon BankImage3 = new ImageIcon(BankImage2);
        JLabel BankImage = new JLabel(BankImage3);
        BankImage.setBounds(690,50,130,130);
        add(BankImage);

        JLabel SelectTransactionLabel = new JLabel("Please Select Your Transaction : ");
        SelectTransactionLabel.setBounds(430, 250, 400, 30);
        SelectTransactionLabel.setFont(new Font("System", Font.BOLD, 23));
        add(SelectTransactionLabel);

        DepositButton = new JButton("DEPOSIT");
        DepositButton.setBounds(430, 320, 200, 35);
        DepositButton.setFont(new Font("Raleway", Font.BOLD, 15));
        DepositButton.setBackground(new Color(65,125,128));
        DepositButton.setForeground(Color.WHITE);
        DepositButton.addActionListener(this);
        add(DepositButton);

        CashWithdrawButton = new JButton("CASH WITHDRAW");
        CashWithdrawButton.setBounds(650, 320, 200, 35);
        CashWithdrawButton.setFont(new Font("Raleway", Font.BOLD, 15));
        CashWithdrawButton.setBackground(new Color(65,125,128));
        CashWithdrawButton.setForeground(Color.WHITE);
        CashWithdrawButton.addActionListener(this);
        add(CashWithdrawButton);

        FastCashButton = new JButton("FAST CASH");
        FastCashButton.setBounds(870, 320, 200, 35);
        FastCashButton.setFont(new Font("Raleway", Font.BOLD, 15));
        FastCashButton.setBackground(new Color(65,125,128));
        FastCashButton.setForeground(Color.WHITE);
        FastCashButton.addActionListener(this);
        add(FastCashButton);

        MiniStatementButton = new JButton("MINI STATEMENT");
        MiniStatementButton.setBounds(430, 390, 200, 35);
        MiniStatementButton.setFont(new Font("Raleway", Font.BOLD, 15));
        MiniStatementButton.setBackground(new Color(65,125,128));
        MiniStatementButton.setForeground(Color.WHITE);
        MiniStatementButton.addActionListener(this);
        add(MiniStatementButton);

        PinChangeButton = new JButton("CHANGE PIN");
        PinChangeButton.setBounds(650, 390, 200, 35);
        PinChangeButton.setFont(new Font("Raleway", Font.BOLD, 15));
        PinChangeButton.setBackground(new Color(65,125,128));
        PinChangeButton.setForeground(Color.WHITE);
        PinChangeButton.addActionListener(this);
        add(PinChangeButton);

        BalanceEnquiryButton = new JButton("BALANCE ENQUIRY");
        BalanceEnquiryButton.setBounds(870, 390, 200, 35);
        BalanceEnquiryButton.setFont(new Font("Raleway", Font.BOLD, 15));
        BalanceEnquiryButton.setBackground(new Color(65,125,128));
        BalanceEnquiryButton.setForeground(Color.WHITE);
        BalanceEnquiryButton.addActionListener(this);
        add(BalanceEnquiryButton);

        ExitButton = new JButton("EXIT");
        ExitButton.setBounds(870, 700, 200, 35);
        ExitButton.setFont(new Font("Raleway", Font.BOLD, 15));
        ExitButton.setBackground(Color.BLACK);
        ExitButton.setForeground(Color.WHITE);
        ExitButton.addActionListener(this);
        add(ExitButton);

        MainAtm.RectangleBox panel = new MainAtm.RectangleBox();
        add(panel);

        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static class RectangleBox extends JPanel{
        @Override
        protected void paintComponent(Graphics graphics){
            super.paintComponent(graphics);

            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.setStroke(new BasicStroke(5));

            graphics.setColor(Color.BLACK);
            graphics.drawRect(400, 50, 750, 730);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == DepositButton) {
            new Deposit(pinNums);
            setVisible(false);
        } else if(actionEvent.getSource() == CashWithdrawButton) {
            new Withdraw(pinNums);
            setVisible(false);
        } else if(actionEvent.getSource() == FastCashButton) {
            new FastCash(pinNums);
            setVisible(false);
        } else if(actionEvent.getSource() == MiniStatementButton) {
            new MiniStatement(pinNums);
            setVisible(false);
        } else if(actionEvent.getSource() == PinChangeButton) {
            new ChangePin(pinNums);
            setVisible(false);
        } else  if(actionEvent.getSource() == BalanceEnquiryButton) {
            new BalanceEnquiry(pinNums);
            setVisible(false);
        } else if(actionEvent.getSource() == ExitButton){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new MainAtm("");
    }
}
