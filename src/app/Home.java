package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Home {
    public Home() {
        JFrame homeFrame = new JFrame("Workshop10 App");
        homeFrame.setBounds(100, 100, 400, 300);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.getContentPane().setLayout(new BorderLayout());
        
        JLabel lblWelcome = new JLabel("Welcome to the Workshop10 App", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
        homeFrame.getContentPane().add(lblWelcome, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        JButton btnSignIn = new JButton("Sign In");
        btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSignIn.setBackground(new Color(52, 152, 219));
        btnSignIn.setForeground(Color.BLACK);
        panel.add(btnSignIn);
        
        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSignUp.setBackground(new Color(46, 204, 113));
        btnSignUp.setForeground(Color.BLACK);
        panel.add(btnSignUp);
        
        homeFrame.getContentPane().add(panel, BorderLayout.SOUTH);
        homeFrame.setVisible(true);
        
        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.dispose();
                new LoginUI();
            }
        });
        
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.dispose();
                new RegistrationUI();
            }
        });
    }
    
   

}
