package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniStatement extends JFrame implements ActionListener {
    JPasswordField MiniStatementPasswordField;
    JButton CheckStatementButton, BackButton;

    String pinNums;
    MiniStatement(String pinNum){
        super("MINI STATEMENT");

        this.pinNums = pinNum;

        JLabel MiniStatementLabel = new JLabel("MINI STATEMENT");
        MiniStatementLabel.setBounds(660, 10, 200, 30);
        MiniStatementLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(MiniStatementLabel);

        ImageIcon BankImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image BankImage2 = BankImage1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon BankImage3 = new ImageIcon(BankImage2);
        JLabel BankImage = new JLabel(BankImage3);
        BankImage.setBounds(660,50,130,130);
        add(BankImage);

        JLabel MiniStatementInformationLabel = new JLabel("To Check the Statements, Enter the PIN.");
        MiniStatementInformationLabel.setBounds(430, 250, 500, 30);
        MiniStatementInformationLabel.setFont(new Font("System", Font.BOLD, 23));
        MiniStatementInformationLabel.setForeground(Color.red);
        add(MiniStatementInformationLabel);


        JLabel EnterPinLabel = new JLabel("ENTER YOUR PIN : ");
        EnterPinLabel.setBounds(430, 300, 300, 30);
        EnterPinLabel.setFont(new Font("System", Font.BOLD, 23));
        add(EnterPinLabel);

        MiniStatementPasswordField = new JPasswordField(10);
        MiniStatementPasswordField.setBounds(430, 340, 400, 30);
        MiniStatementPasswordField.setFont(new Font("System", Font.BOLD, 17));
        add(MiniStatementPasswordField);

        BackButton = new JButton("BACK");
        BackButton.setBounds(430,700,200,35);
        BackButton.setFont(new Font("Raleway", Font.BOLD, 15));
        BackButton.setBackground(Color.BLACK);
        BackButton.setForeground(Color.WHITE);
        BackButton.addActionListener(this);
        add(BackButton);

        CheckStatementButton = new JButton("CHECK STATEMENTS");
        CheckStatementButton.setBounds(790,700,250,35);
        CheckStatementButton.setFont(new Font("Raleway", Font.BOLD, 15));
        CheckStatementButton.setBackground(Color.BLACK);
        CheckStatementButton.setForeground(Color.WHITE);
        CheckStatementButton.addActionListener(this);
        add(CheckStatementButton);

        RectangleBox panel = new RectangleBox();
        add(panel);

        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == CheckStatementButton) {
            String EnterPasswordDB = new String(MiniStatementPasswordField.getPassword());
            if(pinNums.equals(EnterPasswordDB)){
                new MiniStatementDetails(pinNums);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect PIN.");
            }
        } else if(actionEvent.getSource() == BackButton){
            new MainAtm(pinNums);
            setVisible(false);
        }
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

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
