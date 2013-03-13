package gui.widgets;

import java.util.EventListener;

public interface LoginListener extends EventListener{
	public void loginAttempted(LoginEvent e);
}
