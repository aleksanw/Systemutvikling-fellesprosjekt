package gui.widgets;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.EventListenerList;

import net.miginfocom.swing.MigLayout;


@SuppressWarnings("serial")
public class LoginForm extends JPanel implements ActionListener {
	private MyTextField usernameField;
	private MyPasswordField passwordField;
	private EventListenerList listenerList;{
		listenerList = new EventListenerList();
	}

	public LoginForm() {
		this.setLayout(new MigLayout());
		this.setBackground(Color.decode("#eeeeee"));
		
		JLabel label = new JLabel("Login:");
		label.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		label.setForeground(Color.decode("#777777"));
		this.add(label, "wrap");
		
		usernameField = new MyTextField("username");
		usernameField.setColumns(20);
		usernameField.addActionListener(this);
		this.add(usernameField, "gapleft 20, wrap");
		
		passwordField = new MyPasswordField("password");
		passwordField.setColumns(20);
		passwordField.addActionListener(this);
		this.add(passwordField, "gapleft 20");
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
			this.fireLoginEvent(new LoginEvent(this,
											   e.getID(),
											   username,
											   password));
		}
	}
	
	private void fireLoginEvent(LoginEvent loginEvent) {
		for(LoginListener l: listenerList.getListeners(LoginListener.class)){
			l.loginAttempted(loginEvent);
		}
	}

	public void addLoginListener(LoginListener l) {
		this.listenerList.add(LoginListener.class, l);
	}
}
