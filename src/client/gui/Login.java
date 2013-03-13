package client.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JPanel implements ActionListener,KeyListener {

	private JLabel usernameLabel, passwordLabel;
	private JTextField usernameTextfield;
	private JPasswordField passwordTextfield;
	private JButton login;
	private static final String BRUKERNAVN = "fp";

	GridBagConstraints gbc = new GridBagConstraints();

	public Login() {
		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");

		usernameTextfield = new JTextField("Skriv inn ditt brukernavn");
		usernameTextfield.setColumns(20);
		usernameTextfield.addKeyListener(this);

		passwordTextfield = new JPasswordField();
		passwordTextfield.setColumns(20);
		passwordTextfield.addKeyListener(this);
		

		login = new JButton("Log in");
		login.addActionListener(this);

		setLayout(new GridBagLayout());

		gbc.gridy = 0;
		add(usernameLabel, gbc);
		add(usernameTextfield, gbc);

		gbc.gridy = 1;
		add(passwordLabel, gbc);
		add(passwordTextfield, gbc);

		gbc.gridy = 2;
		add(login, gbc);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Log in") ) {
			authorize();
		}
	}

	private boolean isCorrectPassword(char[] input) {
		char[] correctPassword = {'n','t','n','u'}; 
			if(Arrays.equals(input, correctPassword)){
				return true;
			}
		return false;
	}
	
	//Not in use
	public void keyPressed(KeyEvent key) {
	}
	
	public void login(){
		usernameTextfield.setText("Skriv inn ditt brukernavn");
		passwordTextfield.setText("");
		MainClass.loginOK();
	}

	private void authorize() {
		char [] input = passwordTextfield.getPassword();
		if (usernameTextfield.getText().equals(BRUKERNAVN) && isCorrectPassword(input)) {
			login();
		} else {
			usernameTextfield.setText("Feil brukernavn eller passord");
			passwordTextfield.setText("");
		}
	}

	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == 10){
			authorize();
		}
		
	}
	//Not in use
	public void keyTyped(KeyEvent k) {
	}
}
