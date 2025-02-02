
package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class LoginUI {
	public LoginUI() {
		JFrame loginFrame = new JFrame("Login");
		loginFrame.setBounds(100, 100, 400, 300);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(50, 80, 100, 25);
		loginFrame.getContentPane().add(lblEmail);

		JTextField emailField = new JTextField();
		emailField.setBounds(150, 80, 200, 25);
		loginFrame.getContentPane().add(emailField);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 130, 100, 25);
		loginFrame.getContentPane().add(lblPassword);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(150, 130, 200, 25);
		loginFrame.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(150, 180, 200, 30);
		btnLogin.setBackground(new Color(52, 152, 219));
		btnLogin.setForeground(Color.BLACK);
		loginFrame.getContentPane().add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = emailField.getText();
				String password = new String(passwordField.getPassword());

				ReturnedUser response = JDBC.chekLogin(email, password);
				if (response.success == true) {
					JOptionPane.showMessageDialog(loginFrame, response.msg, "Success", JOptionPane.INFORMATION_MESSAGE);
					loginFrame.dispose();
					new LandingPage(response.user.id, response.user.name, response.user.email);

				} else {
					JOptionPane.showMessageDialog(loginFrame, response.msg, "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		loginFrame.setVisible(true);
	}
}