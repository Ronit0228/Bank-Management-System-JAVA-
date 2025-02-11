package bank.managment.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;


public class SignUP1 extends JFrame implements ActionListener {
    int FourDigitNumber = (int) (Math.random() * 9000) + 1000;
    String ApplicationRandomFormNumber = String.valueOf(FourDigitNumber);

    JRadioButton MaleRadioButton, FemaleRadioButton, OtherRadioButton, MarriedRadioButton, UnmarriedRadioButton;
    JDateChooser DateOfBirthChooser;
    JTextField NameTextField, FathersNameTextField, EmailTextField, AddressTextField, CityTextField, PinTextField, StateTextField;
    JButton NextPageButton, ClearButton;
    ButtonGroup buttonGroupOfGender, buttonGroupOfMarriedStatus;

    public SignUP1(){

        super("APPLICATION FORM");

        ImageIcon BankImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image BankImage2 = BankImage1.getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT);
        ImageIcon BankImage3 = new ImageIcon(BankImage2);
        JLabel BankImage = new JLabel(BankImage3);
        BankImage.setBounds(250,0,130,130);
        add(BankImage);

        JLabel ApplicationNoText = new JLabel("APPLICATION FORM NUMBER" + " " + ApplicationRandomFormNumber);
        ApplicationNoText.setBounds(400, 40, 800, 40);
        ApplicationNoText.setFont(new Font("Raleway", Font.BOLD, 40));
        add(ApplicationNoText);

        JLabel PersonalDetails = new JLabel("Person Details");
        PersonalDetails.setBounds(600, 100, 300, 30);
        PersonalDetails.setFont(new Font("Arial", Font.BOLD, 25));
        add(PersonalDetails);

        JLabel NameLabel = new JLabel("Name : ");
        NameLabel.setBounds(300, 160, 250, 35);
        NameLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(NameLabel);

        NameTextField = new JTextField();
        NameTextField.setBounds(600, 165, 500, 30);
        NameTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(NameTextField);

        JLabel FatherName = new JLabel("Father's Name : ");
        FatherName.setBounds(300,210, 250, 35);
        FatherName.setFont(new Font("Arail", Font.BOLD, 25));
        add(FatherName);

        FathersNameTextField = new JTextField();
        FathersNameTextField.setBounds(600,215, 500, 30);
        FathersNameTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(FathersNameTextField);

        JLabel DateOfBirth = new JLabel("Date Of Birth : ");
        DateOfBirth.setBounds(300, 260, 250, 35);
        DateOfBirth.setFont(new Font("Arial", Font.BOLD, 25));
        add(DateOfBirth);

        DateOfBirthChooser = new JDateChooser();
        DateOfBirthChooser.setForeground(new Color(105,105, 105));
        DateOfBirthChooser.setBounds(600, 265,500, 30);
        add(DateOfBirthChooser);

        JLabel GenderLabel = new JLabel("Gender");
        GenderLabel.setBounds(300, 310, 250, 35);
        GenderLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(GenderLabel);

        MaleRadioButton = new JRadioButton("Male");
        MaleRadioButton.setBounds(600, 310, 100, 35);
        MaleRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
        MaleRadioButton.setBackground(new Color(222, 255, 228));
        add(MaleRadioButton);

        FemaleRadioButton = new JRadioButton("Female");
        FemaleRadioButton.setBounds(780, 310, 150, 35);
        FemaleRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
        FemaleRadioButton.setBackground(new Color(222, 255, 228));
        add(FemaleRadioButton);

        OtherRadioButton = new JRadioButton("Other");
        OtherRadioButton.setBounds(1000, 310, 100, 35);
        OtherRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
        OtherRadioButton.setBackground(new Color(222, 255, 228));
        add(OtherRadioButton);

        buttonGroupOfGender = new ButtonGroup();
        buttonGroupOfGender.add(MaleRadioButton);
        buttonGroupOfGender.add(FemaleRadioButton);
        buttonGroupOfGender.add(OtherRadioButton);

        JLabel EmailLabel = new JLabel("Email Address : ");
        EmailLabel.setBounds(300, 360, 250, 35);
        EmailLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(EmailLabel);

        EmailTextField = new JTextField();
        EmailTextField.setBounds(600, 365, 500, 30);
        EmailTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(EmailTextField);

        JLabel MarriedStatusLabel = new JLabel("Married Status : ");
        MarriedStatusLabel.setBounds(300, 410, 250, 35);
        MarriedStatusLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(MarriedStatusLabel);

        MarriedRadioButton = new JRadioButton("Married");
        MarriedRadioButton.setBounds(600, 410, 150, 35);
        MarriedRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
        MarriedRadioButton.setBackground(new Color(222, 255, 228));
        add(MarriedRadioButton);

        UnmarriedRadioButton = new JRadioButton("Unmarried");
        UnmarriedRadioButton.setBounds(780, 410, 150, 35);
        UnmarriedRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
        UnmarriedRadioButton.setBackground(new Color(222, 255, 228));
        add(UnmarriedRadioButton);

        buttonGroupOfMarriedStatus = new ButtonGroup();
        buttonGroupOfMarriedStatus.add(MarriedRadioButton);
        buttonGroupOfMarriedStatus.add(UnmarriedRadioButton);

        JLabel AddressLabel = new JLabel("Address : ");
        AddressLabel.setBounds(300, 460, 250, 35);
        AddressLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(AddressLabel);

        AddressTextField = new JTextField();
        AddressTextField.setBounds(600, 465, 500,30);
        AddressTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(AddressTextField);

        JLabel CityLabel = new JLabel("City : ");
        CityLabel.setBounds(300, 510, 250, 35);
        CityLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(CityLabel);

        CityTextField = new JTextField();
        CityTextField.setBounds(600, 515,500, 30);
        CityTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(CityTextField);

        JLabel PinLabel = new JLabel("Pin Code : ");
        PinLabel.setBounds(300, 560, 250, 35);
        PinLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(PinLabel);

        PinTextField = new JTextField();
        PinTextField.setBounds(600, 565, 500,30);
        PinTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(PinTextField);

        JLabel StateLabel = new JLabel("State : ");
        StateLabel.setBounds(300, 610, 250, 35);
        StateLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(StateLabel);

        StateTextField = new JTextField();
        StateTextField.setBounds(600, 615, 500,30);
        StateTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(StateTextField);

        ClearButton = new JButton("CLEAR");
        ClearButton.setBounds(300, 690, 100,35);
        ClearButton.setFont(new Font("Raleway", Font.BOLD, 15));
        ClearButton.setBackground(Color.BLACK);
        ClearButton.setForeground(Color.WHITE);
        ClearButton.addActionListener(this);
        add(ClearButton);

        NextPageButton = new JButton("NEXT");
        NextPageButton.setBounds(1000, 690, 100, 35);
        NextPageButton.setFont(new Font("Raleway", Font.BOLD, 15));
        NextPageButton.setBackground(Color.BLACK);
        NextPageButton.setForeground(Color.WHITE);
        NextPageButton.addActionListener(this);
        add(NextPageButton);

        setLayout(null);
        getContentPane().setBackground(new Color(222, 255, 228));
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == NextPageButton){

            String FormNumberDB = ApplicationRandomFormNumber;
            String nameDB = NameTextField.getText();
            String fatherNameDB = FathersNameTextField.getText();
            String DateOfBirthDB = ((JTextField) DateOfBirthChooser.getDateEditor().getUiComponent()).getText();

            String genderDB = null;
            if(MaleRadioButton.isSelected()) {
                genderDB = "Male";
            } else if(FemaleRadioButton.isSelected()) {
                genderDB = "Female";
            } else if (OtherRadioButton.isSelected()) {
                genderDB = "Other";
            }

            String emailDB = EmailTextField.getText();

            String marriedStatusDB = null;
            if(MaleRadioButton.isSelected()) {
                marriedStatusDB = "Married";
            }
            else if(UnmarriedRadioButton.isSelected()) {
                marriedStatusDB = "Unmarried";
            }

            String addressDB = AddressTextField.getText();
            String cityNameDB = CityTextField.getText();
            String pinCodeDB = PinTextField.getText();
            String stateNameDB = StateTextField.getText();

            try {
                if(NameTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Fill all the Details");
                } else {
                    Connections SignUPConnection1 = new Connections();
                    String signUp1Query = "insert into signup1 values('"+FormNumberDB+"', '"+nameDB+"', '"+fatherNameDB+"', '"+DateOfBirthDB+"', '"+genderDB+"', '"+emailDB+"', '"+marriedStatusDB+"', '"+addressDB+"', '"+cityNameDB+"', '"+pinCodeDB+"', '"+stateNameDB+"')";
                    try {
                        SignUPConnection1.statement.executeUpdate(signUp1Query);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    new SignUP2(ApplicationRandomFormNumber, nameDB, emailDB);
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(event.getSource() == ClearButton) {
            clearSelection();
        }
    }

    private void clearSelection() {
        JTextField[] textFieldsArray = {NameTextField, FathersNameTextField, EmailTextField, AddressTextField, CityTextField, PinTextField, StateTextField};

        for(JTextField textField : textFieldsArray) {
            textField.setText("");
        }

        buttonGroupOfGender.clearSelection();
        buttonGroupOfMarriedStatus.clearSelection();
        DateOfBirthChooser.setDate(null);
    }

    public static void main(String[] args) {
        new SignUP1();
    }
}