package client.gui.widgets;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;


public class LoginForm extends JPanel implements ActionListener, DocumentListener {
	private MyTextField usernameField;
	private MyPasswordField passwordField;
	private JLabel statuslabel;
	private LoginListener loginListener;
	private JButton loginbutton;

	public LoginForm() {
		this.setBackground(Color.decode("#eeeeee"));
		
		JLabel label = new JLabel("Login:");
		label.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		label.setForeground(Color.decode("#777777"));
		
		statuslabel = new JLabel();
		statuslabel.setFont(new Font("Sans Serif", Font.PLAIN, 10));
		
		usernameField = new MyTextField("username");
		usernameField.setColumns(20);
		usernameField.addActionListener(this);
		usernameField.getDocument().addDocumentListener(this);

		passwordField = new MyPasswordField("password");
		passwordField.setColumns(20);
		passwordField.addActionListener(this);
		passwordField.getDocument().addDocumentListener(this);
		
		loginbutton = new JButton("Login");
		
		this.setLayout(new MigLayout("", "[] 1cm [grow, center] [align right]"));
		this.add(label,         "cell 0 0 2 1");
		this.add(usernameField, "cell 1 1 2 1");
		this.add(passwordField, "cell 1 2 2 1");
		this.add(statuslabel,   "cell 1 3 1 1");
		this.add(loginbutton,   "cell 2 3 1 1");
	}


	
	/* ## State change ## */
	
	private void setBusy(){
		usernameField.setEnabled(false);
		passwordField.setEnabled(false);
		statuslabel.setForeground(Color.black);
		statuslabel.setText("Please wait..");
	}
	
	private void setFail(){
		usernameField.setEnabled(true);
		passwordField.setEnabled(true);
		statuslabel.setForeground(Color.red);
		statuslabel.setText("Wrong username or password!");
		usernameField.requestFocusInWindow();
	}
	
	private void setSucc(){
		usernameField.setEnabled(true);
		passwordField.setEnabled(true);
		passwordField.setText("");
		usernameField.requestFocusInWindow();
	}
	
	private void setNormal(){
		statuslabel.setText("");
	}


	
	/* ## Event handling ## */
	
	// Called when enter is pressed in one of the input-fields
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == usernameField) {
			passwordField.requestFocusInWindow();
		} else {
			setBusy();
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
	
	public class LoginEvent extends AWTEvent {
		String username, password;
		
		public LoginEvent(Object source, int id, String username, String password) {
			super(source, id);
			this.username = username;
			this.password = password;
		}

		public String getUsername() {	return username;	}
		public String getPassword() {	return password;	}
		public void authFailure() {		setFail();			}
		public void authSuccess() {		setSucc();			}
	}

	
	// Called when text is changed in one of the input-fields
	public void insertUpdate(DocumentEvent e) {		setNormal();	}
	public void removeUpdate(DocumentEvent e) {		setNormal();	}
	public void changedUpdate(DocumentEvent e) {}
}
