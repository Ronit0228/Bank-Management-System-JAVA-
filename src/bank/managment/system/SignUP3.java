package bank.managment.system;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Properties;




public class SignUP3 extends JFrame implements ActionListener {
    JRadioButton SavingAccountRadioButton, FixedDepositAccountRadioButton, CurrentAccountRadioButton, RecurringDepositAccountRadioButton;
    ButtonGroup AccountTypeButtonGroup;
    JCheckBox ATMCardCheckBox, InternetBankingCheckBox, MobileBankingCheckBox, EmailAlertCheckBox, ChequeBookCheckBox, EStatementCheckBox, DetailAcceptanceCheckBox;
    JButton SubmitButton, CancelButton;

    int FourDigitNumber1 = (int) (Math.random() * 9000) + 1400;
    String FourEndDigitOfAccountNumber1 = String.valueOf(FourDigitNumber1);

    int FourDigitNumber2 = (int) (Math.random() * 9000) + 1500;
    String FourEndDigitOfAccountNumber2 = String.valueOf(FourDigitNumber2);

    int FourDigitNumber3 = (int) (Math.random() * 9000) + 1600;
    String FourEndDigitOfAccountNumber3 = String.valueOf(FourDigitNumber3);

    int FourDigitNumber4 = (int) (Math.random() * 9000) + 1200;
    String FourEndDigitOfAccountNumber4 = String.valueOf(FourDigitNumber4);

    String AccountNumber = FourEndDigitOfAccountNumber1 + "-" + FourEndDigitOfAccountNumber2 + "-" + FourEndDigitOfAccountNumber3 + "-" + FourEndDigitOfAccountNumber4;

    int FourDigitPinNumber = (int) (Math.random() * 9000) + 1000;
    String FourDigitPin = String.valueOf(FourDigitPinNumber);

    String PinNumber = FourDigitPin;

    String FormNums;

    String name;
    String email;

    SignUP3(String formNums, String name, String email){
        super("APPLICATION FORM");

        this.name = name;
        this.email = email;

        ImageIcon BankImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
            Image BankImage2 = BankImage1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
            ImageIcon BankImage3 = new ImageIcon(BankImage2);
            JLabel BankImage = new JLabel(BankImage3);
            BankImage.setBounds(700,0,130,130);
            add(BankImage);

            JLabel AdditionalDetailsLabel = new JLabel("Account Details");
            AdditionalDetailsLabel.setBounds(660, 130, 300, 30);
            AdditionalDetailsLabel.setFont(new Font("Raleway", Font.BOLD, 25));
            add(AdditionalDetailsLabel);

            this.FormNums = formNums;
            JLabel FormNumberLabel = new JLabel("Form Number : " + FormNums);
            FormNumberLabel.setBounds(1200, 20, 250, 30);
            FormNumberLabel.setFont(new Font("Raleway", Font.BOLD, 20));
            add(FormNumberLabel);

            JLabel AccountTypeLabel = new JLabel("Account Type : ");
            AccountTypeLabel.setBounds(300, 200, 250, 35);
            AccountTypeLabel.setFont(new Font("Arial", Font.BOLD, 25));
            add(AccountTypeLabel);

            SavingAccountRadioButton = new JRadioButton("Saving Account");
            SavingAccountRadioButton.setBounds(300, 230, 250, 30);
            SavingAccountRadioButton.setFont(new Font("Raleway", Font.BOLD,17));
            SavingAccountRadioButton.setBackground(new Color(215, 252, 252));
            add(SavingAccountRadioButton);

            FixedDepositAccountRadioButton = new JRadioButton("Fixed Deposit Account");
            FixedDepositAccountRadioButton.setBounds(700, 230, 250, 30);
            FixedDepositAccountRadioButton.setFont(new Font("Raleway", Font.BOLD,17));
            FixedDepositAccountRadioButton.setBackground(new Color(215, 252, 252));
            add(FixedDepositAccountRadioButton);

            CurrentAccountRadioButton = new JRadioButton("Current Account");
            CurrentAccountRadioButton.setBounds(300, 260, 250, 30);
            CurrentAccountRadioButton.setFont(new Font("Raleway", Font.BOLD,17));
            CurrentAccountRadioButton.setBackground(new Color(215, 252, 252));
            add(CurrentAccountRadioButton);

            RecurringDepositAccountRadioButton = new JRadioButton("Recurring Deposit Account");
            RecurringDepositAccountRadioButton.setBounds(700, 260, 250, 30);
            RecurringDepositAccountRadioButton.setFont(new Font("Raleway", Font.BOLD,17));
            RecurringDepositAccountRadioButton.setBackground(new Color(215, 252, 252));
            add(RecurringDepositAccountRadioButton);

            AccountTypeButtonGroup = new ButtonGroup();
            AccountTypeButtonGroup.add(SavingAccountRadioButton);
            AccountTypeButtonGroup.add(FixedDepositAccountRadioButton);
            AccountTypeButtonGroup.add(CurrentAccountRadioButton);
            AccountTypeButtonGroup.add(RecurringDepositAccountRadioButton);

            JLabel CardNumberLabel = new JLabel("Card Number : ");
            CardNumberLabel.setBounds(300, 320, 250, 35);
            CardNumberLabel.setFont(new Font("Arial", Font.BOLD, 25));
            add(CardNumberLabel);

            JLabel CardDigitNumberLabel = new JLabel(AccountNumber);
            CardDigitNumberLabel.setBounds(600, 320, 350, 35);
            CardDigitNumberLabel.setFont(new Font("Arial", Font.BOLD, 25));
            CardDigitNumberLabel.setForeground(Color.red);
            add(CardDigitNumberLabel);


            JLabel NumberDigitLabel = new JLabel("( Your 16-digit Card Number )");
            NumberDigitLabel.setBounds(300, 360, 250, 20);
            NumberDigitLabel.setFont(new Font("Arial", Font.BOLD, 12));
            add(NumberDigitLabel);

            JLabel NoteInformationOfCarLabel = new JLabel("( It would appear on the ATM Card / Cheque Book and Statements. )");
            NoteInformationOfCarLabel.setBounds(600, 360, 500, 20);
            NoteInformationOfCarLabel.setFont(new Font("Arial", Font.BOLD, 12));
            add(NoteInformationOfCarLabel);

            JLabel CardPinLabel = new JLabel("Pin : ");
            CardPinLabel.setBounds(300, 400, 250, 35);
            CardPinLabel.setFont(new Font("Arial", Font.BOLD, 25));
            add(CardPinLabel);

            JLabel CardPinShowLabel = new JLabel(PinNumber);
            CardPinShowLabel.setBounds(600, 400, 250, 35);
            CardPinShowLabel.setFont(new Font("Arial", Font.BOLD, 25));
            CardPinShowLabel.setForeground(Color.red);
            add(CardPinShowLabel);

            JLabel NoteInformationOfPin = new JLabel("( 4-Digit Password, Please don't share with anyone )");
            NoteInformationOfPin.setBounds(300, 440, 500, 20);
            NoteInformationOfPin.setFont(new Font("Arial", Font.BOLD, 12));
            add(NoteInformationOfPin);

            JLabel ServiceProvideLabel = new JLabel("Service Required : ");
            ServiceProvideLabel.setBounds(300, 480, 250, 35);
            ServiceProvideLabel.setFont(new Font("Arial", Font.BOLD, 25));
            add(ServiceProvideLabel);

            ATMCardCheckBox = new JCheckBox("ATM Card");
            ATMCardCheckBox.setBounds(300, 525, 150, 30);
            ATMCardCheckBox.setFont(new Font("Arial", Font.BOLD, 17));
            ATMCardCheckBox.setBackground(new Color(215, 252, 252));
            add(ATMCardCheckBox);

            InternetBankingCheckBox = new JCheckBox("Internet Banking");
            InternetBankingCheckBox.setBounds(500, 525, 200, 30);
            InternetBankingCheckBox.setFont(new Font("Arial", Font.BOLD, 17));
            InternetBankingCheckBox.setBackground(new Color(215, 252, 252));
            add(InternetBankingCheckBox);

            MobileBankingCheckBox = new JCheckBox("Mobile Banking");
            MobileBankingCheckBox.setBounds(750, 525, 200, 30);
            MobileBankingCheckBox.setFont(new Font("Arial", Font.BOLD, 17));
            MobileBankingCheckBox.setBackground(new Color(215, 252, 252));
            add(MobileBankingCheckBox);

            EmailAlertCheckBox = new JCheckBox("Email Alert");
            EmailAlertCheckBox.setBounds(300, 565, 200, 30);
            EmailAlertCheckBox.setFont(new Font("Arial", Font.BOLD, 17));
            EmailAlertCheckBox.setBackground(new Color(215, 252, 252));
            add(EmailAlertCheckBox);

            ChequeBookCheckBox = new JCheckBox("Cheque Book");
            ChequeBookCheckBox.setBounds(500, 565, 200, 30);
            ChequeBookCheckBox.setFont(new Font("Arial", Font.BOLD, 17));
            ChequeBookCheckBox.setBackground(new Color(215, 252, 252));
            add(ChequeBookCheckBox);

            EStatementCheckBox = new JCheckBox("E-Statements");
            EStatementCheckBox.setBounds(750, 565, 200, 30);
            EStatementCheckBox.setFont(new Font("Arial", Font.BOLD, 17));
            EStatementCheckBox.setBackground(new Color(215, 252, 252));
            add(EStatementCheckBox);

            DetailAcceptanceCheckBox = new JCheckBox("I here by declares that the above entered details correct to the best my knowledge.");
            DetailAcceptanceCheckBox.setBounds(300, 630, 700, 30);
            DetailAcceptanceCheckBox.setFont(new Font("Arial", Font.BOLD, 17));
            DetailAcceptanceCheckBox.setBackground(new Color(215, 252, 252));
            add(DetailAcceptanceCheckBox);

            CancelButton = new JButton("CANCEL");
            CancelButton.setBounds(500, 720, 100,35);
            CancelButton.setFont(new Font("Raleway", Font.BOLD, 15));
            CancelButton.setBackground(Color.BLACK);
            CancelButton.setForeground(Color.WHITE);
            CancelButton.addActionListener(this);
            add(CancelButton);

            SubmitButton = new JButton("SUBMIT");
            SubmitButton.setBounds(700, 720, 100, 35);
            SubmitButton.setFont(new Font("Raleway", Font.BOLD, 15));
            SubmitButton.setBackground(Color.BLACK);
            SubmitButton.setForeground(Color.WHITE);
            SubmitButton.addActionListener(this);
            add(SubmitButton);

            setLayout(null);
            getContentPane().setBackground(new Color(215, 252, 252));
            setExtendedState(MAXIMIZED_BOTH);
            setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource() == SubmitButton){
            if(DetailAcceptanceCheckBox.isSelected()){

                String FormNumberDB = FormNums;

                String AccountTypeDB = null;
                if(SavingAccountRadioButton.isSelected()) {
                    AccountTypeDB = "Saving Account";
                } else if(FixedDepositAccountRadioButton.isSelected()) {
                    AccountTypeDB = "Fixed Deposit Account";
                } else if(CurrentAccountRadioButton.isSelected()) {
                    AccountTypeDB = "Current Account";
                } else if(RecurringDepositAccountRadioButton.isSelected()) {
                    AccountTypeDB = "Recurring Deposit Account";
                }


                String AccountNumberDB = AccountNumber;
                String PinNumberDB = PinNumber;

                StringBuilder ServiceRequiredDB = new StringBuilder();
                if (ATMCardCheckBox.isSelected()) {
                    ServiceRequiredDB.append("ATM Card, ");
                }
                if (InternetBankingCheckBox.isSelected()) {
                    ServiceRequiredDB.append("Internet Banking, ");
                }
                if (MobileBankingCheckBox.isSelected()) {
                    ServiceRequiredDB.append("Mobile Banking, ");
                }
                if (EmailAlertCheckBox.isSelected()) {
                    ServiceRequiredDB.append("Email Alert, ");
                }
                if (ChequeBookCheckBox.isSelected()) {
                    ServiceRequiredDB.append("Cheque Book, ");
                }
                if (EStatementCheckBox.isSelected()) {
                    ServiceRequiredDB.append("E-Statement");
                }

                String services = ServiceRequiredDB.toString().replaceAll(", $", "");


                try{
                    if(AccountTypeButtonGroup.getSelection() == null){
                        JOptionPane.showMessageDialog(null, "Fill all the Details");
                    } else{
                        Connections SignUPConnection3 = new Connections();
                        String SignUP3Query = "Insert into signup3 values('"+FormNumberDB+"', '"+AccountTypeDB+"', '"+AccountNumberDB+"', '"+PinNumberDB+"', '"+services+"')";
                        String LoginQuery = "Insert into login values('"+FormNumberDB+"', '"+AccountNumberDB+"', '"+PinNumberDB+"')";
                        try{
                            SignUPConnection3.statement.executeUpdate(SignUP3Query);
                            SignUPConnection3.statement.executeUpdate(LoginQuery);
                        } catch (SQLException sqlException){
                            throw new RuntimeException(sqlException);
                        }

                        JOptionPane.showMessageDialog(null,"Card Number : " + AccountNumberDB + "\nPin : " + PinNumberDB);
                        new Deposit(PinNumberDB);
                        setVisible(false);

                        try {
                            sendEmail(name, AccountNumberDB, PinNumberDB, email, AccountTypeDB, FormNumberDB);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            } else{
                JOptionPane.showMessageDialog(null, "Check the Acceptance Check Box");
            }
        } else if(actionEvent.getSource() == CancelButton){
            ClearSection();
        }
    }

    private void sendEmail(String recipient, String accountNumber, String pin, String email, String accountType, String formNumber) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println("❌ ERROR: Email address is empty or null.");
            return;
        }

        String host = "smtp.gmail.com";
        final String user = "ronitkumar9987@gmail.com";
        final String password = "qhyn fyrg wxkb ttpv";
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            System.out.println("Recipient Email: " + email);

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Bank Account Details");

            String emailContent = "Dear Customer,\n\n" +
                    "Thank you for opening an account with us. Your account details are as follows:\n\n" +
                    "🔹 Form Number : " + formNumber + "\n" +
                    "🔹 User Name : " + recipient + "\n" +
                    "🔹 Registered Email : " + email + "\n" +
                    "🔹 Account Number : " + accountNumber + "\n" +
                    "🔹 Account Type : " + accountType + "\n" +
                    "🔹 PIN : " + pin + "\n\n" +
                    "Please keep this information safe.\n\n" +
                    "Best Regards,\nGrow Bank";

            message.setText(emailContent);
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }
    }

    private void ClearSection(){
        AccountTypeButtonGroup.clearSelection();

        JCheckBox[] jCheckBox = {ATMCardCheckBox, InternetBankingCheckBox, MobileBankingCheckBox, EmailAlertCheckBox, ChequeBookCheckBox, EStatementCheckBox, DetailAcceptanceCheckBox};
        for(JCheckBox jCheckBox1 : jCheckBox){
            jCheckBox1.setSelected(false);
        }

        new SignUP2(FormNums, "", "");
        setVisible(false);
    }
    public static void main(String[] args) {
        new SignUP3("","","");
    }
}
