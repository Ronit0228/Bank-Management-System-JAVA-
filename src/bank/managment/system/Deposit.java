package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField EnterAmountTextField;
    JButton DepositButton, BackButton;

    String pinNums;
    String email;    Deposit(String pinNum){
        super("Deposit to Bank");

        this.pinNums = pinNum;

        JLabel DepositLabel = new JLabel("DEPOSIT");
        DepositLabel.setBounds(680, 10, 200, 30);
        DepositLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(DepositLabel);

        ImageIcon BankImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image BankImage2 = BankImage1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon BankImage3 = new ImageIcon(BankImage2);
        JLabel BankImage = new JLabel(BankImage3);
        BankImage.setBounds(660,50,130,130);
        add(BankImage);

        JLabel EnterAmountLabel = new JLabel("ENTER AMOUNT TO DEPOSIT");
        EnterAmountLabel.setBounds(450, 250, 400, 30);
        EnterAmountLabel.setFont(new Font("System", Font.BOLD, 23));
        add(EnterAmountLabel);

        JLabel InformationNoteLabel = new JLabel("( Please Double Check Your Amount before Click the Deposit Button. )");
        InformationNoteLabel.setBounds(450, 290, 800, 20);
        InformationNoteLabel.setFont(new Font("Arial", Font.BOLD, 15));
        InformationNoteLabel.setForeground(Color.red);
        add(InformationNoteLabel);

        EnterAmountTextField = new JTextField();
        EnterAmountTextField.setBounds(450,340,500, 30);
        EnterAmountTextField.setFont(new Font("System", Font.BOLD, 20));
        EnterAmountTextField.setForeground(Color.red);
        add(EnterAmountTextField);

        BackButton = new JButton("BACK");
        BackButton.setBounds(470,700,200,35);
        BackButton.setFont(new Font("Raleway", Font.BOLD, 15));
        BackButton.setBackground(Color.BLACK);
        BackButton.setForeground(Color.WHITE);
        BackButton.addActionListener(this);
        add(BackButton);

        DepositButton = new JButton("DEPOSIT");
        DepositButton.setBounds(780,700,200,35);
        DepositButton.setFont(new Font("Raleway", Font.BOLD, 15));
        DepositButton.setBackground(Color.BLACK);
        DepositButton.setForeground(Color.WHITE);
        DepositButton.addActionListener(this);
        add(DepositButton);

        RectangleBox panel = new RectangleBox();
        add(panel);

        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == DepositButton) {
            String DepositAmountDB = EnterAmountTextField.getText();
            Date DepositDateDB = new Date();

            try {
                if(EnterAmountTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter the Deposit Amount.");
                } else {
                    Connections DepositConnection = new Connections();
                    try {
                        DepositConnection.statement.executeUpdate("Insert into bank values('"+pinNums+"', '"+DepositDateDB+"', 'Deposit', '"+DepositAmountDB+"')");
                        JOptionPane.showMessageDialog(null, "Rs. "+ DepositAmountDB + " " + "Deposit Successfully");
                        new MainAtm(pinNums, email);
                        setVisible(false);
                    } catch (SQLException sqlException){
                        throw new RuntimeException(sqlException);
                    }
                    setVisible(false);
                    new MainAtm(pinNums);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(event.getSource() == BackButton) {
            new MainAtm(pinNums);
            setVisible(false);
        }
    }

    public static class RectangleBox extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            Graphics2D g2 = (Graphics2D) graphics;
            g2.setStroke(new BasicStroke(5));

            graphics.setColor(Color.BLACK);
            graphics.drawRect(400, 50, 700, 730);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
