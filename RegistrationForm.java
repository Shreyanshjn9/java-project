import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RegistrationForm implements ActionListener {
    JFrame frame;
    JLabel nameLabel=new JLabel("Full Name");
    JLabel regnoLabel=new JLabel("Reg. No.");
    JLabel bookNameLabel=new JLabel("Book Name");
    JLabel issuedDateLabel=new JLabel("Issued Date");
    JLabel returnDateLabel=new JLabel("Return Date");
    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTF=new JTextField();
    JTextField regnoTF=new JTextField();
    JTextField bookNameTF=new JTextField();
    JTextField issuedDateTF=new JTextField();
    JTextField returnDateTF=new JTextField();
    JTextField emailTF=new JTextField();
    JButton resetButton=new JButton("RESET");
    JButton registerButton=new JButton("SUBMIT");
  

    RegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    
    public void createWindow()
    {
    	frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,680,900);
        frame.getContentPane().setBackground(Color.black);
        
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    
    public void setLocationAndSize()
    {
    	nameLabel.setBounds(150,20,40,50);
        regnoLabel.setBounds(150,70,80,50);
        bookNameLabel.setBounds(150,120,100,50);
        issuedDateLabel.setBounds(150,170,100,50);
        returnDateLabel.setBounds(150,220,140,50);
        emailLabel.setBounds(150,270,100,50);
        nameTF.setBounds(310,43,165,30);
        regnoTF.setBounds(310,93,165,30);
        bookNameTF.setBounds(310,143,165,30);
        issuedDateTF.setBounds(310,193,165,30);
        returnDateTF.setBounds(310,243,165,30);
        emailTF.setBounds(310,293,165,30);
        resetButton.setBounds(240,400,100,35);
        registerButton.setBounds(340,400,100,35);
    }
    
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        frame.add(regnoLabel);
        frame.add(bookNameLabel);
        frame.add(issuedDateLabel);
        frame.add(returnDateLabel);
        frame.add(emailLabel);
        frame.add(nameTF);
        frame.add(regnoTF);
        frame.add(bookNameTF);
        frame.add(issuedDateTF);
        frame.add(returnDateTF);
        frame.add(emailTF);
        frame.add(registerButton);
        frame.add(resetButton);
    }
    
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
        {
            try {
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","Chutiya123@");
                PreparedStatement Pstatement=connection.prepareStatement("insert into faculty values(?,?,?,?,?,?)");
                Pstatement.setString(1,nameTF.getText());
                Pstatement.setString(2,regnoTF.getText());
                Pstatement.setString(3,bookNameTF.getText());
                Pstatement.setString(4,issuedDateTF.getText());
                Pstatement.setString(5,returnDateTF.getText());
                Pstatement.setString(6,emailTF.getText());
                int i=Pstatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Thank You!");

            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        }
        if(e.getSource()==resetButton)
        {
        	nameTF.setText("");
            regnoTF.setText("");
            bookNameTF.setText("");
            issuedDateTF.setText("");
            returnDateTF.setText("");
            emailTF.setText("");
        }

    }
}