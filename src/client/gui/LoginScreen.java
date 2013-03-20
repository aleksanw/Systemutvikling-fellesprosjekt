package client.gui;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import client.gui.widgets.LoginForm;
import client.gui.widgets.LoginForm.LoginEvent;
import client.gui.widgets.LoginListener;

import common.UserI;

class LoginScreen extends JPanel implements LoginListener {

	public LoginScreen() {
		this.setLayout(new MigLayout());
		LoginForm form = new LoginForm();
		form.setLoginListener(this);
		this.add(form, "push, center");
	}

	@Override
	public void loginAttempted(LoginEvent e) {
		UserI user;
		try {
			user = MainClass.sServer.userStorage.login(e.getUsername(),
					e.getPassword());
			if (user != null) {
				e.authSuccess();
				MainClass.setCurrentUser(user);
				MainClass.gui.postLogin();
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
