package client.gui;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GUI extends JFrame {
	JPanel cards;
	
	public GUI(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {}
		
		cards = new JPanel(new CardLayout());
		cards.add(new LoginScreen(), "login");
		cards.add(new MainScreen(), "main");
		cards.add(new AddEvent(),"addEvent");
		cards.add(new AddMeeting(),"addMeeting");
		cards.add(new GroupSettings(),"Groups");
		add(cards);
		
		
		setTitle("G4Calendar");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/* Helper functions */
	
	void swapPane(String what) {
		CardLayout layout = (CardLayout) cards.getLayout();
		layout.show(cards, what);
	}
	
	private void setComponent(Component c){
		removeAll();
		add(c);
	}
}
