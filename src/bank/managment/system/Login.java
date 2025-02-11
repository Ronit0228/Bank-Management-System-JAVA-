package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {

    JLabel HeadingLabel, CardNoLabel, PinNoLabel;
    JTextField CardNoTextField;
    JPasswordField PasswordNoField;
    JButton SignInButton, SignUpButton, ClearButton;

    Login(){
        super("Bank Management System");

        ImageIcon BankMainImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image BankMainImage2 = BankMainImage1.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
        ImageIcon BankMainImage3 = new ImageIcon(BankMainImage2);
        JLabel BankMainImage = new JLabel(BankMainImage3);
        BankMainImage.setBounds(700,10,130,130);
        add(BankMainImage);

        ImageIcon HandMainImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image HandMainImage2 = HandMainImage1.getImage().getScaledInstance(130,130, Image.SCALE_DEFAULT);
        ImageIcon HandMainImage3 = new ImageIcon(HandMainImage2);
        JLabel HandMainImage = new JLabel(HandMainImage3);
        HandMainImage.setBounds(1350, 675,130, 130);
        add(HandMainImage);

        HeadingLabel = new JLabel("Welcome the GROW Bank");
        HeadingLabel.setForeground(Color.WHITE);
        HeadingLabel.setFont(new Font("AvantGarde", Font.BOLD, 50));
        HeadingLabel.setBounds(440, 160, 700, 50);
        add(HeadingLabel);

        CardNoLabel = new JLabel("Card Number  : ");
        CardNoLabel.setForeground(Color.WHITE);
        CardNoLabel.setFont(new Font("Raleway", Font.BOLD, 30));
        CardNoLabel.setBounds(400, 300, 300, 40);
        add(CardNoLabel);

        CardNoTextField = new JTextField(15);
        CardNoTextField.setBounds(700, 305, 400, 35);
        CardNoTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(CardNoTextField);

        PinNoLabel = new JLabel("Pin Number  : ");
        PinNoLabel.setForeground(Color.WHITE);
        PinNoLabel.setFont(new Font("Raleway", Font.BOLD, 30));
        PinNoLabel.setBounds(400, 400, 300, 40);
        add(PinNoLabel);

        PasswordNoField = new JPasswordField(15);
        PasswordNoField.setBounds(700, 405, 400, 35);
        PasswordNoField.setFont(new Font("Arial", Font.BOLD, 15));
        add(PasswordNoField);

        SignInButton = new JButton("SIGN IN");
        SignInButton.setBackground(Color.BLACK);
        SignInButton.setForeground(Color.WHITE);
        SignInButton.setFont(new Font("Arial", Font.BOLD, 15 ));
        SignInButton.setBounds(400, 550, 200, 35);
        SignInButton.addActionListener(this);
        add(SignInButton);

        SignUpButton = new JButton("SIGN UP");
        SignUpButton.setBackground(Color.BLACK);
        SignUpButton.setForeground(Color.WHITE);
        SignUpButton.setFont(new Font("Arial", Font.BOLD, 15 ));
        SignUpButton.setBounds(650, 550, 200, 35);
        SignUpButton.addActionListener(this);
        add(SignUpButton);

        ClearButton = new JButton("CLEAR");
        ClearButton.setBackground(Color.BLACK);
        ClearButton.setForeground(Color.WHITE);
        ClearButton.setFont(new Font("Arial", Font.BOLD, 15 ));
        ClearButton.setBounds(900, 550, 200, 35);
        ClearButton.addActionListener(this);
        add(ClearButton);


        ImageIcon BackGroundImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/backGround.png"));
        Image BackGroundImage2 = BackGroundImage1.getImage().getScaledInstance(1550, 900, Image.SCALE_DEFAULT);
        ImageIcon BackGroundImage3 = new ImageIcon(BackGroundImage2);
        JLabel BackGroundImage = new JLabel(BackGroundImage3);
        BackGroundImage.setBounds(0, 0, 1550,900);
        add(BackGroundImage);


        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event){
        try{
            if(event.getSource() == SignInButton) {
                String CardNumberDB = CardNoTextField.getText();
                String PasswordDB = new String(PasswordNoField.getPassword());
                try {
                    Connections LoginGetDetailsConnections = new Connections();
                    String GetDetailsQuery = "select * from login where card_number = '"+CardNumberDB+"' and pin_number = '"+PasswordDB+"' ";
                    ResultSet resultSet = LoginGetDetailsConnections.statement.executeQuery(GetDetailsQuery);

                    if(resultSet.next()){
                        setVisible(false);
                        new MainAtm(PasswordDB);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                    }
                } catch(SQLException sqlException){
                    throw new RuntimeException(sqlException);
                }

            } else if(event.getSource() == SignUpButton) {
                new SignUP1();
                setVisible(false);
            } else if(event.getSource() == ClearButton) {
                CardNoTextField.setText("");
                PasswordNoField.setText("");
            }
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}