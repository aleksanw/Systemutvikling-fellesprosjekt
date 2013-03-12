package gui.widgets;

import java.awt.AWTEvent;

@SuppressWarnings("serial")
public class LoginEvent extends AWTEvent {
	String username, password;
	
	public LoginEvent(Object source, int id, String username, String password) {
		super(source, id);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
