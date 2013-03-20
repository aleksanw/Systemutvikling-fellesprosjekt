package client.gui;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import client.gui.widgets.LoginForm;
import client.gui.widgets.LoginForm.LoginEvent;
import client.gui.widgets.LoginListener;

class LoginScreen extends JPanel implements LoginListener {

	public LoginScreen() {
		this.setLayout(new MigLayout());
		LoginForm form = new LoginForm();
		form.setLoginListener(this);
		this.add(form, "push, center");
	}

	@Override
	public void loginAttempted(LoginEvent e) {
		// if (e.getUsername().equals("fp") && e.getPassword().equals("ntnu")) {
		try {
			if (MainClass.sServer.userStorage.login(e.getUsername(),
					e.getPassword()) != null) {
				e.authSuccess();
				MainClass.loginOK();
			} else {
				e.authFailure();
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		}
	}
}
