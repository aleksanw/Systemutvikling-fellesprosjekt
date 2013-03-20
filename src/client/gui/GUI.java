package client.gui;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

class GUI extends JFrame {
	JPanel cards;
	private LoginScreen loginScreen;
	private MainScreen mainScreen;
	private AddEvent addEvent;
	private AddMeeting addMeeting;
	private GroupSettings groupsetting;

	public GUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		this.loginScreen = new LoginScreen();
		this.mainScreen = new MainScreen();
		this.addEvent = new AddEvent();
		this.addMeeting = new AddMeeting();
		this.groupsetting = new GroupSettings();

		cards = new JPanel(new CardLayout());
		cards.add(this.loginScreen, "login");
		add(cards);

		setTitle("G4Calendar");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	void postLogin(){
		cards.add(this.mainScreen, "main");
		cards.add(this.addEvent, "addEvent");
		cards.add(this.addMeeting, "addMeeting");
		cards.add(this.groupsetting, "Groups");
		add(cards);
	}

	/* Helper functions */

	void swapPane(String what) {
		CardLayout layout = (CardLayout) cards.getLayout();
		layout.show(cards, what);
	}

	private void setComponent(Component c) {
		removeAll();
		add(c);
	}
}
