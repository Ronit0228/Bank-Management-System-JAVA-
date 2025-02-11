package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ChangePin extends JFrame implements ActionListener {
    JPasswordField ChangePasswordField, ChangeRePasswordField, CurrentPasswordField;
    JButton ChangePinButton, ExitButton;

    String pinNums;
    ChangePin(String pinNum){
        super("CHANGE PIN");

        this.pinNums = pinNum;

        JLabel ChangeLabel = new JLabel("CHANGE PIN");
        ChangeLabel.setBounds(670, 10, 200, 30);
        ChangeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(ChangeLabel);

        ImageIcon BankImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image BankImage2 = BankImage1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon BankImage3 = new ImageIcon(BankImage2);
        JLabel BankImage = new JLabel(BankImage3);
        BankImage.setBounds(660,50,130,130);
        add(BankImage);

        JLabel ChangePinLabel = new JLabel("Change Your Pin");
        ChangePinLabel.setBounds(430, 230, 400, 30);
        ChangePinLabel.setFont(new Font("System", Font.BOLD, 23));
        add(ChangePinLabel);

        JLabel CurrentPinLabel = new JLabel("Current PIN : ");
        CurrentPinLabel.setBounds(430,300, 300, 30);
        CurrentPinLabel.setFont(new Font("System", Font.BOLD, 23));
        add(CurrentPinLabel);

        CurrentPasswordField = new JPasswordField();
        CurrentPasswordField.setBounds(730, 305, 300, 25);
        CurrentPasswordField.setFont(new Font("System", Font.BOLD, 20));
        add(CurrentPasswordField);

        JLabel EnterNewPin = new JLabel("Enter the New PIN : ");
        EnterNewPin.setBounds(430,380, 300, 30);
        EnterNewPin.setFont(new Font("System", Font.BOLD, 23));
        add(EnterNewPin);

        ChangePasswordField = new JPasswordField();
        ChangePasswordField.setBounds(730, 385, 300, 25);
        ChangePasswordField.setFont(new Font("System", Font.BOLD, 20));
        add(ChangePasswordField);

        JLabel ReEnterNewPin = new JLabel("Re-Enter the New PIN : ");
        ReEnterNewPin.setBounds(430,430, 300, 30);
        ReEnterNewPin.setFont(new Font("System", Font.BOLD, 23));
        add(ReEnterNewPin);

        ChangeRePasswordField = new JPasswordField();
        ChangeRePasswordField.setBounds(730, 435, 300, 25);
        ChangeRePasswordField.setFont(new Font("System", Font.BOLD, 20));
        add(ChangeRePasswordField);

        ExitButton = new JButton("BACK");
        ExitButton.setBounds(470,700,200,35);
        ExitButton.setFont(new Font("Raleway", Font.BOLD, 15));
        ExitButton.setBackground(Color.BLACK);
        ExitButton.setForeground(Color.WHITE);
        ExitButton.addActionListener(this);
        add(ExitButton);

        ChangePinButton = new JButton("CHANGE PIN");
        ChangePinButton.setBounds(780,700,200,35);
        ChangePinButton.setFont(new Font("Raleway", Font.BOLD, 15));
        ChangePinButton.setBackground(Color.BLACK);
        ChangePinButton.setForeground(Color.WHITE);
        ChangePinButton.addActionListener(this);
        add(ChangePinButton);

        RectangleBox panel = new RectangleBox();
        add(panel);

        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == ChangePinButton){
            try{
                String CurrentPasswordDB = new String(CurrentPasswordField.getPassword());
                String NewEnterPasswordDB = new String(ChangePasswordField.getPassword());
                String ReEnterPasswordDB = new String(ChangeRePasswordField.getPassword());
                Connections ChangePinConnection = new Connections();

                if(!NewEnterPasswordDB.equals(ReEnterPasswordDB)){
                    JOptionPane.showMessageDialog(null, "Enter PIN does not match.");
                    return;
                }

                if(new String(ChangePasswordField.getPassword()).isEmpty() && new String(ChangeRePasswordField.getPassword()).isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Enter the New PIN");
                    return;
                }

                if(pinNums.equals(CurrentPasswordDB)){
                    int FourDigitCheck = 4;
                    if(NewEnterPasswordDB.length() == FourDigitCheck){
                        String PinUpdateBankQuery = "update bank set pin = '"+NewEnterPasswordDB+"' where pin = '"+pinNums+"'";
                        String PinUpdateLoginQuery = "update login set pin_number = '"+NewEnterPasswordDB+"' where pin_number = '"+pinNums+"'";
                        String PinUpdateSignUP3 = "update signup3 set pin_no = '"+NewEnterPasswordDB+"' where pin_no = '"+pinNums+"'";

                        ChangePinConnection.statement.executeUpdate(PinUpdateBankQuery);
                        ChangePinConnection.statement.executeUpdate(PinUpdateLoginQuery);
                        ChangePinConnection.statement.executeUpdate(PinUpdateSignUP3);

                        JOptionPane.showMessageDialog(null, "PIN Changed Successfully.");
                        new MainAtm(pinNums);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Enter only Four Digit Number");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect PIN.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(actionEvent.getSource() == ExitButton){
            new MainAtm(pinNums);
            setVisible(false);
        }

    }

    public static class RectangleBox extends JPanel {
        protected void paintComponent(Graphics graphics){
            super.paintComponents(graphics);

            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.setStroke(new BasicStroke(5));

            graphics.setColor(Color.BLACK);
            graphics.drawRect(400, 50, 700, 730);
        }
    }

    public static void main(String[] args) {
        new ChangePin("");
    }
}
