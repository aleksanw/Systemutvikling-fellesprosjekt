package gui.widgets;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;


@SuppressWarnings("serial")
public class LoginForm extends JPanel implements ActionListener {
	private MyTextField usernameField;
	private MyPasswordField passwordField;
	private LoginListener loginListener;

	public LoginForm() {
		this.setLayout(new MigLayout());
		this.setBackground(Color.decode("#eeeeee"));
		
		JLabel label = new JLabel("Login:");
		label.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		label.setForeground(Color.decode("#777777"));

		usernameField = new MyTextField("username");
		usernameField.setColumns(20);
		usernameField.addActionListener(this);

		passwordField = new MyPasswordField("password");
		passwordField.setColumns(20);
		passwordField.addActionListener(this);
		
		this.add(label, "wrap");
		this.add(usernameField, "gapleft 7mm, wrap");
		this.add(passwordField, "gapleft 7mm");
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.add(new LoginForm());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == usernameField) {
			passwordField.requestFocusInWindow();
		} else {
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());
			this.fireLoginEvent(e.getID(), username, password);
		}
	}
	
	private void fireLoginEvent(int id, String username, String password) {
		if(loginListener == null)
			return;
		
		LoginEvent e = new LoginEvent(this, id, username, password);
		loginListener.loginAttempted(e);
	}

	public void setLoginListener(LoginListener l) {
		this.loginListener = l;
	}
}
