package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class RegistrationUI {

    private JFrame frame;
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;

    

  
    RegistrationUI() {
        frame = new JFrame("Registration");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(44, 62, 80));

        JLabel lblTitle = new JLabel("User Registration");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblTitle.setBounds(150, 20, 250, 30);
        frame.getContentPane().add(lblTitle);

        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(Color.WHITE);
        lblName.setBounds(50, 80, 100, 25);
        frame.getContentPane().add(lblName);

        nameField = new JTextField();
        nameField.setBounds(150, 80, 250, 25);
        frame.getContentPane().add(nameField);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setBounds(50, 130, 100, 25);
        frame.getContentPane().add(lblEmail);

        emailField = new JTextField();
        emailField.setBounds(150, 130, 250, 25);
        frame.getContentPane().add(emailField);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBounds(50, 180, 100, 25);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 180, 250, 25);
        frame.getContentPane().add(passwordField);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(150, 240, 250, 30);
        btnRegister.setBackground(new Color(52, 152, 219));
        btnRegister.setForeground(Color.BLACK);
        btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
        frame.getContentPane().add(btnRegister);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

               
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            
                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Email cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } 

         
                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Password cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (password.length() < 6) {
                    JOptionPane.showMessageDialog(frame, "Password must be at least 6 characters long", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

              
//                System.out.println("Registered User Details:");
//                System.out.println("Name: " + name);
//                System.out.println("Email: " + email);
//                System.out.println("Password: " + password);
                
                ReturnedUser response = JDBC.registerUser(name, email,password);
                if(response.success==true) {
                	JOptionPane.showMessageDialog(frame, response.msg+": "+response.user.getEmail(), "Success", JOptionPane.INFORMATION_MESSAGE);
                	new LoginUI();
                	frame.dispose();
                	
                }else {
                	JOptionPane.showMessageDialog(frame, response.msg, "Error", JOptionPane.ERROR_MESSAGE);
                	nameField.setText("");
                	emailField.setText("");
                	passwordField.setText("");
                	
                	
                }
                
          
                
            }
        });
        frame.setVisible(true);
    }
	

    
}
