package client.gui;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import client.gui.widgets.LoginForm;
import client.gui.widgets.LoginListener;
import client.gui.widgets.LoginForm.LoginEvent;

public class LoginScreen extends JPanel implements LoginListener{
	
	public LoginScreen() {
		this.setLayout(new MigLayout());
		LoginForm form = new LoginForm();
		form.setLoginListener(this);
		this.add(form, "push, center");
	}

	@Override
	public void loginAttempted(LoginEvent e) {
		if(e.getUsername().equals("fp") && e.getPassword().equals("ntnu")){
			e.authSuccess();
			MainClass.loginOK();
		} else {
			e.authFailure();
		}
	}
}
