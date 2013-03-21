package client.gui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;

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
	private AnswerMeeting answerMeeting;

	public LoginScreen getLoginScreen() {
		return loginScreen;
	}

	public MainScreen getMainScreen() {
		return mainScreen;
	}

	public AddEvent getAddEvent() {
		return addEvent;
	}

	public AnswerMeeting getAnswerMeeting() {
		return this.answerMeeting;
	}
	
 	public AddMeeting getAddMeeting() {
		return addMeeting;
	}

	public GroupSettings getGroupsetting() {
		return groupsetting;
	}

	public GUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		this.loginScreen = new LoginScreen();
		

		cards = new JPanel(new CardLayout());
		cards.add(this.loginScreen, "login");
		add(cards);

		setTitle("G4Calendar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int height = 800;
		int with = (height * 16)/9;
		setSize(new Dimension(with, height));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}
	
	void refresh(){		
		this.mainScreen = new MainScreen();
		cards.add(this.mainScreen, "main");
	}
	
	void initCalender(){
		this.answerMeeting = new AnswerMeeting();
		this.addEvent = new AddEvent();
		this.addMeeting = new AddMeeting();
		this.groupsetting = new GroupSettings();
		cards.add(this.addEvent, "addEvent");
		cards.add(this.addMeeting, "addMeeting");
		cards.add(this.groupsetting, "Groups");
		cards.add(this.answerMeeting, "AnswerMeeting");
		refresh();
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
