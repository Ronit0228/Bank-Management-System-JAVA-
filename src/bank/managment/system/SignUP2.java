package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUP2 extends JFrame implements ActionListener {
    JComboBox ReligionComboBox, CategoryComboBox, AnnualSalaryComoBox, EducationComboBox, OccupationComboBox;
    JTextField PanNumberTextField, AadhaarNumberTextField;
    JRadioButton YesCitizenRadioButton, NoCitizenRadioButton, YesExistingAccountRadioButton, NoExistingAccountRadioButton;
    ButtonGroup CitizenButtonGroup, ExistAccountButtonGroup;
    JButton NextPageButton, ClearButton;

    String FormNum;

    String name;
    String email;

    SignUP2(String FormNumber, String name, String email){
        super("APPLICATION FORM");

        this.name = name;
        this.email = email;

        ImageIcon BankImage1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image BankImage2 = BankImage1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon BankImage3 = new ImageIcon(BankImage2);
        JLabel BankImage = new JLabel(BankImage3);
        BankImage.setBounds(700,0,130,130);
        add(BankImage);

        JLabel AdditionalDetailsLabel = new JLabel("Additional Details");
        AdditionalDetailsLabel.setBounds(660, 130, 300, 30);
        AdditionalDetailsLabel.setFont(new Font("Raleway", Font.BOLD, 25));
        add(AdditionalDetailsLabel);

        this.FormNum = FormNumber;
        JLabel FormNumberLabel = new JLabel("Form Number : " + FormNum);
        FormNumberLabel.setBounds(1200, 20, 250, 30);
        FormNumberLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(FormNumberLabel);

        JLabel ReligionLabel = new JLabel("Religion : ");
        ReligionLabel.setBounds(300, 200, 250, 35);
        ReligionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(ReligionLabel);

        String[] ReligionNameOptions =  {"Choose", "Hindu", "Muslim", "Sikh", "Christian", "Other"};
        ReligionComboBox = new JComboBox(ReligionNameOptions);
        ReligionComboBox.setBounds(600, 205, 500, 30);
        ReligionComboBox.setFont(new Font("Raleway", Font.BOLD, 15));
        ReligionComboBox.setBackground(new Color(238, 215, 109));
        add(ReligionComboBox);

        JLabel CategoryLabel = new JLabel("Category : ");
        CategoryLabel.setBounds(300, 255, 250, 35);
        CategoryLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(CategoryLabel);

        String[] CategoryNameOptions =  {"Choose", "General", "OBC", "SC", "ST", "Other"};
        CategoryComboBox = new JComboBox(CategoryNameOptions);
        CategoryComboBox.setBounds(600, 260, 500, 30);
        CategoryComboBox.setFont(new Font("Raleway", Font.BOLD, 15));
        CategoryComboBox.setBackground(new Color(238, 215, 109));
        add(CategoryComboBox);

        JLabel IncomeLabel = new JLabel("Annual Income : ");
        IncomeLabel.setBounds(300, 310, 250, 35);
        IncomeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(IncomeLabel);

        String[] AnnualIncomeOptions = {"Choose", "Null", "Less than 1,50,000", "Less than 2,50,000", "5,00,000", "UpTo 10,00,00", "Above 10,00,000"};
        AnnualSalaryComoBox = new JComboBox(AnnualIncomeOptions);
        AnnualSalaryComoBox.setBounds(600, 305, 500,30);
        AnnualSalaryComoBox.setFont(new Font("Raleway", Font.BOLD,15));
        AnnualSalaryComoBox.setBackground(new Color(238, 215, 109));
        add(AnnualSalaryComoBox);

        JLabel EducationLabel = new JLabel("Education : ");
        EducationLabel.setBounds(300, 365, 250, 35);
        EducationLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(EducationLabel);

        String[] EductionOption = {"Choose" , "Secondary School Complete", "High School Complete", "Graduate", "Post Graduate", "Phd(Doctorate)"};
        EducationComboBox = new JComboBox(EductionOption);
        EducationComboBox.setBounds(600, 370, 500, 30);
        EducationComboBox.setFont(new Font("Raleway", Font.BOLD,15));
        EducationComboBox.setBackground(new Color(238, 215, 109));
        add(EducationComboBox);

        JLabel OccupationLabel = new JLabel("Occupation : ");
        OccupationLabel.setBounds(300, 420, 250, 35);
        OccupationLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(OccupationLabel);

        String[] OccupationOption = {"Choose" , "Salaried", "Self-Employed","Business", "Student", "Retired", "Other"};
        OccupationComboBox = new JComboBox(OccupationOption);
        OccupationComboBox.setBounds(600, 425, 500, 30);
        OccupationComboBox.setFont(new Font("Raleway", Font.BOLD,15));
        OccupationComboBox.setBackground(new Color(238, 215, 109));
        add(OccupationComboBox);

        JLabel AadhaarNumberLabel = new JLabel("Aadhaar Number : ");
        AadhaarNumberLabel.setBounds(300, 475, 250, 35);
        AadhaarNumberLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(AadhaarNumberLabel);

        AadhaarNumberTextField = new JTextField();
        AadhaarNumberTextField.setBounds(600, 480, 500, 30);
        AadhaarNumberTextField.setFont(new Font("Raleway", Font.BOLD,15));
        add(AadhaarNumberTextField);

        JLabel PanNumberLabel = new JLabel("Pan Number : ");
        PanNumberLabel.setBounds(300, 530, 250, 35);
        PanNumberLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(PanNumberLabel);

        PanNumberTextField = new JTextField();
        PanNumberTextField.setBounds(600, 535, 500, 30);
        PanNumberTextField.setFont(new Font("Raleway", Font.BOLD,15));
        add(PanNumberTextField);

        JLabel SeniorCitizenLabel = new JLabel("Senior Citizen : ");
        SeniorCitizenLabel.setBounds(300, 585, 250, 35);
        SeniorCitizenLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(SeniorCitizenLabel);

        YesCitizenRadioButton = new JRadioButton("Yes");
        YesCitizenRadioButton.setBounds(600, 590, 150, 30);
        YesCitizenRadioButton.setFont(new Font("Raleway", Font.BOLD,15));
        YesCitizenRadioButton.setBackground(new Color(238, 215, 109));
        add(YesCitizenRadioButton);

        NoCitizenRadioButton = new JRadioButton("No");
        NoCitizenRadioButton.setBounds(800, 590, 150, 30);
        NoCitizenRadioButton.setFont(new Font("Raleway", Font.BOLD,15));
        NoCitizenRadioButton.setBackground(new Color(238, 215, 109));
        add(NoCitizenRadioButton);

        CitizenButtonGroup = new ButtonGroup();
        CitizenButtonGroup.add(YesCitizenRadioButton);
        CitizenButtonGroup.add(NoCitizenRadioButton);

        JLabel ExistingAccountLabel = new JLabel("Existing Account : ");
        ExistingAccountLabel.setBounds(300, 640, 250, 35);
        ExistingAccountLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(ExistingAccountLabel);

        YesExistingAccountRadioButton = new JRadioButton("Yes");
        YesExistingAccountRadioButton.setBounds(600, 645, 150, 30);
        YesExistingAccountRadioButton.setFont(new Font("Raleway", Font.BOLD,15));
        YesExistingAccountRadioButton.setBackground(new Color(238, 215, 109));
        add(YesExistingAccountRadioButton);

        NoExistingAccountRadioButton = new JRadioButton("No");
        NoExistingAccountRadioButton.setBounds(800, 645, 150, 30);
        NoExistingAccountRadioButton.setFont(new Font("Raleway", Font.BOLD,15));
        NoExistingAccountRadioButton.setBackground(new Color(238, 215, 109));
        add(NoExistingAccountRadioButton);

        ExistAccountButtonGroup = new ButtonGroup();
        ExistAccountButtonGroup.add(YesExistingAccountRadioButton);
        ExistAccountButtonGroup.add(NoExistingAccountRadioButton);

        ClearButton = new JButton("CLEAR");
        ClearButton.setBounds(300, 700, 100,35);
        ClearButton.setFont(new Font("Raleway", Font.BOLD, 15));
        ClearButton.setBackground(Color.BLACK);
        ClearButton.setForeground(Color.WHITE);
        ClearButton.addActionListener(this);
        add(ClearButton);

        NextPageButton = new JButton("NEXT");
        NextPageButton.setBounds(1000, 700, 100, 35);
        NextPageButton.setFont(new Font("Raleway", Font.BOLD, 15));
        NextPageButton.setBackground(Color.BLACK);
        NextPageButton.setForeground(Color.WHITE);
        NextPageButton.addActionListener(this);
        add(NextPageButton);

        setLayout(null);
        getContentPane().setBackground(new Color(238, 215, 109));
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == NextPageButton){
            String FormNumberDB = FormNum;
            String ReligionDB = (String) ReligionComboBox.getSelectedItem();
            String CategoryDB = (String) CategoryComboBox.getSelectedItem();
            String AnnualIncomeDB = (String) AnnualSalaryComoBox.getSelectedItem();
            String EducationDB = (String) EducationComboBox.getSelectedItem();
            String OccupationDB = (String) OccupationComboBox.getSelectedItem();

            String AadhaarNumberDB = AadhaarNumberTextField.getText();
            String PanNumberDB = PanNumberTextField.getText();

            String SeniorCitizenDB = null;
            if(YesCitizenRadioButton.isSelected()) {
                SeniorCitizenDB = "Yes";
            } else if(NoCitizenRadioButton.isSelected()) {
                SeniorCitizenDB = "No";
            }

            String ExistingAccountDB = null;
            if(YesExistingAccountRadioButton.isSelected()){
                ExistingAccountDB = "Yes";
            } else if(NoExistingAccountRadioButton.isSelected()){
                ExistingAccountDB = "No";
            }

            try {
                if(AadhaarNumberTextField.getText().isEmpty() || PanNumberTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Fill all the Details");
                } else if(YesExistingAccountRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "If You have Account So You cannot make new Account");
                    return;
                } else {
                    Connections SignUPConnection2 = new Connections();
                    String SignUP2Query = "insert into signup2 values('"+FormNumberDB+"', '"+ReligionDB+"', '"+CategoryDB+"', '"+AnnualIncomeDB+"', '"+EducationDB+"', '"+OccupationDB+"', '"+AadhaarNumberDB+"', '"+PanNumberDB+"', '"+SeniorCitizenDB+"', '"+ExistingAccountDB+"')";
                    try {
                        SignUPConnection2.statement.executeUpdate(SignUP2Query);
                    } catch (SQLException sqlException){
                        throw new RuntimeException(sqlException);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            new SignUP3(FormNum, name, email);
            setVisible(false);

        } else if(event.getSource() == ClearButton){
            clearSection();
        }

    }

    private void clearSection(){
        JComboBox[] jComboBoxes = {ReligionComboBox, CategoryComboBox, AnnualSalaryComoBox, EducationComboBox, OccupationComboBox};
        for(JComboBox jComboBox : jComboBoxes){
            jComboBox.setSelectedIndex(0);
        }

        JTextField[] textFieldsArray = {PanNumberTextField, AadhaarNumberTextField};
        for(JTextField textField : textFieldsArray){
            textField.setText("");
        }
        CitizenButtonGroup.clearSelection();
        ExistAccountButtonGroup.clearSelection();
    }

    public static void main(String[] args) {
        new SignUP2("","","");
    }
}
