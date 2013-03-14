package client.gui.widgets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import client.gui.widgets.LoginForm.LoginEvent;

public class LoginScreen extends JPanel implements LoginListener{
	
	public LoginScreen() {
		this.setLayout(new MigLayout());
		LoginForm form = new LoginForm();
		form.setLoginListener(this);
		this.add(form);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLayout(new MigLayout());
		f.add(new LoginScreen(), "push, center");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}

	@Override
	public void loginAttempted(LoginEvent e) {
		System.out.println(e.getUsername());
		System.out.println(e.getPassword());
		e.authFailure();
	}
}
