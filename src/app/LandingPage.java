package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LandingPage {

    public LandingPage(int id,String name, String email) {
        JFrame helloFrame = new JFrame("Dashboard");
        helloFrame.setBounds(100, 100, 400, 300);
        helloFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        helloFrame.getContentPane().setLayout(new BorderLayout());


        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS)); 
        JLabel lblGreeting = new JLabel("Welcome to the Application!");
        lblGreeting.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblGreeting.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel lblUserName = new JLabel("Hello, " + name );
        lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUserName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblUserInfo = new JLabel("User logged in with email: " + email);
        lblUserInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUserInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        infoPanel.add(lblGreeting);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
        infoPanel.add(lblUserName); // Added user's name here
        infoPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
        infoPanel.add(lblUserInfo);

        helloFrame.getContentPane().add(infoPanel, BorderLayout.CENTER);


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBackground(new Color(52, 152, 219));
        btnLogout.setForeground(Color.BLACK);
        btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(btnLogout);
        
        helloFrame.getContentPane().add(panel, BorderLayout.SOUTH);

        helloFrame.setVisible(true);
        
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helloFrame.dispose();
            }
        });
    }
}
