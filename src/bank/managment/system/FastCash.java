package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton FastCash100, FastCash500, FastCash1000, FastCash2000, FastCash5000, FastCash10000, FastCash15000, FastCash20000, FastCash30000, ExitButton;
    JPasswordField EnterPasswordField;
    String pinNums;

    FastCash(String pinNum){
        super("FAST CASH");

        this.pinNums = pinNum;

        JLabel FastCashLabel = new JLabel("FAST CASH");
        FastCashLabel.setBounds(690, 10, 200, 30);
        FastCashLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(FastCashLabel);

        ImageIcon BankImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image BankImage2 = BankImage1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon BankImage3 = new ImageIcon(BankImage2);
        JLabel BankImage = new JLabel(BankImage3);
        BankImage.setBounds(690,50,130,130);
        add(BankImage);

        JLabel EnterPasswordLabel = new JLabel("Enter the PIN : ");
        EnterPasswordLabel.setBounds(430, 210, 250, 30);
        EnterPasswordLabel.setFont(new Font("System", Font.BOLD, 20));
        add(EnterPasswordLabel);

        EnterPasswordField = new JPasswordField();
        EnterPasswordField.setBounds(600, 215, 300, 25);
        EnterPasswordField.setFont(new Font("System", Font.BOLD, 18));
        add(EnterPasswordField);

        JLabel SelectFastCashLabel = new JLabel("Please Select Your Fast Cash Transaction Amount : ");
        SelectFastCashLabel.setBounds(430, 300, 500, 30);
        SelectFastCashLabel.setFont(new Font("System", Font.BOLD, 20));
        add(SelectFastCashLabel);

        JLabel FastCashInformationLabel = new JLabel("( Please Press the Correct Amount Button. )");
        FastCashInformationLabel.setBounds(430, 335, 500, 20);
        FastCashInformationLabel.setFont(new Font("System", Font.BOLD, 15));
        FastCashInformationLabel.setForeground(Color.red);
        add(FastCashInformationLabel);

        FastCash100 = new JButton("Rs. 100");
        FastCash100.setBounds(430, 390, 200, 35);
        FastCash100.setFont(new Font("Raleway", Font.BOLD, 15));
        FastCash100.setBackground(new Color(65,125,128));
        FastCash100.setForeground(Color.WHITE);
        FastCash100.addActionListener(this);
        add(FastCash100);

        FastCash500 = new JButton("Rs. 500");
        FastCash500.setBounds(650, 390, 200, 35);
        FastCash500.setFont(new Font("Raleway", Font.BOLD, 15));
        FastCash500.setBackground(new Color(65,125,128));
        FastCash500.setForeground(Color.WHITE);
        FastCash500.addActionListener(this);
        add(FastCash500);

        FastCash1000 = new JButton("Rs. 1000");
        FastCash1000.setBounds(870, 390, 200, 35);
        FastCash1000.setFont(new Font("Raleway", Font.BOLD, 15));
        FastCash1000.setBackground(new Color(65,125,128));
        FastCash1000.setForeground(Color.WHITE);
        FastCash1000.addActionListener(this);
        add(FastCash1000);

        FastCash2000 = new JButton("Rs. 2000");
        FastCash2000.setBounds(430, 460, 200, 35);
        FastCash2000.setFont(new Font("Raleway", Font.BOLD, 15));
        FastCash2000.setBackground(new Color(65,125,128));
        FastCash2000.setForeground(Color.WHITE);
        FastCash2000.addActionListener(this);
        add(FastCash2000);

        FastCash5000 = new JButton("Rs. 5000");
        FastCash5000.setBounds(650, 460, 200, 35);
        FastCash5000.setFont(new Font("Raleway", Font.BOLD, 15));
        FastCash5000.setBackground(new Color(65,125,128));
        FastCash5000.setForeground(Color.WHITE);
        FastCash5000.addActionListener(this);
        add(FastCash5000);

        FastCash10000 = new JButton("Rs. 10000");
        FastCash10000.setBounds(870, 460, 200, 35);
        FastCash10000.setFont(new Font("Raleway", Font.BOLD, 15));
        FastCash10000.setBackground(new Color(65,125,128));
        FastCash10000.setForeground(Color.WHITE);
        FastCash10000.addActionListener(this);
        add(FastCash10000);

        FastCash15000 = new JButton("Rs. 15000");
        FastCash15000.setBounds(430, 530, 200, 35);
        FastCash15000.setFont(new Font("Raleway", Font.BOLD, 15));
        FastCash15000.setBackground(new Color(65,125,128));
        FastCash15000.setForeground(Color.WHITE);
        FastCash15000.addActionListener(this);
        add(FastCash15000);

        FastCash20000 = new JButton("Rs. 20000");
        FastCash20000.setBounds(650, 530, 200, 35);
        FastCash20000.setFont(new Font("Raleway", Font.BOLD, 15));
        FastCash20000.setBackground(new Color(65,125,128));
        FastCash20000.setForeground(Color.WHITE);
        FastCash20000.addActionListener(this);
        add(FastCash20000);

        FastCash30000 = new JButton("Rs. 30000");
        FastCash30000.setBounds(870, 530, 200, 35);
        FastCash30000.setFont(new Font("Raleway", Font.BOLD, 15));
        FastCash30000.setBackground(new Color(65,125,128));
        FastCash30000.setForeground(Color.WHITE);
        FastCash30000.addActionListener(this);
        add(FastCash30000);

        ExitButton = new JButton("EXIT");
        ExitButton.setBounds(870, 700, 200, 35);
        ExitButton.setFont(new Font("Raleway", Font.BOLD, 15));
        ExitButton.setBackground(Color.BLACK);
        ExitButton.setForeground(Color.WHITE);
        ExitButton.addActionListener(this);
        add(ExitButton);

        FastCash.RectangleBox panel = new FastCash.RectangleBox();
        add(panel);

        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){

        JButton[] WithdrawButtons = {FastCash100, FastCash500, FastCash1000, FastCash2000, FastCash5000, FastCash10000, FastCash15000, FastCash20000, FastCash30000};

        if(actionEvent.getSource() == ExitButton) {
            new MainAtm(pinNums);
            setVisible(false);
        } else {
            String PasswordDB = new String(EnterPasswordField.getPassword());
            String FastWithdrawAmount = ((JButton)actionEvent.getSource()).getText().substring(4);
            Date FastCashWithdrawDate = new Date();

            Connections FastCashConnection = new Connections();
            try {
                ResultSet FastCashResultSet = FastCashConnection.statement.executeQuery("select * from bank where pin = '"+pinNums+"'");

                if(pinNums.equals(PasswordDB)){
                    int Balance = 0;
                    while (FastCashResultSet.next()){
                        if(FastCashResultSet.getString("type").equals("Deposit")){
                            Balance += Integer.parseInt(FastCashResultSet.getString("amount_deposit"));
                        } else {
                            Balance -= Integer.parseInt(FastCashResultSet.getString("amount_deposit"));
                        }
                    }

                    if(actionEvent.getSource()!= ExitButton && Balance < Integer.parseInt(FastWithdrawAmount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance in Your Account.");
                    }

                    FastCashConnection.statement.executeUpdate("Insert into bank values('"+pinNums+"', '"+FastCashWithdrawDate+"', 'Withdrawal', '"+FastWithdrawAmount+"')");
                    JOptionPane.showMessageDialog(null,"Rs." + FastWithdrawAmount + " " + "Debit Successfully");
                    new MainAtm(pinNums);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect PIN");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static class RectangleBox extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics){
            super.paintComponent(graphics);

            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.setStroke(new BasicStroke(5));

            graphics.setColor(Color.BLACK);
            graphics.drawRect(400, 50, 750, 730);

        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
